package org.tinylcy.attributeinfo;

import org.tinylcy.constantpool.ConstantPool;
import org.tinylcy.constantpool.ConstantUtf8Info;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class StackMapTable extends BasicAttributeInfo {

    private short NumberOfEntries;
    private StackMapFrame[] stackMapFrameEntries;

    public StackMapTable(ConstantPool constantPool, short attributeNameIndex) {
        super(constantPool);
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {

    }

    @Override
    public String toString() {
        return "StackMapTable{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                " [attribute name = " + ((ConstantUtf8Info) (constantPool.getCpInfo()[getAttributeNameIndex() - 1])).getValue() + "]" +
                ", attributeLength=" + getAttributeLength() +
                ", NumberOfEntries=" + NumberOfEntries +
                ", stackMapFrameEntries=" + Arrays.toString(stackMapFrameEntries) +
                '}';
    }

    private class StackMapFrame {

    }
}
