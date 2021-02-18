package com.example.bootsample.common.util;

import com.example.bootsample.common.model.PageVO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BootSampleUtills {


    public static boolean pattertCheck(String pattern, String txt) {
        Matcher match = Pattern.compile(pattern).matcher(txt);
        return match.find();
    }

    public static void pageInit(PageVO pageVO) {
        pageVO.setPage( pageVO.getPage() < 1 ? 1 : pageVO.getPage() ) ;
        pageVO.setPageRange( pageVO.getPageRange() < 1  || pageVO.getPageRange() > 100 ? 10 : pageVO.getPageRange() ); ;
    }

}
