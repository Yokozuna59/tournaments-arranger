package com.swe206.group_two.backend.auth;

import org.apache.commons.codec.digest.DigestUtils;

public class Password {
    public static String createPasswordHash(String password) {
        return DigestUtils.sha512Hex(password);
    }

    public static void main(String[] args) {
        System.out.println(createPasswordHash("123456"));
    }
}
