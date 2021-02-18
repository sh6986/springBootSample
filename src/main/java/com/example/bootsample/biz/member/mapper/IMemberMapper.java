package com.example.bootsample.biz.member.mapper;

import com.example.bootsample.biz.member.model.MemberDTO;

public interface IMemberMapper {

    /**
     * 회원가입
     * @param memberDTO
     * @return
     */
    int insertMember(MemberDTO memberDTO);

    /**
     * 회원아이디 체크
     * @param memId
     * @return
     */
    String selectMemIdNonDuplYn(String memId);

    /**
     * 회원 탈퇴
     * @param memId
     * @return
     */
    int deleteMember(String memId);
}
