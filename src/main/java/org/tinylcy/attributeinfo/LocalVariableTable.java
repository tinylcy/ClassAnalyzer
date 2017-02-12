package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class LocalVariableTable extends BasicAttributeInfo {

    private short localVariableTableLength;
    private LocalVariableInfo [] localVariableTable;

    public LocalVariableTable(short attributeNameIndex) {
        setAttributeNameIndex(attributeNameIndex);
    }


    @Override
    public void read(InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 localVariableTableLengthU2 = U2.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        localVariableTableLength = localVariableTableLengthU2.getValue();
        localVariableTable = new LocalVariableInfo[localVariableTableLength];
        for(int i = 0; i < localVariableTableLength; i++) {
            LocalVariableInfo localVariableInfo = new LocalVariableInfo();
            localVariableInfo.read(inputStream);
        }
    }

    private class LocalVariableInfo {
        public short startPc;
        public short length;
        public short nameIndex;
        public short descriptorIndex;
        public short index;

        public void read(InputStream inputStream) {
            U2 startPcU2 = U2.read(inputStream);
            U2 lengthU2 = U2.read(inputStream);
            U2 nameIndexU2 = U2.read(inputStream);
            U2 descriptorIndexU2 = U2.read(inputStream);
            U2 indexU2 = U2.read(inputStream);
            startPc = startPcU2.getValue();
            length = lengthU2.getValue();
            nameIndex = nameIndexU2.getValue();
            descriptorIndex = descriptorIndexU2.getValue();
            index = indexU2.getValue();
        }

        @Override
        public String toString() {
            return "LocalVariableInfo{" +
                    "startPc=" + startPc +
                    ", length=" + length +
                    ", nameIndex=" + nameIndex +
                    ", descriptorIndex=" + descriptorIndex +
                    ", index=" + index +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LocalVariableTable{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                ", attributeLength=" + getAttributeLength() +
                ", localVariableTableLength=" + localVariableTableLength +
                '}';
    }

}
