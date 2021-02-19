package com.example.bootsample.biz.file.mapper;

import com.example.bootsample.biz.file.model.FileDTO;

import java.util.List;

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
     * 파일 단건 조회
     * @param fileNo
     * @return fileDTO
     */
    FileDTO selectFile(int fileNo);

    /**
     * 파일 리스트
     * @param fileDTO
     * @return
     */
    List<FileDTO> selectFileList(FileDTO fileDTO);

    /**
     * 파일 리스트 갯수
     * @param fileDTO
     * @return
     */
    int selectFileListCnt(FileDTO fileDTO);

}
