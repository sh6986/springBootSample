package com.example.bootsample.biz.member.service.Impl;

import com.example.bootsample.biz.member.mapper.IMemberMapper;
import com.example.bootsample.biz.member.model.MemberDTO;
import com.example.bootsample.biz.member.service.IMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class MemberService implements IMemberService {

    @Resource
    IMemberMapper memberMapper;

    /**
     * 로그인
     * @param memberDTO
     * @return
     */
    @Override
    public int getLogin(MemberDTO memberDTO) {
        return memberMapper.selectLogin(memberDTO);
    }

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

    /**
     * 회뤈아이디 체크
     * @param memId
     * @return
     */
    @Override
    public String searchMemIdNonDuplYn(String memId) {
        return memberMapper.selectMemIdNonDuplYn(memId);
    }

    /**
     * 회뤈탈퇴
     * @param memId
     * @return
     */
    @Override
    public int removeMember(String memId) {
        return memberMapper.deleteMember(memId);
    }
}
