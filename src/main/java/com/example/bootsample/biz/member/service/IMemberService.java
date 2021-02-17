package com.example.bootsample.biz.member.service;

import com.example.bootsample.biz.member.model.MemberDTO;

public interface IMemberService {

    String getTest();

    /**
     * 회원가입
     * @param memberDTO
     * @return
     */
    int registerMember(MemberDTO memberDTO);


}
