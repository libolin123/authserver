package com.maimeng.authserver.global.util;

import com.xiaoleilu.hutool.crypto.digest.DigestUtil;
import com.xiaoleilu.hutool.lang.Base64;

/**
 * @author wuweifeng wrote on 2018/10/30.
 */
public class Common {
    public static String md5(String str) {
        return DigestUtil.md5Hex(str);
    }

    public static String base64(String str) {
        return Base64.encode(str);
    }

    public static String base64Decode(String str) {
        return Base64.decodeStr(str);
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));
        System.out.println(base64("123456"));
    }
}
