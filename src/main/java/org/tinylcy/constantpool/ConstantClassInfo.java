package org.tinylcy.constantpool;

import org.tinylcy.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantClassInfo extends ConstantPoolInfo{

    private short index;

    public ConstantClassInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 u2 = U2.read(inputStream);
        this.index = u2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantClassInfo{" +
                "index=" + index +
                '}';
    }

    public short getIndex() {
        return index;
    }
}