package com.nyx.springbootstudy.service;

import com.nyx.springbootstudy.pojo.MP;
import com.nyx.springbootstudy.pojo.test;
import org.springframework.stereotype.Service;

@Service
public interface MPService {
    public void insertMP(String box_id,String phoneNumber);
    public MP selectMPphoneNumber(String phoneNumber);
    public MP selectresult(String result);
    public test ListMP();
    public MP selectbox_id();

}
