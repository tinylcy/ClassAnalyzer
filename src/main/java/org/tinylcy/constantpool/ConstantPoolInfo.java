package org.tinylcy.constantpool;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public abstract class ConstantPoolInfo {

    public static final byte CONSTANT_UTF8_INFO = 1;                  // CONSTANT_Utf8_info
    public static final byte CONSTANT_INTEGER_INFO = 3;               // CONSTANT_Integer_info
    public static final byte CONSTANT_FLOAT_INFO = 4;                 // CONSTANT_Float_info
    public static final byte CONSTANT_LONG_INFO = 5;                  // CONSTANT_Long_info
    public static final byte CONSTANT_DOUBLE_INFO = 6;                // CONSTANT_Double_info
    public static final byte CONSTANT_CLASS_INFO = 7;                 // CONSTANT_Class_info
    public static final byte CONSTANT_STRING_INFO = 8;                // CONSTANT_String_info
    public static final byte CONSTANT_FIELDREF_INFO = 9;              // CONSTANT_FieldRef_info
    public static final byte CONSTANT_METHODREF_INFO = 10;            // CONSTANT_MethodRef_info
    public static final byte CONSTANT_INTERFACEMETHODREF_INFO = 11;   // CONSTANT_InterfaceMethodRef_info
    public static final byte CONSTANT_NAMEANDTYPE_INFO = 12;                   // CONSTANT_NameAndType_info
    public static final byte CONSTANT_METHODHANDLE_INFO = 15;                  // CONSTANT_MethodHandle_info
    public static final byte CONSTANT_METHODTYPE_INFO = 16;                    // CONSTANT_MethodType_info
    public static final byte CONSTANT_INVOKEDYNAMIC_INFO = 18;                 // CONSTANT_InvokeDynamic_info

    private byte tag;

    public abstract void read(InputStream inputStream);

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }
}
