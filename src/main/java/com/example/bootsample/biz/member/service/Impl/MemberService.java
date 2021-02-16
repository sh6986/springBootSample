package com.example.bootsample.biz.member.service.Impl;

import com.example.bootsample.biz.member.mapper.IMemberMapper;
import com.example.bootsample.biz.member.service.IMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberService implements IMemberService {

    @Resource
    IMemberMapper memberMapper;

    @Override
    public String getTest() {
        int param = 411;
        return ""+memberMapper.selectTest(param);
    }
}
