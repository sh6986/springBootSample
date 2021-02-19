package com.example.bootsample.biz.file.controller;

import com.example.bootsample.biz.file.model.FileDTO;
import com.example.bootsample.biz.file.service.IFileService;
import com.example.bootsample.biz.member.model.MemberDTO;
import com.example.bootsample.common.model.ResultDTO;
import com.example.bootsample.common.util.BootSampleUtills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    IFileService fileService;

    /**
     * 파일 업로드
     * @param inputFile, fileDesc
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultDTO upload(@RequestParam("file") MultipartFile inputFile, @RequestParam("fileDesc") String fileDesc, HttpServletRequest request) throws IOException {

        logger.info("========== FileController.upload Start ==========");

        FileDTO fileDTO = new FileDTO();

        // 세션저장된 id 가져오기
        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberInfo");
        String memId = memberDTO.getMemId();

        fileDTO.setMemId(memId);

        fileService.uploadFile(inputFile, fileDTO, fileDesc);

        logger.info("========== FileController.upload End ==========");

        return new ResultDTO();
    }

    /**
     * 파일 수정
     * @param fileDTO, fileNo
     * @return
     */
    @RequestMapping(value = "/{fileNo}", method = RequestMethod.PUT)
    public ResultDTO modify(@RequestBody FileDTO fileDTO, @PathVariable final int fileNo) throws Exception{

        logger.info("========== FileController.modify Start ==========");

        fileDTO.setFileNo(fileNo);
        fileService.modifyFile(fileDTO);

        logger.info("========== FileController.modify End ==========");

        return new ResultDTO();
    }

    /**
     * 파일 리스트
     * @param fileDTO
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultDTO searchFileList(FileDTO fileDTO) throws Exception{

        ResultDTO res = new ResultDTO();
        BootSampleUtills.pageInit(fileDTO);

        Map<String,Object> data = new HashMap<>();
        int cnt = fileService.searchFileListCnt(fileDTO);

        data.put("cnt",cnt);
        data.put("list",cnt == 0 ? new ArrayList<>() : fileService.searchFileList(fileDTO) );
        res.setData(data);

        return res;
    }

    /**
     * 파일 단건 조회
     * @param fileNo
     * @return
     */
    @RequestMapping(value = "/{fileNo}", method = RequestMethod.GET)
    public ResultDTO searchFileList(@PathVariable final int fileNo) throws Exception{

        ResultDTO res = new ResultDTO();
        FileDTO fileDTO = fileService.getFile(fileNo);
        res.setData(fileDTO);

        return res;
    }

}
