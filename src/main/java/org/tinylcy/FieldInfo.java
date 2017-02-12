package org.tinylcy;

import org.tinylcy.attributeinfo.AttributeInfo;
import org.tinylcy.attributeinfo.BasicAttributeInfo;
import org.tinylcy.basictype.U2;
import org.tinylcy.constantpool.ConstantPool;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class FieldInfo {

    private short accessFlags;
    private short nameIndex;
    private short descriptorIndex;
    private short attributesCount;
    private BasicAttributeInfo[] attributes;

    public void read(ConstantPool constantPool, InputStream inputStream) {
        U2 accessFlagsU2 = U2.read(inputStream);
        U2 nameIndexU2 = U2.read(inputStream);
        U2 descriptorIndexU2 = U2.read(inputStream);
        U2 attributesCountU2 = U2.read(inputStream);
        this.accessFlags = accessFlagsU2.getValue();
        this.nameIndex = nameIndexU2.getValue();
        this.descriptorIndex = descriptorIndexU2.getValue();
        this.attributesCount = attributesCountU2.getValue();

        ArrayList<BasicAttributeInfo> basicAttributeInfoList = new ArrayList<BasicAttributeInfo>();
        for (int i = 0; i < attributesCount; i++) {
            short attributeNameIndex = U2.read(inputStream).getValue();
            BasicAttributeInfo basicAttributeInfo = BasicAttributeInfo.newAttributeInfo(constantPool, attributeNameIndex);
            basicAttributeInfo.read(constantPool, inputStream);
        }
        this.attributes = basicAttributeInfoList.toArray(new AttributeInfo[0]);
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "accessFlags=" + accessFlags +
                ", nameIndex=" + nameIndex +
                ", descriptorIndex=" + descriptorIndex +
                ", attributesCount=" + attributesCount +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }

}
