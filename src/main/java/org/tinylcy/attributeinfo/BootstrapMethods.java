package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;
import org.tinylcy.constantpool.ConstantPool;
import org.tinylcy.constantpool.ConstantUtf8Info;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class BootstrapMethods extends BasicAttributeInfo {

    private short numBootstrapMethods;
    private BootstrapMethod[] bootstrapMethod;

    public BootstrapMethods(ConstantPool constantPool, short attributeNameIndex) {
        super(constantPool);
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 numBootstrapMethodsU2 = U2.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        numBootstrapMethods = numBootstrapMethodsU2.getValue();
        bootstrapMethod = new BootstrapMethod[numBootstrapMethods];
        for (int i = 0; i < numBootstrapMethods; i++) {
            bootstrapMethod[i] = new BootstrapMethod();
            bootstrapMethod[i].read(inputStream);
        }
    }

    @Override
    public String toString() {
        return "BootstrapMethods{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                " [attribute name = " + ((ConstantUtf8Info) (constantPool.getCpInfo()[getAttributeNameIndex() - 1])).getValue() + "]" +
                ", attributeLength=" + getAttributeLength() +
                ", numBootstrapMethods=" + numBootstrapMethods +
                ", bootstrapMethod=" + Arrays.toString(bootstrapMethod) +
                '}';
    }

    private class BootstrapMethod {

        public short bootstrapMethodRef;
        public short numBootstrapArguments;
        public short bootstrapArguments;

        public void read(InputStream inputStream) {
            U2 bootstrapMethodRefU2 = U2.read(inputStream);
            U2 numBootstrapArgumentsU2 = U2.read(inputStream);
            U2 bootstrapArgumentsU2 = U2.read(inputStream);
            this.bootstrapMethodRef = bootstrapMethodRefU2.getValue();
            this.numBootstrapArguments = numBootstrapArgumentsU2.getValue();
            this.bootstrapArguments = bootstrapArgumentsU2.getValue();
        }

        @Override
        public String toString() {
            return "BootstrapMethod{" +
                    "bootstrapMethodRef=" + bootstrapMethodRef +
                    ", numBootstrapArguments=" + numBootstrapArguments +
                    ", bootstrapArguments=" + bootstrapArguments +
                    '}';
        }
    }
}
