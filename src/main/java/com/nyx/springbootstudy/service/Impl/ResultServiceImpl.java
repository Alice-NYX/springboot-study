package com.nyx.springbootstudy.service.Impl;

import com.nyx.springbootstudy.mapper.ResultMapper;
import com.nyx.springbootstudy.pojo.Result;
import com.nyx.springbootstudy.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultMapper resultMapper;

    @Override
    public Result insertmp_result(String mp_result,String result) {
        Result result1=new Result(mp_result,"箱门已打开");
        resultMapper.insertmp_result(mp_result,"箱门已打开");
        return result1;
    }

    @Override
    public Result Listvx_result() {
        return resultMapper.Listvx_result();
    }
}
