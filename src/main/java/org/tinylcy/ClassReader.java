package org.tinylcy;

import org.tinylcy.accessflags.AccessFlags;
import org.tinylcy.accessflags.ClassAccessFlags;
import org.tinylcy.attributeinfo.BasicAttributeInfo;
import org.tinylcy.basictype.U1;
import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;
import org.tinylcy.constantpool.*;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by chenyangli.
 */
public class ClassReader {

    public static void analyze(InputStream inputStream) {

        ClassFile classFile = read(inputStream);
        ConstantPool constantPool = new ConstantPool(classFile.constantPoolCount.getValue());
        constantPool.setCpInfo(classFile.cpInfo);

        System.out.println("magic = " + classFile.magic.getHexValue());
        System.out.println("minorVersion = " + classFile.minorVersion.getValue());
        System.out.println("majorVersion = " + classFile.majorVersion.getValue());
        System.out.println("constantPoolCount = " + classFile.constantPoolCount.getValue());
        for (int i = 0; i < classFile.cpInfo.length; i++) {
            System.out.println("cpInfo[" + (i + 1) + "] = " + classFile.cpInfo[i]);
        }
        System.out.println("accessFlags = " + classFile.accessFlags.getHexValue() +
                ", " + AccessFlags.getFormattedAccessFlags(new ClassAccessFlags(), classFile.accessFlags.getValue()));
        System.out.println("thisClass = " + classFile.thisClass.getValue() +
                ", this class name = " + getConstantClassInfoValue(constantPool, classFile.thisClass.getValue()));
        System.out.println("superClass = " + classFile.superClass.getValue() +
                ", super class name = " + getConstantClassInfoValue(constantPool, classFile.superClass.getValue()));
        System.out.println("interfacesCount = " + classFile.interfacesCount.getValue());
        for (int i = 0; i < classFile.interfacesCount.getValue(); i++) {
            System.out.println("interfaces[" + i + "] = " + classFile.interfaces[i].getValue() +
                    ", interface name = " + getConstantClassInfoValue(constantPool, classFile.interfaces[i].getValue()));
        }
        System.out.println("fieldsCount = " + classFile.fieldsCount.getValue());
        for (int i = 0; i < classFile.fieldsCount.getValue(); i++) {
            System.out.println("fields[" + i + "] = " + classFile.fields[i]);
        }
        System.out.println("methodsCount = " + classFile.methodsCount.getValue());
        for (int i = 0; i < classFile.methodsCount.getValue(); i++) {
            System.out.println("methods[" + i + "] = " + classFile.methods[i]);
        }
        System.out.println("attributesCount = " + classFile.attributesCount.getValue());
        for (int i = 0; i < classFile.attributesCount.getValue(); i++) {
            System.out.println("attributes[" + i + "] = " + classFile.attributes[i]);
        }
    }

    public static ClassFile read(InputStream inputStream) {
        ClassFile classFile = new ClassFile();
        classFile.magic = U4.read(inputStream);
        classFile.minorVersion = U2.read(inputStream);
        classFile.majorVersion = U2.read(inputStream);
        classFile.constantPoolCount = U2.read(inputStream);
        ConstantPool constantPool = readConstantPool(inputStream,
                (short) (classFile.constantPoolCount.getValue() - 1));
        classFile.cpInfo = constantPool.getCpInfo();
        classFile.accessFlags = U2.read(inputStream);
        classFile.thisClass = U2.read(inputStream);
        classFile.superClass = U2.read(inputStream);
        classFile.interfacesCount = U2.read(inputStream);
        classFile.interfaces = new U2[classFile.interfacesCount.getValue()];
        readInterfaces(inputStream, classFile, classFile.interfacesCount.getValue());
        classFile.fieldsCount = U2.read(inputStream);
        readFieldsInfo(constantPool, inputStream, classFile, classFile.fieldsCount.getValue());
        classFile.methodsCount = U2.read(inputStream);
        readMethodsInfo(constantPool, inputStream, classFile, classFile.methodsCount.getValue());
        classFile.attributesCount = U2.read(inputStream);
        readClassAttributesInfo(constantPool, inputStream, classFile, classFile.attributesCount.getValue());

        return classFile;
    }

    public static ConstantPool readConstantPool(InputStream inputStream, short constantPoolCount) {
        ConstantPool constantPool = new ConstantPool(constantPoolCount);
        ArrayList<ConstantPoolInfo> infoList = new ArrayList<ConstantPoolInfo>();
        for (short i = 0; i < constantPoolCount; i++) {
            U1 tag = U1.read(inputStream);
            ConstantPoolInfo info = newConstantPoolInfo(tag, inputStream);
            infoList.add(info);
			//先添加cpinfo，再添加空的cpinfo（dobule和long占用两个slot）
			if (tag.getValue() == ConstantPoolInfo.CONSTANT_LONG_INFO || tag.getValue() == ConstantPoolInfo.CONSTANT_DOUBLE_INFO) {
                i++;
                infoList.add(null);
            }
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

    public static void readInterfaces(InputStream inputStream, ClassFile classFile, short interfacesCount) {
        for (int i = 0; i < interfacesCount; i++) {
            classFile.interfaces[i] = U2.read(inputStream);
        }
    }

    public static void readFieldsInfo(ConstantPool constantPool, InputStream inputStream, ClassFile classFile, short fieldsCount) {
        ArrayList<FieldInfo> fieldInfoList = new ArrayList<FieldInfo>();
        for (int i = 0; i < fieldsCount; i++) {
            FieldInfo fieldInfo = new FieldInfo(constantPool);
            fieldInfo.read(inputStream);
            fieldInfoList.add(fieldInfo);
        }
        classFile.fields = fieldInfoList.toArray(new FieldInfo[0]);
    }

    public static void readMethodsInfo(ConstantPool constantPool, InputStream inputStream,
                                       ClassFile classFile, short methodsCount) {
        classFile.methods = new MethodInfo[methodsCount];
        for (int i = 0; i < methodsCount; i++) {
            MethodInfo methodInfo = new MethodInfo(constantPool);
            methodInfo.read(inputStream);
            classFile.methods[i] = methodInfo;
        }
    }

    public static void readClassAttributesInfo(ConstantPool constantPool, InputStream inputStream,
                                               ClassFile classFile, short classAttributesCount) {
        classFile.attributes = new BasicAttributeInfo[classAttributesCount];
        for (int i = 0; i < classAttributesCount; i++) {
            short attributeNameIndex = U2.read(inputStream).getValue();
            BasicAttributeInfo attributeInfo = BasicAttributeInfo.newAttributeInfo(constantPool, attributeNameIndex);
            attributeInfo.read(inputStream);
            classFile.attributes[i] = attributeInfo;
        }
    }

    private static String getConstantClassInfoValue(ConstantPool constantPool, short constantClassInfoIndex) {
        ConstantClassInfo constantClassInfo = (ConstantClassInfo) constantPool.getCpInfo()[constantClassInfoIndex - 1];
        short index = constantClassInfo.getIndex();
        ConstantUtf8Info constantUtf8Info = ((ConstantUtf8Info) (constantPool.getCpInfo()[index - 1]));
        return constantUtf8Info.getValue();
    }

}
