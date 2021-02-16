package com.example.bootsample.common.model;

import lombok.Data;

@Data
public class ResultDTO {

    private String code;
    private String data;
    private String message;

    public ResultDTO(String code, String data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
