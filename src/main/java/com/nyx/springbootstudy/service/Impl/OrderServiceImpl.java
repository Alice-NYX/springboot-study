package com.nyx.springbootstudy.service.Impl;

import com.nyx.springbootstudy.mapper.OrderMapper;
import com.nyx.springbootstudy.mapper.UserMapper;
import com.nyx.springbootstudy.pojo.Order;
import com.nyx.springbootstudy.pojo.User;
import com.nyx.springbootstudy.service.OrderService;
//import mp.OrderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public Order insertOrder(String phoneNumber, String a_address,String current_location,String statue,String lat,String lng,String price){
        System.out.println(phoneNumber);
        System.out.println(a_address);
        Order order = new Order(phoneNumber,a_address,"0.0","0.0","1","1","1.00");
        orderMapper.insertOrder(phoneNumber,a_address,"1","1","0.0","0.0", "1.00");
        return order;
    }

    public Order findOrderByphoneNumber(String phoneNumber){
        return orderMapper.findOrderByphoneNumber(phoneNumber);
    }

    public void Updatestatue(String phoneNumber,String statue){
        System.out.println(phoneNumber);
        Order order=orderMapper.findOrderByphoneNumber(phoneNumber);
        order.setStatue("2");
        System.out.println(statue);
        orderMapper.Updatestatue(order);
    }

    public Order selectstatue(){
        return orderMapper.selectstatue();
    }

    @Override
    public void UpdateGPS(String latitude, String longitude) {
        System.out.println(latitude+longitude);
        orderMapper.UpdateGPS(latitude,longitude);
    }

    public Order selectGPS(){
        return orderMapper.selectGPS();
    }
}
