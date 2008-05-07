package ch.cyberduck.ui.cocoa.threading;

/*
 *  Copyright (c) 2008 David Kocher. All rights reserved.
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

import com.apple.cocoa.foundation.NSBundle;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @version $Id:$
 */
public abstract class AbstractBackgroundAction implements BackgroundAction {

    public void init() {
        ;
    }

    private boolean canceled;

    public void cancel() {
        canceled = true;
        BackgroundActionListener[] l = (BackgroundActionListener[]) listeners.toArray(
                new BackgroundActionListener[listeners.size()]);
        for(int i = 0; i < l.length; i++) {
            l[i].cancel(this);
        }
    }

    /**
     * To be overriden by a concrete subclass. Returns false by default for actions
     * not connected to a graphical user interface
     *
     * @return True if the user canceled this action
     */
    public boolean isCanceled() {
        return canceled;
    }

    private boolean running;

    public boolean isRunning() {
        return running;
    }

    public boolean prepare() {
        running = true;
        BackgroundActionListener[] l = (BackgroundActionListener[]) listeners.toArray(
                new BackgroundActionListener[listeners.size()]);
        for(int i = 0; i < l.length; i++) {
            l[i].start(this);
        }
        return true;
    }

    public void finish() {
        running = false;
        BackgroundActionListener[] l = (BackgroundActionListener[]) listeners.toArray(
                new BackgroundActionListener[listeners.size()]);
        for(int i = 0; i < l.length; i++) {
            l[i].stop(this);
        }
    }

    private Set listeners = Collections.synchronizedSet(new HashSet());

    public void addListener(BackgroundActionListener listener) {
        listeners.add(listener);
    }

    public void removeListener(BackgroundActionListener listener) {
        listeners.remove(listener);
    }

    public String getActivity() {
        return NSBundle.localizedString("Unknown", "");
    }

    private final Object lock = new Object();

    public Object lock() {
        // No synchronization with other tasks by default
        return lock;
    }
}