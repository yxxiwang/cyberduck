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

#include <stdio.h>

#import <Local.h>
#import <Carbon/Carbon.h>
#import <ApplicationServices/ApplicationServices.h>
#import <CoreServices/CoreServices.h>
#import <Cocoa/Cocoa.h>
#import <IconFamily.h>

// Simple utility to convert java strings to NSStrings
NSString *convertToNSString(JNIEnv *env, jstring javaString)
{
    NSString *converted = nil;
    const jchar *unichars = NULL;
	
    if (javaString == NULL) {
        return nil;	
    }                   
    unichars = (*env)->GetStringChars(env, javaString, NULL);
    if ((*env)->ExceptionOccurred(env)) {
        return @"";
    }
    converted = [NSString stringWithCharacters:unichars length:(*env)->GetStringLength(env, javaString)]; // auto-released
    (*env)->ReleaseStringChars(env, javaString, unichars);
    return converted;
}

JNIEXPORT void JNICALL Java_ch_cyberduck_core_Local_setIconFromExtension(JNIEnv *env, jobject this, jstring path, jstring icon)
{
	NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
	NSImage *image = [[NSWorkspace sharedWorkspace] iconForFileType:convertToNSString(env, icon)];
	[image setScalesWhenResized:YES];
	[image setSize:NSMakeSize(128.0, 128.0)];
	NSWorkspace *workspace = [NSWorkspace sharedWorkspace];
	if([workspace respondsToSelector:@selector(setIcon:forFile:options:)]) {
		[workspace setIcon:image forFile:convertToNSString(env, path) options:NSExcludeQuickDrawElementsIconCreationOption];
	}
	[pool release];
}

JNIEXPORT void JNICALL Java_ch_cyberduck_core_Local_setIconFromFile(JNIEnv *env, jobject this, jstring path, jstring icon)
{
	NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
	NSWorkspace *workspace = [NSWorkspace sharedWorkspace];
	if([workspace respondsToSelector:@selector(setIcon:forFile:options:)]) {
		[workspace setIcon:[NSImage imageNamed:convertToNSString(env, icon)] forFile:convertToNSString(env, path) options:NSExcludeQuickDrawElementsIconCreationOption];
	}
	[pool release];
}

JNIEXPORT void JNICALL Java_ch_cyberduck_core_Local_removeCustomIcon(JNIEnv *env, jobject this, jstring path)
{
	NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
	[IconFamily removeCustomIconFromFile:convertToNSString(env, path)];
	[pool release];
}

JNIEXPORT jstring JNICALL Java_ch_cyberduck_core_Local_kind(JNIEnv *env, jobject this, jstring extension)
{
	NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
	NSString *kind = nil;
	LSCopyKindStringForTypeInfo(kLSUnknownType, kLSUnknownCreator, 
		(CFStringRef)convertToNSString(env, extension), (CFStringRef *)&kind);
	if(kind) {
		kind = [kind autorelease];
	}
	else {
		kind = NSLocalizedString(@"Unknown", @"");
	}
	[pool release];
	return (*env)->NewStringUTF(env, [kind UTF8String]);
}
