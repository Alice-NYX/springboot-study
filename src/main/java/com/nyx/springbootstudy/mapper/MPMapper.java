package com.nyx.springbootstudy.mapper;

import com.nyx.springbootstudy.pojo.MP;
import com.nyx.springbootstudy.pojo.User;
import com.nyx.springbootstudy.pojo.test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MPMapper {

    //出问题就把类型改成void
    public void insertMP(@Param("box_id")String box_id,@Param("phoneNumber")String phoneNumber);
    public MP selectMPphoneNumber(String phoneNumber);
    public MP selectresult(String result);
    public test ListMP();
    public MP selectbox_id();

}
