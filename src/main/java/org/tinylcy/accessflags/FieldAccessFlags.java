package org.tinylcy.accessflags;

/**
 * Created by chenyang li.
 */
public class FieldAccessFlags extends AccessFlags {

    public static final short FIELD_ACC_PUBLIC = 0x0001;
    public static final short FIELD_ACC_PRIVATE = 0x0002;
    public static final short FIELD_ACC_PROTECTED = 0x004;
    public static final short FIELD_ACC_STATIC = 0x0008;
    public static final short FIELD_ACC_FINAL = 0x0010;
    public static final short FIELD_ACC_VOLATILE = 0x0040;
    public static final short FIELD_ACC_TRANSIENT = 0x0080;
    public static final short FIELD_ACC_SYNTHETIC = 0x1000;
    public static final short FIELD_ACC_ENUM = 0x4000;

    @Override
    public String getFormattedAccessFlags(short accessFlags) {
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

}
