package org.nuc.purefriends.util;

import java.util.Random;

/**
 * Created by zhangliang on 15/11/13.
 */
public class StringUtil {

    private static final Integer DEFAULT_LENGTH = 30;

    public static String generateKey(Integer length) {

        if (length == null || length <= 0)
            length = DEFAULT_LENGTH;

        StringBuilder sb = new StringBuilder("");
        Random random = new Random();
        int type;
        char ch;

        for (int i = 0; i < length; ++i) {
            type = random.nextInt(3);
            if (type == 0) {
                ch = (char)((int)'0' + random.nextInt(10));
            } else if (type == 1) {
                ch = (char)((int)'a' + random.nextInt(26));
            } else {
                ch = (char)((int)'A' + random.nextInt(26));
            }
            sb.append( ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateKey(null));
    }
}
