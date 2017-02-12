package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U1;
import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;
import org.tinylcy.constantpool.ConstantPool;
import org.tinylcy.constantpool.ConstantUtf8Info;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class Code extends BasicAttributeInfo {

    private short maxStack;
    private short maxLocals;
    private long codeLength;
    private byte[] code;
    private short exceptionTableLength;
    private ExceptionInfo[] exceptionTable;
    private short attributesCount;
    private BasicAttributeInfo[] attributes;

    public Code(ConstantPool constantPool, short attributeNameIndex) {
        super(constantPool);
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 maxStackU2 = U2.read(inputStream);
        U2 maxLocalsU2 = U2.read(inputStream);
        U4 codeLengthU4 = U4.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        maxStack = maxStackU2.getValue();
        maxLocals = maxLocalsU2.getValue();
        codeLength = codeLengthU4.getValue();
        code = new byte[(int) codeLength];
        for (int i = 0; i < codeLength; i++) {
            U1 codeU1 = U1.read(inputStream);
            code[i] = codeU1.getValue();
        }
        U2 exceptionTableLengthU2 = U2.read(inputStream);
        exceptionTableLength = exceptionTableLengthU2.getValue();
        exceptionTable = new ExceptionInfo[exceptionTableLength];
        for (int i = 0; i < exceptionTableLengthU2.getValue(); i++) {
            ExceptionInfo exceptionInfo = new ExceptionInfo();
            exceptionInfo.read(inputStream);
            exceptionTable[i] = exceptionInfo;
        }
        U2 attributesCountU2 = U2.read(inputStream);
        attributesCount = attributesCountU2.getValue();
        attributes = new BasicAttributeInfo[attributesCount];
        for (int i = 0; i < attributesCountU2.getValue(); i++) {
            short attributeNameIndex = U2.read(inputStream).getValue();
            BasicAttributeInfo attributeInfo = BasicAttributeInfo.newAttributeInfo(constantPool,
                    attributeNameIndex);
            attributeInfo.read(inputStream);
            attributes[i] = attributeInfo;
        }

    }

    @Override
    public String toString() {
        return "Code{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                " [attribute name = " + ((ConstantUtf8Info) (constantPool.getCpInfo()[getAttributeNameIndex() - 1])).getValue() + "]" +
                ", attributeLength=" + getAttributeLength() +
                ", maxStack=" + maxStack +
                ", maxLocals=" + maxLocals +
                ", codeLength=" + codeLength +
                ", code=" + Arrays.toString(code) +
                ", exceptionTableLength=" + exceptionTableLength +
                ", exceptionTable=" + Arrays.toString(exceptionTable) +
                ", attributesCount=" + attributesCount +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }

    private class ExceptionInfo {
        public short startPc;
        public short endPc;
        public short handlerPc;
        public short catchType;

        public void read(InputStream inputStream) {
            U2 startPcU2 = U2.read(inputStream);
            U2 endPcU2 = U2.read(inputStream);
            U2 handlerPcU2 = U2.read(inputStream);
            U2 catchTypeU2 = U2.read(inputStream);
            this.startPc = startPcU2.getValue();
            this.endPc = endPcU2.getValue();
            this.handlerPc = handlerPcU2.getValue();
            this.catchType = catchTypeU2.getValue();
        }

        @Override
        public String toString() {
            return "ExceptionInfo{" +
                    "startPc=" + startPc +
                    ", endPc=" + endPc +
                    ", handlerPc=" + handlerPc +
                    ", catchType=" + catchType +
                    '}';
        }
    }

}
