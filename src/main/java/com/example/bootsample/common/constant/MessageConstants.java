package com.example.bootsample.common.constant;

import java.util.Arrays;

/**
 * Class Name : MessageConstants
 * Description : Response Message Code 상수
 * @author ybpark
 * @since 2021. 02. 17
 * @version 1.0
 */
public class MessageConstants {

    public enum ResponseEnum {


        SUCCESS("1", "SUCCESS"),                        //성공

        BAD_REQUEST("9000", "BAD_REQUEST"),             //BAD_REQUEST
        NOT_EXIST_RESPONSE("9001", "NOT_FOUNT"),        //NOT_FOUNT
        SERVER_ERROR("9999", "SERVER_ERROR"),           //SERVER_ERROR

        NOT_EXIST_MEMBER("9002", "NOT_EXIST_MEMBER"),   //NOT_EXIST_MEMBER
        ;

        private String code;
        private String desc;

        ResponseEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public String getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }

        // 메시지 가져오는 함수
        public static String findDescByCode(String code) {
            return Arrays.stream(values()).
                    filter(responseEnum -> responseEnum.getCode().equals(code)).findAny().orElse(NOT_EXIST_RESPONSE).getDesc();
        }
    }


}
