package com.nyx.springbootstudy.controller;


import com.alibaba.fastjson.JSONObject;
import com.nyx.springbootstudy.pojo.User;
import com.nyx.springbootstudy.service.Impl.UserServiceImpl;
import com.nyx.springbootstudy.until.WeChatUtil;
import com.sun.java.browser.plugin2.liveconnect.v1.Result;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nyx.springbootstudy.until.AES.wxDecrypt;

@RestController
@RequestMapping(value="/user",method = {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //查看整个User表
    @GetMapping("/listUser")
    public List<User> ListUser(){
        return userService.ListUser();
    }


    //存入
    @GetMapping("/wxauth")
    public User getsession(@RequestParam("encryptedData")String encryptedData,
                           @RequestParam("iv")String iv,
                           @RequestParam("code")String code){
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx59ae8cff646027e8&secret=b1784e965a1b5eac3293df83eaf298d3"+"&js_code="+code+"&grant_type=authorization_code";
        String str = WeChatUtil.httpRequest(url, "GET", null);
        JSONObject json=JSONObject.parseObject(str);
    /*if(null==json.get("errcode")){
        PageData pd = new PageData();
        pd.put("avatar", param.get("avatarUrl"));
        pd.put("province", param.get("province"));
        pd.put("city", param.get("city"));
        pd.put("nickName", param.get("nickName"));
        json.putAll(pd);
    }*/
        User user=new User();
        user.setOpenid(json.getString("openid"));
        user.setSession_key(json.getString("session_key"));
        return userService.insertUser(encryptedData,iv,code, user.getOpenid(), user.getSession_key());
    }

    //测试手机解密
    @PostMapping("/lo")
    public JSONObject wxauth(@RequestParam("encryptedData")String encryptedData,
                             @RequestParam("iv")String iv,
                             @RequestParam("session_key")String session_key){
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx59ae8cff646027e8&secret=b1784e965a1b5eac3293df83eaf298d3"+"&js_code="+code+"&grant_type=authorization_code";
//        String str = WeChatUtil.httpRequest(url, "GET", null);
//        JSONObject json=JSONObject.parseObject(str);
//        User user=new User();
//        user.setOpenid(json.getString("openid"));
//        user.setSession_key(json.getString("session_key"));
//        userService.insertUser(encryptedData,iv,code, user.getOpenid(), user.getSession_key());
//        System.out.println(json);
        String json1 = wxDecrypt(encryptedData,session_key,iv);
        User user=JSONObject.parseObject(json1,User.class);
        String phoneNumber = user.getPhoneNumber();//电话号码
        JSONObject result = new JSONObject();
        result.put("session_key",session_key);
        result.put("phoneNumber",phoneNumber);
        System.out.println(result);
        return result;
    }


}
