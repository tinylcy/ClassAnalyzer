package org.tinylcy.basictype;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by chenyangli on 17/2/7.
 */
public class BasicTypeTest {

    @Test
    public void testU1() throws  Exception{
        File file = new File("/Users/chenyangli/Code/org/fenixsoft/clazz/TestClass.class");
        FileInputStream inputStream = new FileInputStream(file);
        System.out.println(U1.read(inputStream).getValue());
    }
}
