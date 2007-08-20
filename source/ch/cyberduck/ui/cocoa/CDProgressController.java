package ch.cyberduck.ui.cocoa;

/*
 *  Copyright (c) 2005 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import ch.cyberduck.core.AbstractCollectionListener;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.ProgressListener;
import ch.cyberduck.core.Status;
import ch.cyberduck.core.Transfer;
import ch.cyberduck.core.TransferCollection;
import ch.cyberduck.core.TransferListener;
import ch.cyberduck.core.io.BandwidthThrottle;
import ch.cyberduck.ui.cocoa.delegate.MenuDelegate;
import ch.cyberduck.ui.cocoa.delegate.TransferMenuDelegate;
import ch.cyberduck.ui.cocoa.growl.Growl;

import com.apple.cocoa.application.*;
import com.apple.cocoa.foundation.NSAttributedString;
import com.apple.cocoa.foundation.NSBundle;
import com.apple.cocoa.foundation.NSDictionary;
import com.apple.cocoa.foundation.NSRunLoop;
import com.apple.cocoa.foundation.NSSelector;
import com.apple.cocoa.foundation.NSTimer;

import org.apache.log4j.Logger;

/**
 * @version $Id$
 */
public class CDProgressController extends CDController {
    private static Logger log = Logger.getLogger(CDProgressController.class);

    private static NSMutableParagraphStyle lineBreakByTruncatingMiddleParagraph = new NSMutableParagraphStyle();
    private static NSMutableParagraphStyle lineBreakByTruncatingTailParagraph = new NSMutableParagraphStyle();

    static {
        lineBreakByTruncatingMiddleParagraph.setLineBreakMode(NSParagraphStyle.LineBreakByTruncatingMiddle);
        lineBreakByTruncatingTailParagraph.setLineBreakMode(NSParagraphStyle.LineBreakByTruncatingTail);
    }

    private static final NSDictionary TRUNCATE_MIDDLE_PARAGRAPH_DICTIONARY = new NSDictionary(new Object[]{lineBreakByTruncatingMiddleParagraph},
            new Object[]{NSAttributedString.ParagraphStyleAttributeName});

    /**
     * 
     */
    private Transfer transfer;

    /**
     * The current connection status message
     * @see ch.cyberduck.core.ProgressListener#message(String) 
     */
    private String progressText;

    public CDProgressController(final Transfer transfer) {
        this.transfer = transfer;
        TransferCollection.instance().addListener(new AbstractCollectionListener() {
            public void collectionItemRemoved(Object item) {
                if(item.equals(CDProgressController.this)) {
                    CDProgressController.this.invalidate();
                }
            }
        });
        synchronized(NSApplication.sharedApplication()) {
            if(!NSApplication.loadNibNamed("Progress", this)) {
                log.fatal("Couldn't load Progress.nib");
            }
        }
        this.init();
    }

