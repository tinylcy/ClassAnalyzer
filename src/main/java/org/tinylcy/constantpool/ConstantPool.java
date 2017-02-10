package org.tinylcy.constantpool;

import org.tinylcy.basictype.U2;

/**
 * Created by chenyangli.
 */
public class ConstantPool {

    private U2 constantPoolCount;           // constant_pool_count
    private ConstantPoolInfo[] cpInfo;      // cp_info

    public ConstantPool(short constantPoolCount) {
        U2 u2 = new U2(constantPoolCount);
        this.constantPoolCount = u2;
        cpInfo = new ConstantPoolInfo[this.constantPoolCount.getValue()];
    }

    public ConstantPoolInfo[] getCpInfo() {
        return cpInfo;
    }

    public void setCpInfo(ConstantPoolInfo[] cpInfo) {
        this.cpInfo = cpInfo;
    }

    public U2 getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(U2 constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }
}
