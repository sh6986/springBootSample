package com.example.bootsample.biz.member.service.Impl;

import com.example.bootsample.biz.member.mapper.IBizMapper;
import com.example.bootsample.biz.member.service.IBizService;
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
