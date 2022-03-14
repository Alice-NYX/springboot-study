package com.nyx.springbootstudy.service.Impl;

import com.nyx.springbootstudy.pojo.User;
import com.nyx.springbootstudy.service.UserService;
import com.nyx.springbootstudy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //查看电话号码

    //查User所有信息
    public List<User> ListUser(){
        return userMapper.ListUser();
    }

    //code
    public User insertUser(String encryptedData,String iv,String code,String openid,String session_key){
        User user = new User(encryptedData,iv,code,openid,session_key);
        userMapper.insertUser(user);
        System.out.println(encryptedData);
        System.out.println(iv);
        System.out.println(code);
        return user;
    }




//    public User selectphoneNumber(String code){
//        return userMapper.selectphoneNumber(code);
//    }
/*
    //更新电话数据
    public int Update(String phoneNumber){
        User user = (User) userMapper.selectphoneNumber(phoneNumber);
        user.setPhoneNumber(phoneNumber);
        return userMapper.Update(user);
    }

 */
}
