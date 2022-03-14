package com.nyx.springbootstudy.mapper;

import com.nyx.springbootstudy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    //出问题就把类型改成void

    // 列出全部的user信息
    public List<User> ListUser();
    //查看电话号码
    public  User selectphoneNumber(String phoneNumber);
    // 插入user信息
    public  int insertUser(User user);
 /*

    public  User insertWX(String phoneNumber,String a_address);

    public  String insertCar(String order_number, String car_id, String box_id);

    // 删除user信息
    public int delete(int id);

    // 更新user信息
    public int Update(User user);

  */
}
