//package com.nyx.springbootstudy;
//
//import com.nyx.springbootstudy.contain.OrderContain;
//import com.nyx.springbootstudy.mapper.OrderMapper;
//import com.nyx.springbootstudy.service.OrderService;
//import com.nyx.springbootstudy.service.UserService;
//
//import mp.ContainHelper;
//import mp.OrderData;
//import mp.contain.Contain;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringbootStudyApplication.class)
//class SpringbootStudyApplicationTests {
//
//
//    @Autowired
//    OrderContain orderContain;
//
//    @Test
//    void test(){
//        List<OrderData> data=orderContain.doLoad(0,5);
//        //orderContain.orders();
//        Contain contain=ContainHelper.getContain("orderContain");
//        for(OrderData orderData:data){
//            System.out.println(orderData.getOrder());
//        }
//    }
//
//}
