package org.tinylcy.attributeinfo;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class StackMapTable extends AttributeInfo {

    private short attributeNameIndex;
    private long attributeLength;
    private short NumberOfEntries;
    private StackMapFrame[] stackMapFrameEntries;

    public StackMapTable(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    @Override
    public void read(InputStream inputStream) {

    }

    @Override
    public String toString() {
        return "StackMapTable{" +
                "attributeNameIndex=" + attributeNameIndex +
                ", attributeLength=" + attributeLength +
                ", NumberOfEntries=" + NumberOfEntries +
                ", stackMapFrameEntries=" + Arrays.toString(stackMapFrameEntries) +
                '}';
    }

    private class StackMapFrame {

    }
}
