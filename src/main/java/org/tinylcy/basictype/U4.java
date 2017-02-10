package org.tinylcy.basictype;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class U4 {

    private int value;

    public U4(int value) {
        this.value = value;
    }

    public static U4 read(InputStream inputStream) {
        byte[] bytes = new byte[4];
        try {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value <<= 8;
            value |= bytes[i] & 0xFF;
        }
        U4 u4 = new U4(value);
        return u4;
    }

    public int getValue() {
        return value;
    }

    public String getHexValue() {
        return Integer.toHexString(value);
    }

}
