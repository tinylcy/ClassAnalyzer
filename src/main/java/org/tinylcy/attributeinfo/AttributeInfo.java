package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U1;
import org.tinylcy.constantpool.ConstantPool;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class AttributeInfo extends BasicAttributeInfo {

    private byte[] info;

    @Override
    public void read(InputStream inputStream) {
        info = new byte[(int) getAttributeLength()];
        for (int i = 0; i < getAttributeLength(); i++) {
            U1 byteU1 = U1.read(inputStream);
            info[i] = byteU1.getValue();
        }
    }

    @Override
    public void read(ConstantPool constantPool, InputStream inputStream) {
        super.read(constantPool, inputStream);
    }
}
