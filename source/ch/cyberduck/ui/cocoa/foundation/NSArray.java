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

import org.rococoa.Rococoa;

/// <i>native declaration : /Users/dkocher/null:14</i>
public abstract class NSArray implements NSObject, NSFastEnumeration {
    private static final _Class CLASS = Rococoa.createClass("NSArray", _Class.class);

    public static NSArray array() {
        return CLASS.array();
    }

    public static NSArray arrayWithArray(NSArray array) {
        return CLASS.arrayWithArray(array);
    }

    public static NSArray arrayWithContentsOfFile(String path) {
        return CLASS.arrayWithContentsOfFile(path);
    }

    public static NSArray arrayWithContentsOfURL(NSURL url) {
        return CLASS.arrayWithContentsOfURL(url);
    }

    public static NSArray arrayWithObject(NSObject anObject) {
        return CLASS.arrayWithObject(anObject);
    }

    public static NSArray arrayWithObject(String anObject) {
        return CLASS.arrayWithObject(anObject);
    }

    public static NSArray arrayWithObjects(NSObject... arrayWithObjects) {
        return CLASS.arrayWithObjects(arrayWithObjects);
    }

    public static NSArray arrayWithObjects(String... arrayWithObjects) {
        return CLASS.arrayWithObjects(arrayWithObjects);
    }

    public static NSArray arrayWithObjects_count(NSObject objects, int cnt) {
        return CLASS.arrayWithObjects_count(objects, cnt);
    }

    public interface _Class extends org.rococoa.NSClass {
        /**
         * Original signature : <code>id array()</code><br>
         * <i>from NSArrayCreation native declaration : /Users/dkocher/null:60</i>
         */
        NSArray array();

        /**
         * Original signature : <code>id arrayWithObject(id)</code><br>
         * <i>from NSArrayCreation native declaration : /Users/dkocher/null:61</i>
         */
        NSArray arrayWithObject(NSObject anObject);

        NSArray arrayWithObject(String anObject);

        /**
         * Original signature : <code>id arrayWithObjects(const id*, NSUInteger)</code><br>
         * <i>from NSArrayCreation native declaration : /Users/dkocher/null:62</i>
         */
        NSArray arrayWithObjects_count(NSObject objects, int cnt);

        /**
         * Original signature : <code>id arrayWithObjects(id, null)</code><br>
         * <i>from NSArrayCreation native declaration : /Users/dkocher/null:63</i>
         */
        NSArray arrayWithObjects(NSObject... varargs);

        NSArray arrayWithObjects(String... varargs);

        /**
         * Original signature : <code>id arrayWithArray(NSArray*)</code><br>
         * <i>from NSArrayCreation native declaration : /Users/dkocher/null:64</i>
         */
        NSArray arrayWithArray(NSArray array);

        /**
         * Original signature : <code>id arrayWithContentsOfFile(NSString*)</code><br>
         * <i>from NSArrayCreation native declaration : /Users/dkocher/null:71</i>
         */
        NSArray arrayWithContentsOfFile(String path);

        /**
         * Original signature : <code>id arrayWithContentsOfURL(NSURL*)</code><br>
         * <i>from NSArrayCreation native declaration : /Users/dkocher/null:72</i>
         */
        NSArray arrayWithContentsOfURL(NSURL url);
    }

    /**
     * Original signature : <code>NSUInteger count()</code><br>
     * <i>native declaration : /Users/dkocher/null:16</i>
     */
    public abstract int count();

    /**
     * Original signature : <code>objectAtIndex(NSUInteger)</code><br>
     * <i>native declaration : /Users/dkocher/null:17</i>
     */
    public abstract NSObject objectAtIndex(int index);
    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:23</i><br>
     * Conversion Error : /// Original signature : <code>NSArray* arrayByAddingObject(null)</code><br>
     * - (NSArray*)arrayByAddingObject:(null)anObject; (Argument anObject cannot be converted)
     */
    /**
     * Original signature : <code>NSArray* arrayByAddingObjectsFromArray(NSArray*)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:24</i>
     */
    public abstract NSArray arrayByAddingObjectsFromArray(NSArray otherArray);

    /**
     * Original signature : <code>NSString* componentsJoinedByString(NSString*)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:25</i>
     */
    public abstract String componentsJoinedByString(String separator);
    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:26</i><br>
     * Conversion Error : /// Original signature : <code>BOOL containsObject(null)</code><br>
     * - (BOOL)containsObject:(null)anObject; (Argument anObject cannot be converted)
     */
    /**
     * Original signature : <code>NSString* description()</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:27</i>
     */
    public abstract String description();
    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:28</i><br>
     * Conversion Error : /// Original signature : <code>NSString* descriptionWithLocale(null)</code><br>
     * - (NSString*)descriptionWithLocale:(null)locale; (Argument locale cannot be converted)
     */
    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:29</i><br>
     * Conversion Error : /// Original signature : <code>NSString* descriptionWithLocale(null, NSUInteger)</code><br>
     * - (NSString*)descriptionWithLocale:(null)locale indent:(NSUInteger)level; (Argument locale cannot be converted)
     */
    /**
     * Original signature : <code>firstObjectCommonWithArray(NSArray*)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:30</i>
     */
    public abstract NSObject firstObjectCommonWithArray(NSArray otherArray);