    private void init() {
        final ProgressListener pl = new ProgressListener() {
            public void message(final String message) {
                progressText = message;
                CDProgressController.this.invoke(new Runnable() {
                    public void run() {
                        setProgressText();
                    }
                });
            }
        };
        this.transfer.getSession().addProgressListener(pl);
        final TransferListener tl = new TransferListener() {
            /**
             * Timer to update the progress indicator
             */
            private NSTimer progressTimer;

            public void transferWillStart() {
                CDProgressController.this.invoke(new Runnable() {
                    public void run() {
                        progressBar.setHidden(false);
                        progressBar.setIndeterminate(true);
                        progressBar.startAnimation(null);
                        progressBar.setNeedsDisplay(true);
                        statusIconView.setImage(RED_ICON);
                        setProgressText();
                        setStatusText();
                    }
                });
            }

            public void transferPaused() {
                CDProgressController.this.invoke(new Runnable() {
                    public void run() {
                        Growl.instance().notify("Transfer queued", transfer.getHost().getHostname());
                        statusIconView.setImage(YELLOW_ICON);
                    }
                });
            }

            public void transferResumed() {
                CDProgressController.this.invoke(new Runnable() {
                    public void run() {
                        statusIconView.setImage(RED_ICON);
                    }
                });
            }

            public void transferDidEnd() {
                CDProgressController.this.invoke(new Runnable() {
                    public void run() {
                        // Do not display any progress text when transfer is stopped
                        progressText = null;
                        setProgressText();
                        setStatusText();
                        progressBar.setIndeterminate(true);
                        progressBar.stopAnimation(null);
                        progressBar.setHidden(true);
                        statusIconView.setImage(transfer.isComplete() ? GREEN_ICON : RED_ICON);
                    }
                });
            }

            public void willTransferPath(final Path path) {
                meter.reset();
                progressTimer = new NSTimer(0.1, //seconds
                        CDProgressController.this, //target
                        new NSSelector("update", new Class[]{NSTimer.class}),
                        transfer, //userInfo
                        true); //repeating
                CDMainController.mainRunLoop.addTimerForMode(progressTimer,
                        NSRunLoop.DefaultRunLoopMode);
            }

            public void didTransferPath(final Path path) {
                progressTimer.invalidate();
                meter.reset();
            }

            public void bandwidthChanged(BandwidthThrottle bandwidth) {
                meter.reset();
            }
        };
        this.transfer.addListener(tl);
        this.meter = new Speedometer();
    }

    /**
     * Resets both the progress and status field
     */
    public void awakeFromNib() {
        this.setProgressText();
        this.setStatusText();
    }

    /**
     * Called from the main run loop using a NSTimer #progressTimer
     *
     * @param t
     */
    public void update(final NSTimer t) {
        setProgressText();
        if(!transfer.isVirgin()) {
            progressBar.setIndeterminate(false);
            progressBar.setMinValue(0);
            progressBar.setMaxValue(transfer.getSize());
            progressBar.setDoubleValue(transfer.getTransferred());
        }
        else if(transfer.isRunning()) {
            progressBar.setIndeterminate(true);
        }
    }

    /**
     * Keeping track of the current transfer rate
     */
    private Speedometer meter;

    private class Speedometer {
        //the time to start counting bytes transfered
        private long timestamp;
        //initial data already transfered
        private double initialBytesTransfered;
        private double bytesTransferred;

        public Speedometer() {
            this.reset();
        }

        /**
         * Returns the data transfer rate. The rate should depend on the transfer
         * rate timestamp.
         *
         * @return The bytes being processed per second
         */
        public float getSpeed() {
            bytesTransferred = transfer.getTransferred();
            if(bytesTransferred > initialBytesTransfered) {
                if(0 == initialBytesTransfered) {
                    initialBytesTransfered = bytesTransferred;
                    return -1;
                }
                // number of seconds data was actually transferred
                double elapsedSeconds = (System.currentTimeMillis() - timestamp) / 1000;
                if(elapsedSeconds > 1) {
                    // bytes per second
                    return (float) ((bytesTransferred - initialBytesTransfered) / (elapsedSeconds));
                }
            }
            return -1;
        }

        public double getBytesTransfered() {
            return bytesTransferred;
        }

        /**
         * Reset this meter
         */
        public void reset() {
            this.timestamp = System.currentTimeMillis();
            this.initialBytesTransfered = transfer.getTransferred();
            this.bytesTransferred = 0;
        }
    }

    private void setProgressText() {
        StringBuffer b = new StringBuffer();
        b.append(Status.getSizeAsString(transfer.getTransferred()));
        b.append(" ");
        b.append(NSBundle.localizedString("of", "1.2MB of 3.4MB"));
        b.append(" ");
        b.append(Status.getSizeAsString(transfer.getSize()));
        if(transfer.isRunning()) {
            float speed = meter.getSpeed();
            if(speed > 0) {
                b.append(" (");
                b.append(Status.getSizeAsString(speed));
                b.append("/sec");
                if(transfer.getSize() > 0) {
                    b.append(", ");
                    // remaining time in seconds
                    double remaining = ((transfer.getSize() - meter.getBytesTransfered()) / speed);
                    b.append(Status.getRemainingAsString(remaining));
                }
                b.append(")");
            }
        }
        if(progressText != null) {
            b.append(" \u2013 ");
            b.append(progressText);
        }
        progressField.setAttributedStringValue(new NSAttributedString(
                b.toString(),
                TRUNCATE_MIDDLE_PARAGRAPH_DICTIONARY));
    }

