package com.z.sharding.util;

import java.util.zip.CRC32;

public class CRC32Util {

    public static long hash(String value) {
        CRC32 crc = new CRC32();
        crc.update(value.getBytes());
        return crc.getValue() & 0xffffffffL;
    }
}
