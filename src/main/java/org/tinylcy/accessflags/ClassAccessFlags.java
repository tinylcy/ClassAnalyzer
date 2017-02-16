package org.tinylcy.accessflags;

/**
 * Created by chenyang li.
 */
public class ClassAccessFlags extends AccessFlags {

    public static final short CLASS_ACC_PUBLIC = 0x0001;
    public static final short CLASS_ACC_FINAL = 0x0010;
    public static final short CLASS_ACC_SUPER = 0x0020;
    public static final short CLASS_ACC_INTERFACE = 0x0200;
    public static final short CLASS_ACC_ABSTRACT = 0x0400;
    public static final short CLASS_ACC_SYNTHETIC = 0x1000;
    public static final short CLASS_ACC_ANNOTATION = 0x2000;
    public static final short CLASS_ACC_ENUM = 0x4000;

    @Override
    public String getFormattedAccessFlags(short accessFlags) {
        StringBuilder flags = new StringBuilder();
        if ((accessFlags & CLASS_ACC_PUBLIC) != 0) {
            flags.append("public ");
        }
        if ((accessFlags & CLASS_ACC_FINAL) != 0) {
            flags.append("final ");
        }
        if ((accessFlags & CLASS_ACC_SUPER) != 0) {
            flags.append("super ");
        }
        if ((accessFlags & CLASS_ACC_INTERFACE) != 0) {
            flags.append("interface ");
        }
        if ((accessFlags & CLASS_ACC_ABSTRACT) != 0) {
            flags.append("abstract ");
        }
        if ((accessFlags & CLASS_ACC_SYNTHETIC) != 0) {
            flags.append("synthetic ");
        }
        if ((accessFlags & CLASS_ACC_ANNOTATION) != 0) {
            flags.append("annotation ");
        }
        if ((accessFlags & CLASS_ACC_ENUM) != 0) {
            flags.append("enum ");
        }
        return flags.toString();
    }

}
