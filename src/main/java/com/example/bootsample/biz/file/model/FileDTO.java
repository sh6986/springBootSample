package com.example.bootsample.biz.file.model;

import com.example.bootsample.common.model.PageVO;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileDTO extends PageVO {
    private int fileNo;
    private String originName;
    private String storedName;
    private long fileSize;
    private String filePath;
    private String memId;
    private String fileType;
    private String regDate;
    private DelYn delYn;
    private String updateDate;
    private String fileDesc;
}
