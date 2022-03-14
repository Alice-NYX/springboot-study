package com.nyx.springbootstudy.service;

import com.nyx.springbootstudy.pojo.Order;
//import mp.OrderData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public Order insertOrder(String phoneNumber, String a_address,String current_location,String statue,String lat,String lng,String price);
    public Order findOrderByphoneNumber(String phoneNumber);
    public void Updatestatue(String phoneNumber,String statue);
    public Order selectstatue();
    public void UpdateGPS(String latitude,String longitude);
    public Order selectGPS();
}
