package com.nyx.springbootstudy.pojo;

public class test {
    private int box_id;
    private String a_address;

    public int getBox_id() {
        return box_id;
    }

    public void setBox_id(int box_id) {
        this.box_id = box_id;
    }

    public String getA_address() {
        return a_address;
    }

    public void setA_address(String a_address) {
        this.a_address = a_address;
    }

    public test(int box_id, String a_address) {
        this.box_id = box_id;
        this.a_address = a_address;
    }
    public test(){};
}
