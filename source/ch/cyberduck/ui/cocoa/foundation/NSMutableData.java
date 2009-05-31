package ch.cyberduck.ui.cocoa.foundation;

/*
 * Copyright (c) 2002-2009 David Kocher. All rights reserved.
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

/// <i>native declaration : :81</i>
public abstract class NSMutableData extends NSData {
    private static final _Class CLASS = org.rococoa.Rococoa.createClass("NSMutableData", _Class.class);

    public static NSMutableData dataWithCapacity(int aNumItems) {
        return CLASS.dataWithCapacity(aNumItems);
    }

    public static NSMutableData dataWithLength(int length) {
        return CLASS.dataWithLength(length);
    }

    public interface _Class extends org.rococoa.NSClass {
        /**
         * Original signature : <code>dataWithCapacity(NSUInteger)</code><br>
         * <i>from NSMutableDataCreation native declaration : :104</i>
         */
        NSMutableData dataWithCapacity(int aNumItems);

        /**
         * Original signature : <code>dataWithLength(NSUInteger)</code><br>
         * <i>from NSMutableDataCreation native declaration : :105</i>
         */
        NSMutableData dataWithLength(int length);
    }

    /**
     * Original signature : <code>void* mutableBytes()</code><br>
     * <i>native declaration : :83</i>
     */
    public abstract com.sun.jna.Pointer mutableBytes();

    /**
     * Original signature : <code>void setLength(NSUInteger)</code><br>
     * <i>native declaration : :84</i>
     */
    public abstract void setLength(int length);

    /**
     * Original signature : <code>void appendBytes(const void*, NSUInteger)</code><br>
     * <i>from NSExtendedMutableData native declaration : :90</i>
     */
    public abstract void appendBytes_length(com.sun.jna.Pointer bytes, int length);

    /**
     * Original signature : <code>void appendData(NSData*)</code><br>
     * <i>from NSExtendedMutableData native declaration : :91</i>
     */
    public abstract void appendData(NSData other);

    /**
     * Original signature : <code>void increaseLengthBy(NSUInteger)</code><br>
     * <i>from NSExtendedMutableData native declaration : :92</i>
     */
    public abstract void increaseLengthBy(int extraLength);
    /**
     * <i>from NSExtendedMutableData native declaration : :93</i><br>
     * Conversion Error : /// Original signature : <code>void replaceBytesInRange(null, const void*)</code><br>
     * - (void)replaceBytesInRange:(null)range withBytes:(const void*)bytes; (Argument range cannot be converted)
     */
    /**
     * <i>from NSExtendedMutableData native declaration : :94</i><br>
     * Conversion Error : /// Original signature : <code>void resetBytesInRange(null)</code><br>
     * - (void)resetBytesInRange:(null)range; (Argument range cannot be converted)
     */
    /**
     * Original signature : <code>void setData(NSData*)</code><br>
     * <i>from NSExtendedMutableData native declaration : :95</i>
     */
    public abstract void setData(NSData data);
    /**
     * <i>from NSExtendedMutableData native declaration : :97</i><br>
     * Conversion Error : /// Original signature : <code>void replaceBytesInRange(null, const void*, NSUInteger)</code><br>
     * - (void)replaceBytesInRange:(null)range withBytes:(const void*)replacementBytes length:(NSUInteger)replacementLength; (Argument range cannot be converted)
     */
    /**
     * Original signature : <code>initWithCapacity(NSUInteger)</code><br>
     * <i>from NSMutableDataCreation native declaration : :106</i>
     */
    public abstract NSMutableData initWithCapacity(int capacity);

    /**
     * Original signature : <code>initWithLength(NSUInteger)</code><br>
     * <i>from NSMutableDataCreation native declaration : :107</i>
     */
    public abstract NSMutableData initWithLength(int length);
}
