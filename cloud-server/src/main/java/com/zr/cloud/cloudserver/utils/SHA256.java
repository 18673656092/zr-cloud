package com.zr.cloud.cloudserver.utils;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhuran on 2018/8/13 0013
 */
public class SHA256 {
    public static String getSHA256String(String str) {
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }
}
