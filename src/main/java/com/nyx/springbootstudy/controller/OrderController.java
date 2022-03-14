package com.nyx.springbootstudy.controller;

import com.alibaba.fastjson.JSONObject;
import com.nyx.springbootstudy.pojo.MP;
import com.nyx.springbootstudy.pojo.Order;
import com.nyx.springbootstudy.pojo.User;
import com.nyx.springbootstudy.service.MPService;
import com.nyx.springbootstudy.service.OrderService;
import com.nyx.springbootstudy.until.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/order",method = {RequestMethod.GET,RequestMethod.POST})
public class OrderController {

    @Autowired
    private OrderService orderService;
    private MPService mpService;

    public OrderController(MPService mpService) {
        this.mpService = mpService;
    }

    //收到并存入并给微信看
    @PostMapping(value = "/save_user_response")
    public String save_user_response(@RequestParam("phoneNumber")String phoneNumber,
                                 @RequestParam("a_address")String a_address){
        //存入数据
        orderService.insertOrder(phoneNumber, a_address,"1","1","0.0","0.0","1.00");
        mpService.insertMP("1",phoneNumber);
        mpService.selectMPphoneNumber(phoneNumber);
        return "下单成功";
    }

    //save_ok 用户关闭箱门后小程序上向后台服务器发送save_ok，改变订单状态
    @PostMapping(value = "/save_ok")
    public String save_ok(@RequestParam("result") String result,
                          @RequestParam("phoneNumber")String phoneNumber){
        String s1 = new String("存餐完毕");
        if (s1.equals(result)){
            orderService.Updatestatue(phoneNumber,"2");//有问题
            return "存餐完毕";
        }
        return "存餐失败";
    }

    //payment界面
    @PostMapping(value = "/ok")
    public String ok(@RequestParam("resultType") String resultType){
        String s1 = new String("success");
        if (s1.equals(resultType)){
            return "付款成功";
        }

        return "付款失败";
    }



    //存入全部
    @PostMapping(value = "/insertOrder")
    public Order insertOrder(@RequestParam("phoneNumber")String phoneNumber,
                             @RequestParam("a_address")String a_address){
        //返回给前端的内容JSON格式

        return orderService.insertOrder(phoneNumber, a_address,"1","1","0.0","0.0","1.00");
    }

    //car_information(服务器接收当前位置的经纬度坐标)
    @PostMapping(value = "/car_information")
    public String car_information(@RequestParam("latitude")String latitude,
                                  @RequestParam("longitude")String longitude){
        orderService.UpdateGPS(latitude,longitude);
        return "已接受经纬度数据";
    }


    //vx_car_information(vx接收当前位置的经纬度坐标)
    @GetMapping (value = "/vx_car_information")
    public Order vx_car_information(){
        return orderService.selectGPS();
    }


    //order_get 用户点击取餐按钮，点击按钮后微信小程序调用wx.login()获取用户的code，然后发送给服务器
    @PostMapping(value = "/order_get")
    public String order_get(@RequestParam("code")String code){
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx59ae8cff646027e8&secret=b1784e965a1b5eac3293df83eaf298d3"+"&js_code="+code+"&grant_type=authorization_code";
        String str = WeChatUtil.httpRequest(url, "GET", null);
        JSONObject json=JSONObject.parseObject(str);
        User user=new User();
        user.setOpenid(json.getString("openid"));
        System.out.println(user.getOpenid());
        return "ok";
    }


    //order_ok 对于服务器来说和order_get一起进行。用户点击取餐后（order_get），后台服务器通过取餐次数进行计数，达到次数告诉MP去往下个地方
    @GetMapping(value = "/order_ok")
    public String order_ok(){
        String result=new String("true");
        return result;
    }
}
