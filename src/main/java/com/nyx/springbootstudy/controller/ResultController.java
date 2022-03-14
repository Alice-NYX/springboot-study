package com.nyx.springbootstudy.controller;

import com.nyx.springbootstudy.pojo.MP;
import com.nyx.springbootstudy.pojo.Order;
import com.nyx.springbootstudy.pojo.Result;
import com.nyx.springbootstudy.service.MPService;
import com.nyx.springbootstudy.service.OrderService;
import com.nyx.springbootstudy.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/result",method = {RequestMethod.GET,RequestMethod.POST})
public class ResultController {
    @Autowired
    private ResultService resultService;
    private OrderService orderService;

    //car_opendoor 后台服务器收到MP的car_opendoor
    @PostMapping(value = "/insertmp_result")
    public String insertmp_result(@RequestParam("mp_result") String mp_result){
        String s1= new String("ok");
        if (s1.equals(mp_result)){
            resultService.insertmp_result(mp_result,"箱门已打开");
            return "服务器已收到";
        }
        return "错误指令";
    }

    //轮询：箱门已打开 返回箱门已打开指令给微信小程序
    @GetMapping(value = "/car_opendoor_resopnse")
    public Result car_opendoor_resopnse(){
        return resultService.Listvx_result();
    }

    //car_run 服务器通过对save_ok计数达到五个后发送car_run告诉MP发车
    @GetMapping(value = "/car_run")
    public String car_run(){
        return "发车";
    }



    //car_get  小车到达指定取餐位置后，MP向后台服务器发送
    @PostMapping(value = "/car_get")
    public String car_get(@RequestParam("result") String result,
                          @RequestParam("latitude") String latitude,
                          @RequestParam("longitude") String longitude){
        String s1=new String("arrive");
        if (s1.equals(result)){

            return "服务器已收到";
        }
        return "错误指令";
    }


//    //order_ok 用户拿到餐后，后台服务器通过次数计数,完成取餐
//    @PostMapping(value ="/order_ok")
}
