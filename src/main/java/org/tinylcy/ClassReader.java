package org.tinylcy;

import org.tinylcy.basictype.U1;
import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;
import org.tinylcy.constantpool.*;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by chenyangli on 17/2/8.
 */
public class ClassReader {

    public static ClassFile read(InputStream in) {
        ClassFile classFile = new ClassFile();
        classFile.magic = U4.read(in);
        classFile.minorVersion = U2.read(in);
        classFile.majorVersion = U2.read(in);
        classFile.constantPoolCount = U2.read(in);
        classFile.cpInfo = readConstantPool(in, (short) (classFile.constantPoolCount.getValue() - 1)).getCpInfo();

        System.out.println("magic = " + classFile.magic.getHexValue());
        System.out.println("minorVersion = " + classFile.minorVersion.getValue());
        System.out.println("majorVersion = " + classFile.majorVersion.getValue());
        System.out.println("constantPoolCount = " + classFile.constantPoolCount.getValue());
        for (int i = 0; i < classFile.cpInfo.length; i++) {
            System.out.println("cpInfo[" + (i + 1) + "] = " + classFile.cpInfo[i]);
        }
        return classFile;
    }

    public static ConstantPool readConstantPool(InputStream inputStream, short constantPoolCount) {
        ConstantPool constantPool = new ConstantPool(constantPoolCount);
        ArrayList<ConstantPoolInfo> infoList = new ArrayList<ConstantPoolInfo>();
        for (short i = 0; i < constantPoolCount; i++) {
            U1 tag = U1.read(inputStream);
            ConstantPoolInfo info = newConstantPoolInfo(tag, inputStream);
            infoList.add(info);
        }
        constantPool.setCpInfo(infoList.toArray(new ConstantPoolInfo[0]));
        return constantPool;
    }

    private static ConstantPoolInfo newConstantPoolInfo(U1 tag, InputStream inputStream) {
        int tagValue = tag.getValue();
        ConstantPoolInfo constantPoolInfo = null;
        switch (tagValue) {
            case ConstantPoolInfo.CONSTANT_UTF8_INFO:
                constantPoolInfo = new ConstantUtf8Info(ConstantPoolInfo.CONSTANT_UTF8_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_INTEGER_INFO:
                constantPoolInfo = new ConstantIntegerInfo(ConstantPoolInfo.CONSTANT_INTEGER_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_FLOAT_INFO:
                constantPoolInfo = new ConstantFloatInfo(ConstantPoolInfo.CONSTANT_FLOAT_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_LONG_INFO:
                constantPoolInfo = new ConstantLongInfo(ConstantPoolInfo.CONSTANT_LONG_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_DOUBLE_INFO:
                constantPoolInfo = new ConstantDoubleInfo(ConstantPoolInfo.CONSTANT_DOUBLE_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_CLASS_INFO:
                constantPoolInfo = new ConstantClassInfo(ConstantPoolInfo.CONSTANT_CLASS_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_STRING_INFO:
                constantPoolInfo = new ConstantClassInfo(ConstantPoolInfo.CONSTANT_STRING_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_FIELDREF_INFO:
                constantPoolInfo = new ConstantFieldRefInfo(ConstantPoolInfo.CONSTANT_FIELDREF_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_METHODREF_INFO:
                constantPoolInfo = new ConstantMethodRefInfo(ConstantPoolInfo.CONSTANT_METHODREF_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_INTERFACEMETHODREF_INFO:
                constantPoolInfo = new ConstantInterfaceMethodRefInfo(ConstantPoolInfo.CONSTANT_INTERFACEMETHODREF_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_NAMEANDTYPE_INFO:
                constantPoolInfo = new ConstantNameAndTypeInfo(ConstantPoolInfo.CONSTANT_NAMEANDTYPE_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_METHODHANDLE_INFO:
                constantPoolInfo = new ConstantMethodHandleInfo(ConstantPoolInfo.CONSTANT_METHODHANDLE_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_METHODTYPE_INFO:
                constantPoolInfo = new ConstantMethodTypeInfo(ConstantPoolInfo.CONSTANT_METHODTYPE_INFO);
                constantPoolInfo.read(inputStream);
                break;
            case ConstantPoolInfo.CONSTANT_INVOKEDYNAMIC_INFO:
                constantPoolInfo = new ConstantInvokeDynamicInfo(ConstantPoolInfo.CONSTANT_INVOKEDYNAMIC_INFO);
                constantPoolInfo.read(inputStream);
                break;
        }
        return constantPoolInfo;
    }
}
