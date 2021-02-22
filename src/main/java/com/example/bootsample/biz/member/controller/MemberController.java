package com.example.bootsample.biz.member.controller;

import com.example.bootsample.biz.member.model.MemberDTO;
import com.example.bootsample.biz.member.service.IMemberService;
import com.example.bootsample.common.constant.MessageConstants;
import com.example.bootsample.common.model.ResultDTO;
import com.example.bootsample.common.util.BootSampleUtills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    public static final String PASSWORD_PATTERN =  "^[A-Za-z0-9]{3,}$"; // 영문, 숫자

    @Autowired
    IMemberService memberService;

    /**
     * 회원 로그인
     * @param memberDTO
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultDTO login(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {

        logger.info("========== MemberController.login Start ==========");

        int result = memberService.getLogin(memberDTO);

        if ( 1 == result) {

            HttpSession session = request.getSession();
            session.setAttribute("memberInfo", memberDTO);
        }

        logger.info("========== MemberController.login End ==========");

        return new ResultDTO();
    }

    /**
     * 회원 로그아웃
     * @param memberDTO
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultDTO logout(HttpServletRequest request) {

        logger.info("========== MemberController.logout Start ==========");

        request.getSession().removeAttribute("memberInfo");
        request.getSession().invalidate();

        logger.info("========== MemberController.logout End ==========");

        return new ResultDTO();
    }

    /**
     * 회원 아이디 체크
     * @param memId
     * @return
     */
    @RequestMapping(value = "/check/id/{memId}", method = RequestMethod.GET)
    public ResultDTO memberReg(@PathVariable String memId) {

        ResultDTO resultDTO = new ResultDTO();

        String nonDuplYn = memberService.searchMemIdNonDuplYn(memId);

        if (nonDuplYn == "N" ) {
            resultDTO.setData(MessageConstants.ResponseEnum.BAD_REQUEST);
        }

        return new ResultDTO();
    }

    /**
     * 회원생성
     * @param memberDTO
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ResultDTO memberRegister(@RequestBody MemberDTO memberDTO) {

        ResultDTO resultDTO = new ResultDTO();

        logger.info("========== MemberController.reg Start ==========");
        // TODO : 파라미터 체크 (@value로 파라미터 체크시 제거)
        if ( StringUtils.isEmpty(memberDTO.getMemId())
            || StringUtils.containsWhitespace(memberDTO.getMemId())
            || memberDTO.getMemId().length() > 32
            ) {
            resultDTO.setData(MessageConstants.ResponseEnum.BAD_REQUEST);
        }

        if (  StringUtils.isEmpty(memberDTO.getMemId())
                || StringUtils.containsWhitespace(memberDTO.getMemPwd())
                || !BootSampleUtills.pattertCheck(PASSWORD_PATTERN,memberDTO.getMemPwd())
                || !BootSampleUtills.pattertCheck("[A-Z]{1,}",memberDTO.getMemPwd())
                || !BootSampleUtills.pattertCheck("[a-z]{1,}",memberDTO.getMemPwd())
                || !BootSampleUtills.pattertCheck("[0-9]{1,}",memberDTO.getMemPwd())
        ) {
            resultDTO.setData(MessageConstants.ResponseEnum.BAD_REQUEST);
        }


        memberService.registerMember(memberDTO);

        logger.info("========== MemberController.reg End ==========");

        return new ResultDTO();
    }

    /**
     * 회원탛퇴
     * @param memId
     * @return
     */
    @RequestMapping(value = "/remove/{memId}", method = RequestMethod.DELETE)
    public ResultDTO memberRemove(@PathVariable String memId) {

        ResultDTO resultDTO = new ResultDTO();

        int cnt = memberService.removeMember(memId);
        if (cnt == 0) {
            resultDTO.setData(MessageConstants.ResponseEnum.BAD_REQUEST);
        }

        return new ResultDTO();
    }


}
