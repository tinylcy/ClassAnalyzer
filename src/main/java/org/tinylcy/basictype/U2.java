package org.tinylcy.basictype;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class U2 {

    private short value;

    public U2(short value) {
        this.value = value;
    }

    public static U2 read(InputStream inputStream) {
        byte[] bytes = new byte[2];
        try {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        short value = 0;
        for (int i = 0; i < 2; i++) {
            value <<= 8;
            value |= bytes[i] & 0xFF;
        }
        U2 u2 = new U2((short) (value & 0xFFFF));
        return u2;
    }

    public short getValue() {
        return value;
    }

    public String getHexValue() {
        return Integer.toHexString(value & 0xFFFF);
    }

}
