package com.nyx.springbootstudy.mapper;

import com.nyx.springbootstudy.pojo.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ResultMapper {
    public void insertmp_result(String mp_result,String result);
    public Result Listvx_result();
}
