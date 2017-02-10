package org.tinylcy.constantpool;

import org.tinylcy.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantStringInfo extends ConstantPoolInfo {

    private short index;

    public ConstantStringInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 indexU2 = U2.read(inputStream);
        this.index = indexU2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantStringInfo{" +
                "index=" + index +
                '}';
    }
}
