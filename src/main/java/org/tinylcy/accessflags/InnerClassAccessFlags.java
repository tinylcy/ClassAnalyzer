package org.tinylcy.accessflags;

/**
 * Created by chenyang li.
 */
public class InnerClassAccessFlags extends AccessFlags {

    public static final short INNER_CLASS_ACC_PUBLIC = 0x0001;
    public static final short INNER_CLASS_ACC_PRIVATE = 0x0002;
    public static final short INNER_CLASS_ACC_PROTECTED = 0x0004;
    public static final short INNER_CLASS_ACC_STATIC = 0x0008;
    public static final short INNER_CLASS_ACC_FINAL = 0x0010;
    public static final short INNER_CLASS_ACC_INTERFACE = 0x0020;
    public static final short INNER_CLASS_ACC_ABSTRACT = 0x0400;
    public static final short INNER_CLASS_ACC_SYNTHETIC = 0x1000;
    public static final short INNER_CLASS_ACC_ANNOTATION = 0x2000;
    public static final short INNER_CLASS_ACC_ENUM = 0x4000;

    @Override
    public String getFormattedAccessFlags(short accessFlags) {
        StringBuilder flags = new StringBuilder();
        if ((accessFlags & INNER_CLASS_ACC_PUBLIC) != 0) {
            flags.append("public ");
        }
        if ((accessFlags & INNER_CLASS_ACC_PRIVATE) != 0) {
            flags.append("private ");
        }
        if ((accessFlags & INNER_CLASS_ACC_PROTECTED) != 0) {
            flags.append("protected ");
        }
        if ((accessFlags & INNER_CLASS_ACC_STATIC) != 0) {
            flags.append("static ");
        }
        if ((accessFlags & INNER_CLASS_ACC_FINAL) != 0) {
            flags.append("final ");
        }
        if ((accessFlags & INNER_CLASS_ACC_INTERFACE) != 0) {
            flags.append("interface ");
        }
        if ((accessFlags & INNER_CLASS_ACC_ABSTRACT) != 0) {
            flags.append("abstract ");
        }
        if ((accessFlags & INNER_CLASS_ACC_SYNTHETIC) != 0) {
            flags.append("synthetic ");
        }
        if ((accessFlags & INNER_CLASS_ACC_ANNOTATION) != 0) {
            flags.append("annotation ");
        }
        if ((accessFlags & INNER_CLASS_ACC_ENUM) != 0) {
            flags.append("enum ");
        }
        return flags.toString();
    }

}
