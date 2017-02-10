package org.tinylcy.constantpool;

import org.tinylcy.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantInvokeDynamicInfo extends ConstantPoolInfo {

    private short bootstrapMethodAttrIndex;
    private short nameAndTypeIndex;

    public ConstantInvokeDynamicInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 bootstrapMethodAttrIndexU2 = U2.read(inputStream);
        U2 nameAndTypeIndexU2 = U2.read(inputStream);
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndexU2.getValue();
        this.nameAndTypeIndex = nameAndTypeIndexU2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantInvokeDynamicInfo{" +
                "bootstrapMethodAttrIndex=" + bootstrapMethodAttrIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                '}';
    }
}
