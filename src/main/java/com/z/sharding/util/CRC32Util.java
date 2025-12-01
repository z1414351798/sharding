package com.z.sharding.util;

import java.util.zip.CRC32;

public class CRC32Util {

    public static int hash(String value) {
        CRC32 crc = new CRC32();
        crc.update(value.getBytes());
        return (int)(crc.getValue() & 0xffffffffL);
    }
}
