package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U1;
import org.tinylcy.constantpool.ConstantPool;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class AttributeInfo extends BasicAttributeInfo {

    private byte[] info;

    public AttributeInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public void read(InputStream inputStream) {
        info = new byte[(int) getAttributeLength()];
        for (int i = 0; i < getAttributeLength(); i++) {
            U1 byteU1 = U1.read(inputStream);
            info[i] = byteU1.getValue();
        }
    }

}
