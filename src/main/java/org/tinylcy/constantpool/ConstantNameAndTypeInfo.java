package org.tinylcy.constantpool;

import org.tinylcy.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantNameAndTypeInfo extends ConstantPoolInfo {

    private short nameIndex;
    private short descriptorIndex;

    public ConstantNameAndTypeInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 nameIndexU2 = U2.read(inputStream);
        U2 descriptorIndexU2 = U2.read(inputStream);
        this.nameIndex = nameIndexU2.getValue();
        this.descriptorIndex = descriptorIndexU2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantNameAndTypeInfo{" +
                "nameIndex=" + nameIndex +
                ", descriptorIndex=" + descriptorIndex +
                '}';
    }
}
