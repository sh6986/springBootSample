package com.example.bootsample.common.model;

import com.example.bootsample.common.constant.MessageConstants;
import lombok.Data;

/**
 * Class Name : ResultDTO
 * Description : Response DTO
 * @author ybpark, ohsenghyun
 * @since 2021. 02. 17
 * @version 2.0
 */
@Data
public class ResultDTO {

    private String code;
    private Object data;
    private String message;


    public ResultDTO() {
            init();
    }

    public ResultDTO(String data) { this.data = data;  init(); }

    public ResultDTO(MessageConstants.ResponseEnum code) {
        this.code = code.getCode();
        this.message = code.getDesc();
        init();
    }
    public ResultDTO(MessageConstants.ResponseEnum code,Object data) {
        this.code = code.getCode();
        this.message = code.getDesc();
        this.data = data;
        init();
    }

    public ResultDTO(String code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        init();
    }

    protected void init() {
        this.message = (this.message == null ?  MessageConstants.ResponseEnum.SUCCESS.getDesc() : this.message );
        this.code = (this.code == null ? MessageConstants.ResponseEnum.SUCCESS.getCode() : this.code);
    }

}
