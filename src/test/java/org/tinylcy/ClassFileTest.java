package org.tinylcy;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by chenyangli.
 */
public class ClassFileTest {

    @Test
    public void testTestClass() throws Exception {
        File file = new File("/path/to/TestClass.class");
        FileInputStream inputStream = new FileInputStream(file);
        ClassReader.analyze(inputStream);
    }

    @Test
    public void testObjectClass() throws Exception {
        File file = new File("/path/to/Object.class");
        FileInputStream inputStream = new FileInputStream(file);
        ClassReader.analyze(inputStream);
    }

    @Test
    public void testStringClass() throws Exception {
        File file = new File("/path/to/String.class");
        FileInputStream inputStream = new FileInputStream(file);
        ClassReader.analyze(inputStream);
    }
}
