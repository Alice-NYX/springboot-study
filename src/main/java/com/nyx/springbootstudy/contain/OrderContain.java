//package com.nyx.springbootstudy.contain;
//
//import com.nyx.springbootstudy.mapper.OrderMapper;
//import com.nyx.springbootstudy.pojo.Order;
//import com.nyx.springbootstudy.service.OrderService;
//import mp.OrderData;
//import mp.contain.ContainBase;
//import org.apache.catalina.mapper.Mapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderContain extends ContainBase {
//
//    @Autowired
//    private OrderMapper orderMapper;
//
//    @Override
//    public List<OrderData> doLoad(long beginOrder, int length) {
//        return orderMapper.OrderContain(beginOrder, length);
//    }
//}
