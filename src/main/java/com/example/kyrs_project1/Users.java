package com.example.kyrs_project1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Users {
    private String login;
    private String hash_password;
    private int role;
    private String band;

    private QuotesContainer quotesContainer;

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

    public Users(String login, String hash_password, int role, String band, QuotesContainer quotesContainer) {
        this.login = login;
        this.hash_password = hash_password;
        this.role = role;
        this.band = band;
        this.quotesContainer = quotesContainer;
    }

    public Users() {

    }

    @Override
    public String toString() {
        return "Users{" +
                "login='" + login + '\'' +
                ", hash_password='" + hash_password + '\'' +
                ", role=" + role +
                ", band=" + band +
                ", quotesContainer=" + quotesContainer +
                '}';
    }

    //функция хэширования
    public static String MakeHashing(String password) {
        String hash_password = "";
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

    public int getRole() {
        return role;
    }

    public String getBand() {
        return band;
    }

    public QuotesContainer getQuotesContainer() {
        return quotesContainer;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public void setQuotesContainer(QuotesContainer quotesContainer) {
        this.quotesContainer = quotesContainer;
    }



}
