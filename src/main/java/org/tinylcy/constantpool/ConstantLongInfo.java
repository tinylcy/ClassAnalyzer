package org.tinylcy.constantpool;

import org.tinylcy.basictype.U4;

import java.io.InputStream;

/**
 * Created by chenyangli on 17/2/8.
 */
public class ConstantLongInfo extends ConstantPoolInfo {

    private long bytesValue;

    public ConstantLongInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 bytesValueU4 = U4.read(inputStream);
        this.bytesValue = bytesValueU4.getValue();
    }

    @Override
    public String toString() {
        return "ConstantLongInfo{" +
                "bytesValue=" + bytesValue +
                '}';
    }
}
