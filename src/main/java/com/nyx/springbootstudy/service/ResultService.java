package com.nyx.springbootstudy.service;

import com.nyx.springbootstudy.pojo.Result;
import org.springframework.stereotype.Service;

@Service
public interface ResultService {
    public Result insertmp_result(String mp_result,String result);
    public Result Listvx_result();
}
