package ch.cyberduck.ui.cocoa;

/*
 *  Copyright (c) 2004 David Kocher. All rights reserved.
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

import com.apple.cocoa.application.NSApplication;
import com.apple.cocoa.application.NSWindow;
import com.apple.cocoa.foundation.NSNotification;
import com.apple.cocoa.foundation.NSSelector;
import com.apple.cocoa.foundation.NSArray;
import com.apple.cocoa.foundation.NSPoint;

import org.apache.log4j.Logger;

/**
 * @version $Id$
 */
public abstract class CDController {
	protected static Logger log = Logger.getLogger(CDController.class);

	private NSWindow window; // IBOutlet

	public void setWindow(NSWindow window) {
		this.window = window;
		this.window.setDelegate(this);
	}

	public NSWindow window() {
		return this.window;
	}

	public abstract void awakeFromNib();

	public boolean windowShouldClose(NSWindow sender) {
		return true;
	}	
	
	public abstract void windowWillClose(NSNotification notification);

	public void cascade() {
		NSArray windows = NSApplication.sharedApplication().windows();
		int count = windows.count();
		if(count != 0) {
			while(0 != count--) {
				NSWindow window = (NSWindow)windows.objectAtIndex(count);
				//				CDBrowserController controller = CDBrowserController.controllerForWindow(window);
				//				if(null != controller) {
				NSPoint origin = window.frame().origin();
				origin = new NSPoint(origin.x(), origin.y()+window.frame().size().height());
				this.window().setFrameTopLeftPoint(this.window().cascadeTopLeftFromPoint(origin));
				break;
				//				}
			}
		}
	}
	
	public void endSheet() {
		log.debug("endSheet");
		if(this.hasSheet()) {
			NSApplication.sharedApplication().endSheet(this.window().attachedSheet());
		}
	}
	
	public void waitForSheet() {
		synchronized(this) {
			while(this.window().attachedSheet() != null) {
				try {
					log.debug("Sleeping..."); this.wait(); log.debug("Awakened");
				}
				catch(InterruptedException e) {
					log.error(e.getMessage());
				}
			}
		}
	}
	
	public void beginSheet(NSWindow sheet) {
		this.beginSheet(sheet, new NSSelector("sheetDidEnd",
									   new Class[]{NSWindow.class, int.class, Object.class}) // did end selector
						);
	}
	
	public void beginSheet(NSWindow sheet, NSSelector endSelector) {
		this.beginSheet(sheet, endSelector, null);
	}
	
	public void beginSheet(NSWindow sheet, NSSelector endSelector, Object contextInfo) {
		this.beginSheet(sheet, this, endSelector, contextInfo);
	}

	public void beginSheet(NSWindow sheet, Object delegate, NSSelector endSelector, Object contextInfo) {
		synchronized(this) {
			log.debug("beginSheet");
			this.waitForSheet();
			this.window().makeKeyAndOrderFront(null);
			NSApplication.sharedApplication().beginSheet(sheet, //sheet
														 this.window(),
														 delegate, //modalDelegate
														 endSelector, // did end selector
														 contextInfo); //contextInfo
			this.window().makeKeyAndOrderFront(null);
		}
	}

	public void sheetDidEnd(NSWindow window, int returncode, Object contextInfo) {
		log.debug("sheetDidEnd:"+window);
		window.orderOut(null);
		synchronized(this) {
			this.notifyAll();
		}
	}

	public boolean hasSheet() {
		return this.window().attachedSheet() != null;
	}
}