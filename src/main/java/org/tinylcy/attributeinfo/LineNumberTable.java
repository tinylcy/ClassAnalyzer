package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;
import org.tinylcy.constantpool.ConstantPool;
import org.tinylcy.constantpool.ConstantUtf8Info;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class LineNumberTable extends BasicAttributeInfo {

    private short lineNumberTableLength;
    private LineNumberInfo[] lineNumberTable;

    public LineNumberTable(ConstantPool constantPool, short attributeNameIndex) {
        super(constantPool);
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 lineNumberTableLengthU2 = U2.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        lineNumberTableLength = lineNumberTableLengthU2.getValue();
        lineNumberTable = new LineNumberInfo[lineNumberTableLength];
        for (int i = 0; i < lineNumberTableLength; i++) {
            LineNumberInfo lineNumberInfo = new LineNumberInfo();
            lineNumberInfo.read(inputStream);
            lineNumberTable[i] = lineNumberInfo;
        }
    }

    @Override
    public String toString() {
        return "LineNumberTable{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                " [attribute name = " + ((ConstantUtf8Info) (constantPool.getCpInfo()[getAttributeNameIndex() - 1])).getValue() + "]" +
                ", attributeLength=" + getAttributeLength() +
                ", lineNumberTableLength=" + lineNumberTableLength +
                ", lineNumberTable=" + Arrays.toString(lineNumberTable) +
                '}';
    }

    private class LineNumberInfo {
        public short startPc;
        public short lineNumber;

        public void read(InputStream inputStream) {
            U2 startPcU2 = U2.read(inputStream);
            U2 lineNumberU2 = U2.read(inputStream);
            startPc = startPcU2.getValue();
            lineNumber = lineNumberU2.getValue();
        }

        @Override
        public String toString() {
            return "LineNumberInfo{" +
                    "startPc=" + startPc +
                    ", lineNumber=" + lineNumber +
                    '}';
        }
    }

}
