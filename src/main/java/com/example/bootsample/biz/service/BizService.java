package com.example.bootsample.biz.service;

import com.example.bootsample.biz.mapper.Impl.IBizMapper;
import com.example.bootsample.biz.service.Impl.IBizService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BizService implements IBizService {

    @Resource
    IBizMapper bizMapper;

    @Override
    public String getTest() {
        int param = 411;
        return ""+bizMapper.selectTest(param);
    }
}
