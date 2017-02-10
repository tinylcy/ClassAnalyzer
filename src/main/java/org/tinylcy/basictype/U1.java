package org.tinylcy.basictype;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class U1 {

    private byte value;

    public U1(byte value) {
        this.value = value;
    }

    public static U1 read(InputStream inputStream) {
        byte[] bytes = new byte[1];
        try {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        U1 u1 = new U1(bytes[0]);
        return u1;
    }

    public byte getValue() {
        return value;
    }

    public String getHexValue() {
        return Integer.toHexString(value & 0xFF);
    }


}
