package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;
import org.tinylcy.constantpool.ConstantPool;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyang li.
 */
public class LocalVariableTypeTable extends BasicAttributeInfo {

    private short localVariableTypeTableLength;
    private LocalVariableTypeTableInfo[] localVariableTypeTable;

    public LocalVariableTypeTable(ConstantPool constantPool, short attributeNameIndex) {
        super(constantPool);
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 localVariableTypeTableLengthU2 = U2.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        this.localVariableTypeTableLength = localVariableTypeTableLengthU2.getValue();
        localVariableTypeTable = new LocalVariableTypeTableInfo[localVariableTypeTableLength];
        for (int i = 0; i < localVariableTypeTableLength; i++) {
            localVariableTypeTable[i] = new LocalVariableTypeTableInfo();
            localVariableTypeTable[i].read(inputStream);
        }

    }

    private class LocalVariableTypeTableInfo {
        public short startPc;
        public short length;
        public short nameIndex;
        public short signatureIndex;
        public short index;

        public void read(InputStream inputStream) {
            U2 startPcU2 = U2.read(inputStream);
            U2 lengthU2 = U2.read(inputStream);
            U2 nameIndexU2 = U2.read(inputStream);
            U2 signatureIndexU2 = U2.read(inputStream);
            U2 indexU2 = U2.read(inputStream);
            this.startPc = startPcU2.getValue();
            this.length = lengthU2.getValue();
            this.nameIndex = nameIndexU2.getValue();
            this.signatureIndex = signatureIndexU2.getValue();
            this.index = indexU2.getValue();
        }

        @Override
        public String toString() {
            return "LocalVariableTypeTableInfo{" +
                    "startPc=" + startPc +
                    ", length=" + length +
                    ", nameIndex=" + nameIndex +
                    ", signatureIndex=" + signatureIndex +
                    ", index=" + index +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LocalVariableTypeTable{" +
                "localVariableTypeTableLength=" + localVariableTypeTableLength +
                ", localVariableTypeTable=" + Arrays.toString(localVariableTypeTable) +
                '}';
    }

}
