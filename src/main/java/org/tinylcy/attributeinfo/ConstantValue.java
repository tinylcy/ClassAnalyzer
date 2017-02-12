package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;
import org.tinylcy.constantpool.ConstantPool;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantValue extends BasicAttributeInfo {

    private short constantValueIndex;

    public ConstantValue(short attributeNameIndex) {
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(ConstantPool constantPool, InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 constantValueIndexU2 = U2.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        constantValueIndex = constantValueIndexU2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantValue{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                ", attributeLength=" + getAttributeLength() +
                ", constantValueIndex=" + constantValueIndex +
                '}';
    }
}
