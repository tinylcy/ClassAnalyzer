package org.tinylcy.constantpool;

import org.tinylcy.basictype.U4;

import java.io.InputStream;

/**
 * Created by chenyangli on 17/2/8.
 */
public class ConstantDoubleInfo extends ConstantPoolInfo {

    private double bytesValue;

    public ConstantDoubleInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 bytesValuesU4 = U4.read(inputStream);
        this.bytesValue = bytesValuesU4.getValue();
    }

    @Override
    public String toString() {
        return "ConstantDoubleInfo{" +
                "bytesValue=" + bytesValue +
                '}';
    }
}
