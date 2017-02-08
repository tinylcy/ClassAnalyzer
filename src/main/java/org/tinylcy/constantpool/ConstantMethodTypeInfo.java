package org.tinylcy.constantpool;

import org.tinylcy.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli on 17/2/8.
 */
public class ConstantMethodTypeInfo extends ConstantPoolInfo {

    private short descriptorIndex;

    public ConstantMethodTypeInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 descriptorIndexU2 = U2.read(inputStream);
        this.descriptorIndex = descriptorIndexU2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantMethodTypeInfo{" +
                "descriptorIndex=" + descriptorIndex +
                '}';
    }
}
