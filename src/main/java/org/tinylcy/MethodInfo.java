package org.tinylcy;

import org.tinylcy.attributeinfo.BasicAttributeInfo;
import org.tinylcy.basictype.U2;
import org.tinylcy.constantpool.ConstantPool;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyangli on 17/2/9.
 */
public class MethodInfo {

    private short accessFlags;
    private short nameIndex;
    private short descriptorIndex;
    private short attributesCount;
    private BasicAttributeInfo[] attributes;

    public void read(ConstantPool constantPool, InputStream inputStream) {
        U2 accessFlagsU2 = U2.read(inputStream);
        U2 nameIndexU2 = U2.read(inputStream);
        U2 descriptorIndexU2 = U2.read(inputStream);
        U2 attributesCountIndexU2 = U2.read(inputStream);
        accessFlags = accessFlagsU2.getValue();
        nameIndex = nameIndexU2.getValue();
        descriptorIndex = descriptorIndexU2.getValue();
        attributesCount = attributesCountIndexU2.getValue();
        attributes = new BasicAttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            U2 attributeNameIndexU2 = U2.read(inputStream);
            short attributeNameIndex = attributeNameIndexU2.getValue();
            BasicAttributeInfo basicAttributeInfo = BasicAttributeInfo.newAttributeInfo(constantPool,
                    attributeNameIndex);
            basicAttributeInfo.read(constantPool, inputStream);
            attributes[i] = basicAttributeInfo;
        }
    }

    @Override
    public String toString() {
        return "MethodInfo{" +
                "accessFlags=" + accessFlags +
                ", nameIndex=" + nameIndex +
                ", descriptorIndex=" + descriptorIndex +
                ", attributesCount=" + attributesCount +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}
