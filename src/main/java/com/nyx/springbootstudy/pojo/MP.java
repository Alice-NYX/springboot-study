package com.nyx.springbootstudy.pojo;

public class MP {
    private int order_number;
    private int box_id;
    private String phoneNumber;
    private String a_address;

    public MP(){}

    public MP(int order_number, int box_id) {
        this.order_number = order_number;
        this.box_id = box_id;
    }

    public MP(int box_id) {
        this.box_id = box_id;
    }

    public MP(int order_number, int box_id, String phoneNumber) {
        this.order_number = order_number;
        this.box_id = box_id;
        this.phoneNumber = phoneNumber;
    }

    public MP(String order_number, String box_id, String phoneNumber) {
        this.order_number =  Integer.parseInt(order_number);
        this.box_id = Integer.parseInt(box_id);
        this.phoneNumber = phoneNumber;
    }

    public MP(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getBox_id() {
        return box_id;
    }

    public void setBox_id(int box_id) {
        this.box_id = box_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
