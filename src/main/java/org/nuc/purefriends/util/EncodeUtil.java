package org.nuc.purefriends.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhangliang on 15/11/12.
 */
public class EncodeUtil {

    public static String encodeByMD5(String... params) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String result = null;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        for (String param : params) {
            md5.update( param.getBytes("UTF-8"));
        }
        result = new BigInteger( 1, md5.digest()).toString(16);
        return result;
    }
}
