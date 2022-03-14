package com.nyx.springbootstudy.pojo;

public class User {

    private String phoneNumber;
    private String openid;
    private String session_key;
    private String encryptedData;
    private String iv;
    private String code;

    public User(){}

    public User(String encryptedData, String iv, String code) {
        this.encryptedData = encryptedData;
        this.iv = iv;
        this.code = code;
    }

    public User(String encryptedData, String iv, String code, String openid, String session_key) {
        this.encryptedData = encryptedData;
        this.iv = iv;
        this.code = code;
        this.openid = openid;
        this.session_key = session_key;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}