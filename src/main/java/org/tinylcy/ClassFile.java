package org.tinylcy;

import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;
import org.tinylcy.constantpool.ConstantPoolInfo;

/**
 * Created by chenyangli on 17/2/7.
 */
public class ClassFile {

    public U4 magic;                   // magic
    public U2 minorVersion;            // minor_version
    public U2 majorVersion;            // major_version
    public U2 constantPoolCount;       // constant_pool_count
    public ConstantPoolInfo[] cpInfo;      // cp_info
    public U2 accessFlags;             // access_flags
    public U2 thisClass;               // this_class
    public U2 superClass;              // super_class
    public U2 interfacesCount;         // interfaces_count


}
