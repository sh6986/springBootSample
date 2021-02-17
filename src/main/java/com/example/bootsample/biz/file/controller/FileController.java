package com.example.bootsample.biz.file.controller;

import com.example.bootsample.biz.file.model.FileDTO;
import com.example.bootsample.biz.file.service.IFileService;
import com.example.bootsample.biz.member.model.MemberDTO;
import com.example.bootsample.common.model.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    IFileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultDTO upload(@RequestParam("file") MultipartFile inputFile, HttpServletRequest request) throws IOException {

        logger.info("========== FileController.upload Start ==========");

        FileDTO fileDTO = new FileDTO();
        String originName = inputFile.getOriginalFilename();
        String extName = originName.substring(originName.lastIndexOf("."), originName.length());

        // 현재 시간을 기준으로 서버에 저장할 파일이름 생성
        StringBuffer storedName = new StringBuffer();
        Calendar cal = Calendar.getInstance();
        storedName.append(cal.get(Calendar.YEAR))
                  .append(cal.get(Calendar.MONTH))
                  .append(cal.get(Calendar.DATE))
                  .append(cal.get(Calendar.HOUR))
                  .append(cal.get(Calendar.MINUTE))
                  .append(cal.get(Calendar.SECOND))
                  .append(cal.get(Calendar.MILLISECOND))
                  .append(extName);

        // 세션저장된 id 가져오기
        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberInfo");
        String memId = memberDTO.getMemId();

        fileDTO.setOriginName(inputFile.getOriginalFilename());
        fileDTO.setStoredName(storedName.toString());
        fileDTO.setFileSize(inputFile.getSize());
        fileDTO.setFilePath("C:\\file\\");
        fileDTO.setMemId(memId);
        fileDTO.setFileType("aa");
        fileDTO.setFileDesc("bb");

        fileService.uploadFile(inputFile, fileDTO);

        logger.info("========== FileController.upload End ==========");

        return new ResultDTO();
    }

    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public ResultDTO modify(@RequestBody FileDTO fileDTO) throws Exception{

        logger.info("========== FileController.modify Start ==========");

        fileService.modifyFile(fileDTO);

        logger.info("========== FileController.modify End ==========");

        return new ResultDTO();
    }

}
