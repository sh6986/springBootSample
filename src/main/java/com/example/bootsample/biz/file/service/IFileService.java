package com.example.bootsample.biz.file.service;

import com.example.bootsample.biz.file.model.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IFileService {

    /**
     * 파일 업로드
     * @param inputFile, fileDTO
     * @return
     */
    int uploadFile(MultipartFile inputFile, FileDTO fileDTO, String fileDesc) throws IOException;

    /**
     * 파일 수정
     * @param fileDTO
     * @return
     */
    int modifyFile(FileDTO fileDTO);

    /**
     * 파일 단건 조회
     * @param fileNo
     * @return fileDTO
     */
    FileDTO getFile(int fileNo);

    /**
     * 파일 리스트
     * @param fileDTO
     * @return
     */
    List<FileDTO> searchFileList(FileDTO fileDTO);

    /**
     * 파일 리스트 갯수
     * @param fileDTO
     * @return
     */
    int searchFileListCnt(FileDTO fileDTO);

}
