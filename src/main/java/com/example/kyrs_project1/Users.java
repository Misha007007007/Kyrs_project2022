package com.example.kyrs_project1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Users {
    private String login;
    private String hash_password;

    public String getLogin() {
        return login;
    }

    public String getHash_password() {
        return hash_password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHash_password(String hash_password) {
        this.hash_password = hash_password;
    }

    //функция хэширования
    public String hashing(String password) {
        hash_password = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] bytes = md.digest(password.getBytes());

            for (byte b : bytes) {
                hash_password += String.format("%02X", b);
            }

        } catch (NoSuchAlgorithmException e) {
            System.out.println("1");
        }
        return hash_password;


    }

}
