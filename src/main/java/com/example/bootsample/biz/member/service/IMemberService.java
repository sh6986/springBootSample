package com.example.bootsample.biz.member.service;

import com.example.bootsample.biz.member.model.MemberDTO;

public interface IMemberService {

    /**
     * 회원가입
     * @param memberDTO
     * @return
     */
    int registerMember(MemberDTO memberDTO);

    /**
     * 회뤈아이디 체크
     * @param memId
     * @return
     */
    String searchMemIdNonDuplYn(String memId);

    /**
     * 회뤈탈퇴
     * @param memId
     * @return
     */
    int removeMember(String memId);
}
