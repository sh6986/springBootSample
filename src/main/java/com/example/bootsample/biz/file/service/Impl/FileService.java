package com.example.bootsample.biz.file.service.Impl;

import com.example.bootsample.biz.file.controller.FileController;
import com.example.bootsample.biz.file.mapper.IFileMapper;
import com.example.bootsample.biz.file.model.FileDTO;
import com.example.bootsample.biz.file.service.IFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Service
public class FileService implements IFileService {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Resource
    IFileMapper fileMapper;

    /**
     * 파일 업로드
     * @param inputFile, fileDTO
     * @return
     */
    @Override
    public int uploadFile(MultipartFile inputFile, FileDTO fileDTO) throws IOException {

        logger.info("========== FileService.uploadFile Start ==========");

        int result = fileMapper.insertFile(fileDTO);

        // 성공시 파일 저장
        if (1 == result) {

            File dest = new File(fileDTO.getFilePath() + fileDTO.getOriginName());
            inputFile.transferTo(dest);

            return result;
        }

        logger.info("========== FileService.uploadFile End ==========");

        return 0;
    }

    /**
     * 파일 수정
     * @param fileDTO
     * @return
     */
    @Override
    public int modifyFile(FileDTO fileDTO) {
        return fileMapper.updateFile(fileDTO);
    }
}
