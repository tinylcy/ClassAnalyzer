package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U1;
import org.tinylcy.basictype.U4;
import org.tinylcy.constantpool.ConstantPool;

import java.io.InputStream;

/**
 * Created by chenyang li.
 */
public class Unparsed extends BasicAttributeInfo {

    public Unparsed(ConstantPool constantPool, short attributeNameIndex) {
        super(constantPool);
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        for (int i = 0; i < getAttributeLength(); i++) {
            U1.read(inputStream);
        }
    }
}
