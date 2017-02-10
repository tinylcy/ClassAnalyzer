package org.tinylcy.attributeinfo;

import org.tinylcy.constantpool.ConstantPool;
import org.tinylcy.constantpool.ConstantPoolInfo;
import org.tinylcy.constantpool.ConstantUtf8Info;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class BasicAttributeInfo {

    private short attributeNameIndex;
    private long attributeLength;

    public void read(InputStream inputStream) {
    }

    public void read(ConstantPool constantPool, InputStream inputStream) {
    }

    public static BasicAttributeInfo newAttributeInfo(ConstantPool constantPool, short attributeNameIndex) {
        BasicAttributeInfo basicAttributeInfo = null;
        String attributeName = null;
        ConstantPoolInfo constantPoolInfo = constantPool.getCpInfo()[attributeNameIndex - 1];
        if (constantPoolInfo instanceof ConstantUtf8Info) {
            attributeName = ((ConstantUtf8Info) constantPoolInfo).getValue();
        }
        if (attributeName.equals("Code")) {
            basicAttributeInfo = new Code(attributeNameIndex);
        } else if (attributeName.equals("ConstantValue")) {
            basicAttributeInfo = new ConstantValue(attributeNameIndex);
        } else if (attributeName.equals("Deprecated")) {
            basicAttributeInfo = new Deprecated(attributeNameIndex);
        } else if (attributeName.equals("Exceptions")) {
            basicAttributeInfo = new Exceptions(attributeNameIndex);
        } else if (attributeName.equals("LineNumberTable")) {
            basicAttributeInfo = new LineNumberTable(attributeNameIndex);
        } else if (attributeName.equals("LocalVariableTable")) {
            basicAttributeInfo = new LocalVariableTable(attributeNameIndex);
        } else if (attributeName.equals("SourceFile")) {
            basicAttributeInfo = new SourceFile(attributeNameIndex);
        } else if (attributeName.equals("Synthetic")) {
            basicAttributeInfo = new Synthetic(attributeNameIndex);
        }
        basicAttributeInfo.setAttributeNameIndex(attributeNameIndex);
        return basicAttributeInfo;
    }

    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public long getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(long attributeLength) {
        this.attributeLength = attributeLength;
    }

}