    private void setStatusText() {
        StringBuffer b = new StringBuffer();
        if(!transfer.isRunning()) {
            b.append(transfer.isComplete() ? NSBundle.localizedString("Transfer complete", "Status", "") :
                    NSBundle.localizedString("Transfer incomplete", "Status", ""));
        }
        statusField.setAttributedStringValue(new NSAttributedString(
                b.toString(),
                TRUNCATE_MIDDLE_PARAGRAPH_DICTIONARY));
    }

    /**
     * The item is selected
     */
    private boolean highlighted;

    public void setHighlighted(final boolean highlighted) {
        this.highlighted = highlighted;
        if(highlighted) {
            statusField.setTextColor(NSColor.whiteColor());
            progressField.setTextColor(NSColor.whiteColor());
        }
        else {
            statusField.setTextColor(NSColor.darkGrayColor());
            progressField.setTextColor(NSColor.darkGrayColor());
        }
    }

    public boolean isHighlighted() {
        return this.highlighted;
    }

    // ----------------------------------------------------------
    // Outlets
    // ----------------------------------------------------------

    private NSPopUpButton filesPopup; // IBOutlet

    private NSMenu filesPopupMenu;

    private MenuDelegate filesPopupMenuDelegate;

    public void setFilesPopup(NSPopUpButton filesPopup) {
        this.filesPopup = filesPopup;
        this.filesPopup.setMenu(filesPopupMenu = new NSMenu());
        this.filesPopupMenu.setDelegate(filesPopupMenuDelegate
                = new TransferMenuDelegate(transfer.getRoots()));
        this.filesPopup.setTitle(transfer.getRoot().getName());
    }

    private NSTextField progressField; // IBOutlet

    public void setProgressField(final NSTextField progressField) {
        this.progressField = progressField;
        this.progressField.setEditable(false);
        this.progressField.setSelectable(false);
        this.progressField.setTextColor(NSColor.darkGrayColor());
    }

    private NSTextField statusField; // IBOutlet

    public void setStatusField(final NSTextField statusField) {
        this.statusField = statusField;
        this.statusField.setEditable(false);
        this.statusField.setSelectable(false);
        this.statusField.setTextColor(NSColor.darkGrayColor());
    }

    private NSProgressIndicator progressBar; // IBOutlet

    public void setProgressBar(final NSProgressIndicator progressBar) {
        this.progressBar = progressBar;
        this.progressBar.setDisplayedWhenStopped(false);
        this.progressBar.setControlTint(NSProgressIndicator.BlueControlTint);
        this.progressBar.setControlSize(NSProgressIndicator.SmallControlSize);
        this.progressBar.setStyle(NSProgressIndicator.ProgressIndicatorBarStyle);
        this.progressBar.setUsesThreadedAnimation(true);
    }

    private NSImageView statusIconView; //IBOutlet

    private static final NSImage RED_ICON = NSImage.imageNamed("statusRed.tiff");
    private static final NSImage GREEN_ICON = NSImage.imageNamed("statusGreen.tiff");
    private static final NSImage YELLOW_ICON = NSImage.imageNamed("statusYellow.tiff");

    public void setStatusIconView(final NSImageView statusIconView) {
        this.statusIconView = statusIconView;
        if(transfer.isQueued()) {
            this.statusIconView.setImage(YELLOW_ICON);
        }
        else {
            this.statusIconView.setImage(transfer.isComplete() ? GREEN_ICON : RED_ICON);
        }
    }

    /**
     * The view drawn in the table cell
     */
    private NSView progressView; // IBOutlet

    public void setProgressView(final NSView v) {
        this.progressView = v;
    }

    public NSView view() {
        return this.progressView;
    }
}