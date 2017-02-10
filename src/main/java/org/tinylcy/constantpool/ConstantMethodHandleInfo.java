package org.tinylcy.constantpool;

import org.tinylcy.basictype.U1;
import org.tinylcy.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantMethodHandleInfo extends ConstantPoolInfo {

    private byte referenceKind;
    private short referenceIndex;

    public ConstantMethodHandleInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U1 referenceIndexU1 = U1.read(inputStream);
        U2 referenceIndexU2 = U2.read(inputStream);
        this.referenceKind = referenceIndexU1.getValue();
        this.referenceIndex = referenceIndexU2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantMethodHandleInfo{" +
                "referenceKind=" + referenceKind +
                ", referenceIndex=" + referenceIndex +
                '}';
    }
}
