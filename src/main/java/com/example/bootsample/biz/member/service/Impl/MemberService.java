package com.example.bootsample.biz.member.service.Impl;

import com.example.bootsample.biz.member.mapper.IMemberMapper;
import com.example.bootsample.biz.member.model.MemberDTO;
import com.example.bootsample.biz.member.service.IMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberService implements IMemberService {

    @Resource
    IMemberMapper memberMapper;

    /**
     * 회원가입
     * @param memberDTO
     * @return
     */
    @Override
    public int registerMember(MemberDTO memberDTO) {
        // TODO : 암호화 검사
        return memberMapper.insertMember(memberDTO);
    }
}
