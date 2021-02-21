package com.example.bootsample.biz.file.service.Impl;

import com.example.bootsample.biz.file.controller.FileController;
import com.example.bootsample.biz.file.mapper.IFileMapper;
import com.example.bootsample.biz.file.model.FileDTO;
import com.example.bootsample.biz.file.service.IFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
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
    public int uploadFile(MultipartFile inputFile, FileDTO fileDTO, String fileDesc) throws IOException {

        logger.info("========== FileService.uploadFile Start ==========");

        // 현재 시간을 기준으로 서버에 저장할 파일이름 생성
        StringBuffer storedName = new StringBuffer();
        Calendar cal = Calendar.getInstance();
        storedName.append(cal.get(Calendar.YEAR))
                .append(cal.get(Calendar.MONTH))
                .append(cal.get(Calendar.DATE))
                .append(cal.get(Calendar.HOUR))
                .append(cal.get(Calendar.MINUTE))
                .append(cal.get(Calendar.SECOND))
                .append(cal.get(Calendar.MILLISECOND));

        fileDTO.setOriginName(inputFile.getOriginalFilename());
        fileDTO.setStoredName(storedName.toString());
        fileDTO.setFileSize(inputFile.getSize());
        fileDTO.setFilePath("C:\\file\\" + storedName.toString());
        fileDTO.setFileType(inputFile.getContentType());
        fileDTO.setFileDesc(fileDesc);

        int result = fileMapper.insertFile(fileDTO);

        // 성공시 파일 저장
        if (1 == result) {

            File dest = new File(fileDTO.getFilePath());
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

    /**
     * 파일 단건 조회
     * @param fileNo
     * @return fileDTO
     */
    @Override
    public FileDTO getFile(int fileNo) {
        return fileMapper.selectFile(fileNo);
    }

    @Override
    public List<FileDTO> searchFileList(FileDTO fileDTO) {
        return fileMapper.selectFileList(fileDTO);
    }

    /**
     * 파일 리스트 갯수
     * @param fileDTO
     * @return
     */
    @Override
    public int searchFileListCnt(FileDTO fileDTO) {
        return fileMapper.selectFileListCnt(fileDTO);
    }
}
