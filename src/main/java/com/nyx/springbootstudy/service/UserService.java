package com.nyx.springbootstudy.service;

import com.nyx.springbootstudy.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //查看电话号码

    public List<User> ListUser();

    public User insertUser(String encryptedData,String iv,String code,String openid,String session_key);

//    public String getSessionId(String code);



}
