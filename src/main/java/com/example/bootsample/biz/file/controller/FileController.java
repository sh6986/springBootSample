package com.example.bootsample.biz.file.controller;

import com.example.bootsample.biz.file.model.FileDTO;
import com.example.bootsample.biz.file.service.IFileService;
import com.example.bootsample.biz.member.model.MemberDTO;
import com.example.bootsample.common.model.ResultDTO;
import com.example.bootsample.common.util.BootSampleUtills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<ResultDTO> upload(@RequestParam("file") MultipartFile inputFile, @RequestParam("fileDesc") String fileDesc, HttpServletRequest request) throws IOException {

        logger.info("========== FileController.upload Start ==========");

        FileDTO fileDTO = new FileDTO();

        // 세션저장된 id 가져오기
        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberInfo");
        String memId = memberDTO.getMemId();

        fileDTO.setMemId(memId);

        fileService.uploadFile(inputFile, fileDTO, fileDesc);

        logger.info("========== FileController.upload End ==========");

        return new ResponseEntity<ResultDTO>(new ResultDTO(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{fileNo}", method = RequestMethod.PUT)
    public ResponseEntity<ResultDTO> modify(@RequestBody FileDTO fileDTO, @PathVariable final int fileNo) throws Exception{

        logger.info("========== FileController.modify Start ==========");

        fileDTO.setFileNo(fileNo);
        fileService.modifyFile(fileDTO);

        logger.info("========== FileController.modify End ==========");

        return new ResponseEntity<ResultDTO>(new ResultDTO(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{fileNo}", method = RequestMethod.GET)
    public ResponseEntity<ResultDTO> downLoad(@PathVariable final int fileNo, HttpServletResponse response) {

        logger.info("========== FileController.downLoad Start ==========");

        logger.info("========== FileController.downLoad Start ==========");

        return new ResponseEntity<ResultDTO>(new ResultDTO(), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<ResultDTO> searchFileList(FileDTO fileDTO) throws Exception{

        ResultDTO res = new ResultDTO();
        BootSampleUtills.pageInit(fileDTO);

        Map<String,Object> data = new HashMap<>();
        int cnt = fileService.searchFileListCnt(fileDTO);

        data.put("cnt",cnt);
        data.put("list",cnt == 0 ? new ArrayList<>() : fileService.searchFileList(fileDTO) );
        res.setData(data);

        return new ResponseEntity<ResultDTO>(new ResultDTO(), HttpStatus.OK);
    }

}
