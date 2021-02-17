package com.example.bootsample.biz.member.mapper;

import com.example.bootsample.biz.member.model.MemberDTO;

public interface IMemberMapper {

    /**
     * 회원가입
     * @param memberDTO
     * @return
     */
    int insertMember(MemberDTO memberDTO);
}