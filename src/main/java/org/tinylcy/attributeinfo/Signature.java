package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class Signature extends BasicAttributeInfo {

    private short signatureIndex;

    public Signature(short attributeNameIndex) {
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 attributeNameIndexU2 = U2.read(inputStream);
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 signatureIndexU2 = U2.read(inputStream);
        setAttributeNameIndex(attributeNameIndexU2.getValue());
        setAttributeLength(attributeLengthU4.getValue());
        signatureIndex = signatureIndexU2.getValue();
    }

    @Override
    public String toString() {
        return "Signature{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                ", attributeLength=" + getAttributeLength() +
                ", signatureIndex=" + signatureIndex +
                '}';
    }
}
