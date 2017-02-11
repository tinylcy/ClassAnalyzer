package org.tinylcy.constantpool;

import org.tinylcy.basictype.U2;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by chenyangli.
 */
public class ConstantUtf8Info extends ConstantPoolInfo {

    private short length;
    private byte[] bytes;
    private String bytesValue;

    public ConstantUtf8Info(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream in) {
        U2 u2 = U2.read(in);
        this.length = u2.getValue();
        this.bytes = new byte[this.length];
        try {
            in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        convertMUTF8(bytes);
        this.bytesValue = getValue();
    }

    public void convertMUTF8(byte[] bytes) {
        byte[] originalBytes = bytes;
        int nullCount = 0;
        for (int i = 0; i < originalBytes.length; i++) {
            if (originalBytes[i] == 0) {
                nullCount++;
            }
        }
        byte[] convertedBytes = new byte[originalBytes.length + nullCount];
        for (int i = 0, j = 0; i < originalBytes.length; i++, j++) {
            convertedBytes[j] = originalBytes[i];
            if (originalBytes[i] == 0) {
                convertedBytes[j] = (byte) 0xC0;
                ++j;
                convertedBytes[j] = (byte) 0x80;
            }
        }
    }

    public short getLength() {
        return this.length;
    }

    public String getValue() {
        String ret = null;
        try {
            ret = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public String toString() {
        return "ConstantUtf8Info{" +
                "bytesValue='" + bytesValue + '\'' +
                '}';
    }
}
