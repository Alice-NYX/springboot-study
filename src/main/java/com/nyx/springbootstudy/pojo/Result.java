package com.nyx.springbootstudy.pojo;

public class Result {
    private String mp_result;
    private String result;
    private int order_number;

    public Result(String mp_result, String result) {
        this.mp_result = mp_result;
        this.result = result;
    }

    public Result(){};

    public String getMp_result() {
        return mp_result;
    }

    public void setMp_result(String mp_result) {
        this.mp_result = mp_result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }
}
