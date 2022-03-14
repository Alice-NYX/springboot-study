package com.nyx.springbootstudy.controller;

import com.nyx.springbootstudy.pojo.MP;
import com.nyx.springbootstudy.pojo.test;
import com.nyx.springbootstudy.service.MPService;
import com.nyx.springbootstudy.service.OrderService;
//import mp.ContainHelper;
//import mp.OrderData;
//import mp.contain.Contain;
//import mp.contain.NoDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/mp",method = {RequestMethod.GET,RequestMethod.POST})
public class MPController {
    @Autowired
    private MPService mpService;
    private OrderService orderService;
//
//    @GetMapping("/getOrder")
//    @ResponseBody
//    public OrderData getOrder(){
//        Contain orderContain=ContainHelper.getContain("orderContain");
//        try {
//            OrderData data=orderContain.getData();
//            return data;
//        } catch (NoDataException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    //存入全部
    @PostMapping(value = "/insertMP")
    public MP insertMP(@RequestParam("phoneNumber")String phoneNumber){
        //返回给前端的内容JSON格式
        return null;
    }

    //按要求查询
    @PostMapping(value="/selectMPphoneNumber")
    public MP selectMPphoneNumber(@RequestParam("phoneNumber")String phoneNumber){
        return mpService.selectMPphoneNumber(phoneNumber);
    }


    //读数据result
    @PostMapping(value = "/car_opendoor_resopnse")
    public String selectresult(@RequestParam("result")String result){
        String s1 = new String("ok");
        if (s1.equals(result)){
            return "箱门已打开";
        }
        return "false";
    }

    //告诉mp要开的box_id(查数据库最后一条数据)
    @GetMapping(value = "/mp_save_user_response")
    public test mp_save_user_response(){
        return mpService.ListMP();
    }


    //order_car_open (轮询)服务器查找数据库，告诉MP需要打开的箱门号
    @GetMapping(value = "/order_car_open")
    public MP order_car_open(){
        return mpService.selectbox_id();
    }


}
