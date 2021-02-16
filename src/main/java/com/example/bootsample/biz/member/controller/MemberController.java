package com.example.bootsample.biz.member.controller;

import com.example.bootsample.biz.member.model.MemberDTO;
import com.example.bootsample.biz.member.service.IMemberService;
import com.example.bootsample.common.model.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    IMemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTest() {

        logger.info("========== MemberController.getTest ==========");

        return memberService.getTest();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultDTO login(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {

        logger.info("========== MemberController.login Start ==========");

        ResultDTO resultObject = new ResultDTO("a","b","c");

        HttpSession session = request.getSession();
        session.setAttribute("memberInfo", memberDTO);

        logger.info("memberDTO : " + memberDTO);

        logger.info("========== MemberController.login End ==========");

        return resultObject;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultDTO logout(HttpServletRequest request) {

        logger.info("========== MemberController.logout Start ==========");

        ResultDTO resultObject = new ResultDTO("a","b","c");

        request.getSession().removeAttribute("memberInfo");
        request.getSession().invalidate();

        logger.info("========== MemberController.logout End ==========");

        return resultObject;
    }
}
