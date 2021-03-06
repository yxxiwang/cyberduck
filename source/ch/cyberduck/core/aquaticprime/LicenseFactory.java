package ch.cyberduck.core.aquaticprime;

/*
 * Copyright (c) 2002-2010 David Kocher. All rights reserved.
 *
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * dkocher@cyberduck.ch
 */

import ch.cyberduck.core.*;
import ch.cyberduck.core.i18n.Locale;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @version $Id$
 */
public abstract class LicenseFactory extends Factory<License> {
    private static Logger log = Logger.getLogger(LicenseFactory.class);

    /**
     * Registered factories
     */
    protected static final Map<Platform, LicenseFactory> factories
            = new HashMap<Platform, LicenseFactory>();

    /**
     * @param platform
     * @param f
     */
    public static void addFactory(Factory.Platform platform, LicenseFactory f) {
        factories.put(platform, f);
    }

    /**
     * @param file
     * @return
     */
    protected abstract License open(Local file);

    protected License open() {
        Local support = LocalFactory.createLocal(Preferences.instance().getProperty("application.support.path"));
        if(support.exists()) {
            for(Local key : support.children(new PathFilter<Local>() {
                public boolean accept(Local file) {
                    return "cyberducklicense".equals(FilenameUtils.getExtension(file.getName()));
                }
            })) {
                return open(key);
            }
            // No key found. Look for receipt
            for(Local key : support.children(new PathFilter<Local>() {
                public boolean accept(Local file) {
                    return "cyberduckreceipt".equals(FilenameUtils.getExtension(file.getName()));
                }
            })) {
                return new Receipt(key);
            }
        }
        log.info("No donation key found");
        return LicenseFactory.EMPTY_LICENSE;
    }

    /**
     * @return
     */
    public static License create(Local file) {
        if(!factories.containsKey(NATIVE_PLATFORM)) {
            throw new RuntimeException("No implementation for " + NATIVE_PLATFORM);
        }
        return factories.get(NATIVE_PLATFORM).open(file);
    }

    /**
     * @return If no license is installed a dummy license is returned.
     * @see #EMPTY_LICENSE
     */
    public static License find() {
        if(!factories.containsKey(NATIVE_PLATFORM)) {
            throw new RuntimeException("No implementation for " + NATIVE_PLATFORM);
        }
        return factories.get(NATIVE_PLATFORM).open();
    }

    public static final License EMPTY_LICENSE = new License() {
        public boolean verify() {
            return false;
        }

        public String getValue(String property) {
            return null;
        }

        public String getName() {
            return Locale.localizedString("Not a valid donation key", "License");
        }

        public boolean isReceipt() {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            return EMPTY_LICENSE == obj;
        }

        @Override
        public String toString() {
            return Locale.localizedString("Not a valid donation key", "License");
        }
    };
}
