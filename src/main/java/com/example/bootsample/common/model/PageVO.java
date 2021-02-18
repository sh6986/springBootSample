package com.example.bootsample.common.model;


import lombok.Data;

@Data
public class PageVO {

    String searchType;
    String searchWord;
    int page;
    int pageRange;

    public int getStartPage() {
        return (page-1) * pageRange;
    }


}
