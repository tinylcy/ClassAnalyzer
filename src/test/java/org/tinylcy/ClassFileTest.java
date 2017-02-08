package org.tinylcy;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by chenyangli on 17/2/7.
 */
public class ClassFileTest {

    @Test
    public void classfile() throws Exception {
        File file = new File("/Users/chenyangli/Code/org/fenixsoft/clazz/TestClass.class");
        FileInputStream inputStream = new FileInputStream(file);
        ClassReader.read(inputStream);
    }
}
