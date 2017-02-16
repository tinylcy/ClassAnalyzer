package org.tinylcy.accessflags;

/**
 * Created by chenyang li.
 */
public abstract class AccessFlags {

    public abstract String getFormattedAccessFlags(short accessFlags);

    public static String getFormattedAccessFlags(AccessFlags accessFlags, short accessFlagsIndex) {
        return accessFlags.getFormattedAccessFlags(accessFlagsIndex);
    }

}
