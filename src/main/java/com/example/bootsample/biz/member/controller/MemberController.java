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

    public static final String PASSWORD_PATTERN =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}";

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

        // 유효성 검사
        if ( StringUtils.isEmpty(memberDTO.getMemId())
                || StringUtils.containsWhitespace(memberDTO.getMemId())
        ) {
            return new ResultDTO(MessageConstants.ResponseEnum.BAD_REQUEST);
        }

        if (  StringUtils.isEmpty(memberDTO.getMemPwd())
                || StringUtils.containsWhitespace(memberDTO.getMemPwd())
                || !BootSampleUtills.pattertCheck(PASSWORD_PATTERN,memberDTO.getMemPwd())
        ) {
            return new ResultDTO(MessageConstants.ResponseEnum.BAD_REQUEST);
        }

        int result = memberService.getLogin(memberDTO);

        if (1 == result) {

            HttpSession session = request.getSession();
            session.setAttribute("memberInfo", memberDTO);

            return new ResultDTO();
        }

        logger.info("========== MemberController.login End ==========");

        return new ResultDTO(MessageConstants.ResponseEnum.BAD_REQUEST);
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

        String nonDuplYn = memberService.searchMemIdNonDuplYn(memId);

        if ("N".equals(nonDuplYn)) {
            return new ResultDTO(MessageConstants.ResponseEnum.BAD_REQUEST);
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

        logger.info("========== MemberController.reg Start ==========");
        // TODO : 파라미터 체크 (@value로 파라미터 체크시 제거)
        if ( StringUtils.isEmpty(memberDTO.getMemId())
            || StringUtils.containsWhitespace(memberDTO.getMemId())
            || memberDTO.getMemId().length() > 32
            ) {
            return new ResultDTO(MessageConstants.ResponseEnum.BAD_REQUEST);
        }

        if (  StringUtils.isEmpty(memberDTO.getMemPwd())
                || StringUtils.containsWhitespace(memberDTO.getMemPwd())
                || !BootSampleUtills.pattertCheck(PASSWORD_PATTERN,memberDTO.getMemPwd())
        ) {
            return new ResultDTO(MessageConstants.ResponseEnum.BAD_REQUEST);
        }

        // 아이디 중복 검사
        String nonDuplYn = memberService.searchMemIdNonDuplYn(memberDTO.getMemId());

        if ("N".equals(nonDuplYn)) {
            return new ResultDTO(MessageConstants.ResponseEnum.BAD_REQUEST);
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

        int cnt = memberService.removeMember(memId);
        if (cnt == 0) {
            return new ResultDTO(MessageConstants.ResponseEnum.BAD_REQUEST);
        }

        return new ResultDTO();
    }


}