    /**
     * Original signature : <code>void getObjects(id*)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:31</i>
     */
    public abstract void getObjects(com.sun.jna.ptr.PointerByReference objects);
    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:32</i><br>
     * Conversion Error : /// Original signature : <code>void getObjects(id*, null)</code><br>
     * - (void)getObjects:(id*)objects range:(null)range; (Argument range cannot be converted)
     */
    /**
     * Original signature : <code>NSUInteger indexOfObject(id)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:33</i>
     */
    public abstract int indexOfObject(NSObject anObject);
    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:34</i><br>
     * Conversion Error : /// Original signature : <code>NSUInteger indexOfObject(id, null)</code><br>
     * - (NSUInteger)indexOfObject:(id)anObject inRange:(null)range; (Argument range cannot be converted)
     */
    /**
     * Original signature : <code>NSUInteger indexOfObjectIdenticalTo(id)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:35</i>
     */
    public abstract int indexOfObjectIdenticalTo(NSObject anObject);
    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:36</i><br>
     * Conversion Error : /// Original signature : <code>NSUInteger indexOfObjectIdenticalTo(id, null)</code><br>
     * - (NSUInteger)indexOfObjectIdenticalTo:(id)anObject inRange:(null)range; (Argument range cannot be converted)
     */
    /**
     * Original signature : <code>BOOL isEqualToArray(NSArray*)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:37</i>
     */
    public abstract byte isEqualToArray(NSArray otherArray);

    /**
     * Original signature : <code>id lastObject()</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:38</i>
     */
    public abstract NSObject lastObject();

    /**
     * Original signature : <code>NSEnumerator* objectEnumerator()</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:39</i>
     */
    public abstract NSEnumerator objectEnumerator();

    /**
     * Original signature : <code>NSEnumerator* reverseObjectEnumerator()</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:40</i>
     */
    public abstract NSEnumerator reverseObjectEnumerator();

    /**
     * Original signature : <code>NSData* sortedArrayHint()</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:41</i>
     */
    public abstract NSData sortedArrayHint();

    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:44</i><br>
     * Conversion Error : /// Original signature : <code>NSArray* sortedArrayUsingSelector(null)</code><br>
     * - (NSArray*)sortedArrayUsingSelector:(null)comparator; (Argument comparator cannot be converted)
     */
    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:45</i><br>
     * Conversion Error : /// Original signature : <code>NSArray* subarrayWithRange(null)</code><br>
     * - (NSArray*)subarrayWithRange:(null)range; (Argument range cannot be converted)
     */
    /**
     * Original signature : <code>BOOL writeToFile(NSString*, BOOL)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:46</i>
     */
    public abstract boolean writeToFile_atomically(String path, boolean useAuxiliaryFile);

    public boolean writeToFile(String path ) {
        return this.writeToFile_atomically(path, true);
    }

    /**
     * Original signature : <code>BOOL writeToURL(NSURL*, BOOL)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:47</i>
     */
    public abstract boolean writeToURL_atomically(NSURL url, boolean atomically);

    public boolean writeToURL(NSURL url ) {
        return this.writeToURL_atomically(url, true);
    }

    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:49</i><br>
     * Conversion Error : /// Original signature : <code>void makeObjectsPerformSelector(null)</code><br>
     * - (void)makeObjectsPerformSelector:(null)aSelector; (Argument aSelector cannot be converted)
     */
    /**
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:50</i><br>
     * Conversion Error : /// Original signature : <code>void makeObjectsPerformSelector(null, id)</code><br>
     * - (void)makeObjectsPerformSelector:(null)aSelector withObject:(id)argument; (Argument aSelector cannot be converted)
     */
    /**
     * Original signature : <code>NSArray* objectsAtIndexes(NSIndexSet*)</code><br>
     * <i>from NSExtendedArray native declaration : /Users/dkocher/null:53</i>
     */
    public abstract NSArray objectsAtIndexes(NSIndexSet indexes);

    /**
     * Original signature : <code>id initWithObjects(const id*, NSUInteger)</code><br>
     * <i>from NSArrayCreation native declaration : /Users/dkocher/null:66</i>
     */
    public abstract NSArray initWithObjects_count(com.sun.jna.ptr.PointerByReference objects, int cnt);

    /**
     * Original signature : <code>id initWithObjects(id, null)</code><br>
     * <i>from NSArrayCreation native declaration : /Users/dkocher/null:67</i>
     */
    public abstract NSArray initWithObjects(NSObject firstObj, NSObject... varargs);

    /**
     * Original signature : <code>id initWithArray(NSArray*)</code><br>
     * <i>from NSArrayCreation native declaration : /Users/dkocher/null:68</i>
     */
    public abstract NSArray initWithArray(NSArray array);

    /**
     * Original signature : <code>id initWithArray(NSArray*, BOOL)</code><br>
     * <i>from NSArrayCreation native declaration : /Users/dkocher/null:69</i>
     */
    public abstract NSArray initWithArray_copyItems(NSArray array, byte flag);

    /**
     * Original signature : <code>id initWithContentsOfFile(NSString*)</code><br>
     * <i>from NSArrayCreation native declaration : /Users/dkocher/null:73</i>
     */
    public abstract NSArray initWithContentsOfFile(com.sun.jna.Pointer path);

    /**
     * Original signature : <code>id initWithContentsOfURL(NSURL*)</code><br>
     * <i>from NSArrayCreation native declaration : /Users/dkocher/null:74</i>
     */
    public abstract NSArray initWithContentsOfURL(com.sun.jna.Pointer url);
}