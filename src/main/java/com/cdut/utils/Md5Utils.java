package com.cdut.utils;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Miracle Luna on 2019/11/18
 */
public class Md5Utils {

    /**
     * @param data
     * @return
     */
    public static String md5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return Hex.encodeHexString(md.digest(data.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        String password = "";
        String md5HexStr = md5(password);
        System.out.println("==> Before MD5: " + password);
        System.out.println("==> After MD5: " + md5HexStr);
    }
}
