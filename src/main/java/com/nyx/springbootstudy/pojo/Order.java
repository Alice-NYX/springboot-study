package com.nyx.springbootstudy.pojo;

//import mp.OrderData;
import org.springframework.format.annotation.DateTimeFormat;
import sun.util.calendar.BaseCalendar;


//通过socket通道连接每一个用户
public class Order  {
    private String phoneNumber;
    private String a_address;
    private int order_number;
    private String latitude;
    private String longitude;
    private String current_location;
    private String statue;
    private String price;

//    @Override
//    public long getOrder() {
//        return order_number;
//    }

    public Order(String phoneNumber, String a_address, int order_number, String latitude, String longitude, String current_location, String statue, String price) {
        this.phoneNumber = phoneNumber;
        this.a_address = a_address;
        this.order_number = order_number;
        this.latitude = latitude;
        this.longitude = longitude;
        this.current_location = current_location;
        this.statue = statue;
        this.price = price;
    }

    public Order(String phoneNumber, String a_address, String latitude, String longitude, String current_location, String statue, String price) {
        this.phoneNumber = phoneNumber;
        this.a_address = a_address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.current_location = current_location;
        this.statue = statue;
        this.price = price;
    }

    public Order(String phoneNumber, String a_address, String latitude, String longitude, String current_location, String statue) {
        this.phoneNumber = phoneNumber;
        this.a_address = a_address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.current_location = current_location;
        this.statue = statue;
    }

    public Order(String phoneNumber, String a_address, int order_number, String current_location, String statue) {
        this.phoneNumber = phoneNumber;
        this.a_address = a_address;
        this.order_number = order_number;
        this.current_location = current_location;
        this.statue = statue;
    }

    public Order(String a_address, int order_number, String current_location, String statue) {
        this.a_address = a_address;
        this.order_number = order_number;
        this.current_location = current_location;
        this.statue = statue;
    }

    public Order(String phoneNumber, String a_address, String current_location, String statue) {
        this.phoneNumber = phoneNumber;
        this.a_address = a_address;
        this.current_location = current_location;
        this.statue = statue;
    }

    public Order(String phoneNumber, String statue) {
        this.phoneNumber = phoneNumber;
        this.statue = statue;
    }

    public Order() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getA_address() {
        return a_address;
    }

    public void setA_address(String a_address) {
        this.a_address = a_address;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(String current_location) {
        this.current_location = current_location;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
