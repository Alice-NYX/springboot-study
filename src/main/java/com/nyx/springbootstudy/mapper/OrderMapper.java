package com.nyx.springbootstudy.mapper;

import com.nyx.springbootstudy.pojo.MP;
import com.nyx.springbootstudy.pojo.Order;
//import mp.OrderData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    //出问题就把类型改成void
    public void insertOrder(@Param("phoneNumber")String phone,@Param("a_address")String address,@Param("current_location")String current_location,@Param("statue")String statue,@Param("lat")String lat,@Param("lng")String lng,@Param("price")String price);
    public Order findOrderByphoneNumber(String phoneNumber);
    public void Updatestatue(Order order);
    public Order selectstatue();
    public void UpdateGPS(String latitude,String longitude);
    public Order selectGPS();

}
