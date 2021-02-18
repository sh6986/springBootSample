package com.example.bootsample.biz.file.mapper;

import com.example.bootsample.biz.file.model.FileDTO;

public interface IFileMapper {

    /**
     * 파일 업로드
     * @param fileDTO
     * @return
     */
    int insertFile(FileDTO fileDTO);

    /**
     * 파일 수정
     * @param fileDTO
     * @return
     */
    int updateFile(FileDTO fileDTO);

    /**
     * 파일 조회
     * @param fileNo
     * @return fileDTO
     */
    FileDTO selectFile(int fileNo);

}
