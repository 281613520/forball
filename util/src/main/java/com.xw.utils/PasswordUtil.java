package com.xw.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Ankh on 2017/7/30.
 */
public class PasswordUtil {

    private static final String ADMIN_SALT = "d702848462753d46fb160f8ba10095c14914531f";
    public static String encodePassword(String password,String salt){
        return DigestUtils.sha1Hex((getNewSalt(salt)+password).getBytes());
    }

    public static boolean authen(String password,String salt,String userPassword){
        return password.equalsIgnoreCase(encodePassword(userPassword,salt));
    }

    //生成新的salt
    private static String getNewSalt(String identity){
        return Base64.encodeBase64String((identity+ADMIN_SALT).getBytes());
    }

    @Deprecated
    public static void main(String[] args) {
        Random ranGen = new SecureRandom();
        byte[] aesKey = new byte[20];
        ranGen.nextBytes(aesKey);
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < aesKey.length; i++) {
            String hex = Integer.toHexString(0xff & aesKey[i]);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        System.out.println(hexString);
    }
}
