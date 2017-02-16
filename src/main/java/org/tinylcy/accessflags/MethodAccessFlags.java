package org.tinylcy.accessflags;

/**
 * Created by chenyang li.
 */
public class MethodAccessFlags extends AccessFlags {

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

    @Override
    public String getFormattedAccessFlags(short accessFlags) {
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
