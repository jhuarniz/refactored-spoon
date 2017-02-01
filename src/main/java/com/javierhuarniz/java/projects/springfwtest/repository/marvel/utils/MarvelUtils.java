package com.javierhuarniz.java.projects.springfwtest.repository.marvel.utils;

import java.security.MessageDigest;

/**
 * Created by javier on 21/01/2017.
 */
public class MarvelUtils {

    public static String generateHash(byte[] bytes) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
