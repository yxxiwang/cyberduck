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

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;

import com.apple.cocoa.foundation.NSMutableDictionary;

/**
 * @version $Id$
 */
public class SyncQueue extends Queue {

	/**
	 * The observer to notify when an upload is complete
	 */
	private Observer callback;

	public SyncQueue() {
		//
	}

	public SyncQueue(Path root, Observer callback) {
		this.callback = callback;
		this.addRoot(root);
	}

	public SyncQueue(java.util.Observer callback) {
		this.callback = callback;
	}

	public NSMutableDictionary getAsDictionary() {
		NSMutableDictionary dict = super.getAsDictionary();
		dict.setObjectForKey(Queue.KIND_SYNC+"", "Kind");
		return dict;
	}

	public void callObservers(Object arg) {
		super.callObservers(arg);
		if(arg instanceof Message) {
			Message msg = (Message)arg;
			if(msg.getTitle().equals(Message.QUEUE_STOP)) {
				if(this.isComplete()) {
					if(callback != null) {
						callback.update(null, new Message(Message.REFRESH));
					}
				}
			}
		}
	}

	private void addLocalChilds(List childs, Path root) {
		if(root.getLocal().exists()) {
			if(!childs.contains(root)) {
				childs.add(root);
			}
			if(root.attributes.isDirectory()) {
				File[] files = root.getLocal().listFiles();
				for(int i = 0; i < files.length; i++) {
					Path child = PathFactory.createPath(root.getSession(), root.getAbsolute(), new Local(files[i].getAbsolutePath()));
					if(!child.getName().equals(".DS_Store")) {
						this.addLocalChilds(childs, child);
					}
				}
			}
		}
	}

	private void addRemoteChilds(List childs, Path root) {
		if(root.getRemote().exists()) {
			if(!childs.contains(root)) {
				childs.add(root);
			}
			if(root.attributes.isDirectory() && !root.attributes.isSymbolicLink()) {
				for(Iterator i = root.list(false, true).iterator(); i.hasNext();) {
					Path child = (Path)i.next();
					child.setLocal(new Local(root.getLocal(), child.getName()));
					this.addRemoteChilds(childs, child);
				}
			}
		}
	}

	protected List getChilds(List childs, Path root) {
		this.addRemoteChilds(childs, root);
		this.addLocalChilds(childs, root);
		return childs;
	}

	protected void reset() {
		this.size = 0;
		for(Iterator iter = this.getJobs().iterator(); iter.hasNext();) {
			Path path = ((Path)iter.next());
			if(path.getRemote().exists() && path.getLocal().exists()) {
				if(path.getLocal().getTimestamp().before(path.attributes.getTimestamp())) {
					this.size += path.getRemote().attributes.getSize();
				}
				if(path.getLocal().getTimestamp().after(path.attributes.getTimestamp())) {
					this.size += path.getLocal().getSize();
				}
			}
			else if(path.getRemote().exists()) {
				this.size += path.getRemote().attributes.getSize();
			}
			else if(path.getLocal().exists()) {
				this.size += path.getLocal().getSize();
			}
		}
	}

	protected void process(Path p) {
		p.sync();
	}
}