package org.tinylcy;

/**
 * Created by chenyangli.
 */
public class AccessFlags {

    public static final short CLASS_ACC_PUBLIC = 0x0001;
    public static final short CLASS_ACC_FINAL = 0x0010;
    public static final short CLASS_ACC_SUPER = 0x0020;
    public static final short CLASS_ACC_INTERFACE = 0x0200;
    public static final short CLASS_ACC_ABSTRACT = 0x0400;
    public static final short CLASS_ACC_SYNTHETIC = 0x1000;
    public static final short CLASS_ACC_ANNOTATION = 0x2000;
    public static final short CLASS_ACC_ENUM = 0x4000;

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

    public static final short FIELD_ACC_PUBLIC = 0x0001;
    public static final short FIELD_ACC_PRIVATE = 0x0002;
    public static final short FIELD_ACC_PROTECTED = 0x004;
    public static final short FIELD_ACC_STATIC = 0x0008;
    public static final short FIELD_ACC_FINAL = 0x0010;
    public static final short FIELD_ACC_VOLATILE = 0x0040;
    public static final short FIELD_ACC_TRANSIENT = 0x0080;
    public static final short FIELD_ACC_SYNTHETIC = 0x1000;
    public static final short FIELD_ACC_ENUM = 0x4000;

    public static final short METHOD_ACC_PUBLIC = 0x0001;
    public static final short METHOD_ACC_PRIVATE = 0x0002;
    public static final short METHOD_ACC_PROTECTED = 0x0004;
    public static final short METHOD_ACC_STATIC = 0x0008;
    public static final short METHOD_ACC_FINAL = 0x0010;
    public static final short METHOD_ACC_SYNCHRONIZED = 0x0020;
    public static final short METHOD_ACC_BRIDGE = 0x0040;
    public static final short METHOD_ACC_VARARGS = 0x0080;
    public static final short METHOD_ACC_NATIVE = 0x0100;
    public static final short METHOD_ACC_ABSTRACT = 0x0400;
    public static final short METHOD_ACC_STRICTFP = 0x0800;
    public static final short METHOD_ACC_SYNTHETIC = 0x1000;

    public static String getFormattedClassAccessFlags(short accessFlags) {
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

    public static String getFormattedInnerClassAccessFlags(short accessFlags) {
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

    public static String getFormattedFieldAccessFlags(short accessFlags) {
        StringBuilder flags = new StringBuilder();
        if ((accessFlags & FIELD_ACC_PUBLIC) != 0) {
            flags.append("public ");
        }
        if ((accessFlags & FIELD_ACC_PRIVATE) != 0) {
            flags.append("private ");
        }
        if ((accessFlags & FIELD_ACC_PROTECTED) != 0) {
            flags.append("protected ");
        }
        if ((accessFlags & FIELD_ACC_STATIC) != 0) {
            flags.append("static ");
        }
        if ((accessFlags & FIELD_ACC_FINAL) != 0) {
            flags.append("final ");
        }
        if ((accessFlags & FIELD_ACC_VOLATILE) != 0) {
            flags.append("volatile ");
        }
        if ((accessFlags & FIELD_ACC_TRANSIENT) != 0) {
            flags.append("transient ");
        }
        if ((accessFlags & FIELD_ACC_SYNTHETIC) != 0) {
            flags.append("synthetic ");
        }
        if ((accessFlags & FIELD_ACC_ENUM) != 0) {
            flags.append("enum ");
        }
        return flags.toString();
    }

    public static String getFormattedMethodAccessFlags(short accessFlags) {
        StringBuilder flags = new StringBuilder();
        if ((accessFlags & METHOD_ACC_PUBLIC) != 0) {
            flags.append("public ");
        }
        if ((accessFlags & METHOD_ACC_PRIVATE) != 0) {
            flags.append("private ");
        }
        if ((accessFlags & METHOD_ACC_PROTECTED) != 0) {
            flags.append("protected ");
        }
        if ((accessFlags & METHOD_ACC_STATIC) != 0) {
            flags.append("static ");
        }
        if ((accessFlags & METHOD_ACC_FINAL) != 0) {
            flags.append("final ");
        }
        if ((accessFlags & METHOD_ACC_SYNCHRONIZED) != 0) {
            flags.append("synchronized ");
        }
        if ((accessFlags & METHOD_ACC_BRIDGE) != 0) {
            flags.append("bridge ");
        }
        if ((accessFlags & METHOD_ACC_VARARGS) != 0) {
            flags.append("varargs ");
        }
        if ((accessFlags & METHOD_ACC_NATIVE) != 0) {
            flags.append("native ");
        }
        if ((accessFlags & METHOD_ACC_ABSTRACT) != 0) {
            flags.append("abstract ");
        }
        if ((accessFlags & METHOD_ACC_STRICTFP) != 0) {
            flags.append("strictfp ");
        }
        if ((accessFlags & METHOD_ACC_SYNTHETIC) != 0) {
            flags.append("synthetic ");
        }
        return flags.toString();
    }
}
