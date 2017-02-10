package org.tinylcy.constantpool;

import org.tinylcy.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantInterfaceMethodRefInfo extends ConstantPoolInfo {

    private short classIndex;
    private short nameAndTypeIndex;

    public ConstantInterfaceMethodRefInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 classIndexU2 = U2.read(inputStream);
        U2 nameAndTypeIndexU2 = U2.read(inputStream);
        this.classIndex = classIndexU2.getValue();
        this.nameAndTypeIndex = nameAndTypeIndexU2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantInterfaceMethodRefInfo{" +
                "classIndex=" + classIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                '}';
    }
}
