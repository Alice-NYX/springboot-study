package com.nyx.springbootstudy.service.Impl;

import com.nyx.springbootstudy.mapper.MPMapper;
import com.nyx.springbootstudy.pojo.MP;
import com.nyx.springbootstudy.pojo.test;
import com.nyx.springbootstudy.service.MPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MPServiceImpl implements MPService {
    @Autowired
    private MPMapper mpMapper;

    public void insertMP(String box_id, String phoneNumber){
        mpMapper.insertMP("1",phoneNumber);
    }

    public MP selectMPphoneNumber(String phoneNumber) {
        return mpMapper.selectMPphoneNumber(phoneNumber);
    }

    public MP selectresult(String result){
        return mpMapper.selectresult(result);
    }

    public test ListMP(){
        return mpMapper.ListMP();
    }

    public MP selectbox_id(){
        return mpMapper.selectbox_id();
    }


}
