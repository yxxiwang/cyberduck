package ch.cyberduck.core;

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

import com.apple.cocoa.foundation.NSBundle;

import org.apache.log4j.Logger;

/**
 * The Status class is the model of a download's status.
 * The wrapper for any status informations of a transfer as the size and transferred
 * bytes.
 *
 * @version $Id$
 */
public class Status /*extends Observable*/ {
	private static Logger log = Logger.getLogger(Status.class);

	/**
	 * Download is resumable
	 */
	private boolean resume = false;
	/**
	 * The number of transfered bytes. Must be less or equals size.
	 */
	private long current = 0;
	/**
	 * Indiciating wheter the transfer has been cancled by the user.
	 */
	private boolean canceled;
	/**
	 * Indicates that the last action has been completed.
	 */
	private boolean complete = false;

	private static final long KILO = 1024l; //2^10
	private static final long MEGA = 1048576l; // 2^20
	private static final long GIGA = 1073741824l; // 2^30

	/**
	 * @return The size of the file
	 */
	public static String getSizeAsString(long size) {
		if(-1 == size) {
			return NSBundle.localizedString("Unknown size", "");
		}
		if(size < KILO) {
			return size+"B";
		}
		if(size < MEGA) {
			return String.valueOf(size/KILO)+"kB";
		}
		if(size < GIGA) {
			return String.valueOf(size/MEGA)+"MB";
		}
		else {
			return String.valueOf(size/GIGA)+"GB";
		}
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
		log.info("------------------- Complete:"+this.getCurrent());
	}

	public boolean isComplete() {
		return this.complete;
	}

	public void setCanceled(boolean b) {
		canceled = b;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public long getCurrent() {
		return this.current;
	}

	/**
	 * @param current The currently transfered bytes
	 */
	public void setCurrent(long current) {
		this.current = current;
	}

	public void setResume(boolean resume) {
		log.info("setResume:"+resume);
		this.resume = resume;
	}

	public boolean isResume() {
		return this.resume;
	}

	public void reset() {
		log.debug("reset (resume="+resume+")");
		this.complete = false;
		this.canceled = false;
		this.setCurrent(this.isResume() ? this.getCurrent() : 0);
	}
}
