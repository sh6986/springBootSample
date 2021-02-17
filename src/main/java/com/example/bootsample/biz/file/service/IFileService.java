package com.example.bootsample.biz.file.service;

import com.example.bootsample.biz.file.model.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {

    /**
     * 파일 업로드
     * @param inputFile, fileDTO
     * @return
     */
    int uploadFile(MultipartFile inputFile, FileDTO fileDTO) throws IOException;

    /**
     * 파일 수정
     * @param fileDTO
     * @return
     */
    int modifyFile(FileDTO fileDTO);
}
