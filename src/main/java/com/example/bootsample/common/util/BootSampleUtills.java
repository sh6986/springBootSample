package com.example.bootsample.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BootSampleUtills {


    public static boolean pattertCheck(String pattern, String txt) {
        Matcher match = Pattern.compile(pattern).matcher(txt);
        return match.find();
    }

}
