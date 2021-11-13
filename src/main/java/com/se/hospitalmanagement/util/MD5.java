package com.lin.appapidemo.util;

import org.apache.commons.codec.binary.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String EncodeByMD5(String str) throws NoSuchAlgorithmException,UnsupportedEncodingException{
        MessageDigest md5=MessageDigest.getInstance("MD5");
        Encoder base64Encoder=null;
        String newStr=base64Encoder.encodeToString(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }
}
