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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
<<<<<<< HEAD
import java.io.OutputStream;
import java.util.Calendar;
=======
import java.util.*;
>>>>>>> b87b8e39f4d6845c11f69b5176d361531ae8cbce

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
        fileDTO.setFilePath("C:\\file\\" + storedName.toString());
        fileDTO.setMemId(memId);
        fileDTO.setFileType(inputFile.getContentType());
        fileDTO.setFileDesc("bb");

        fileService.uploadFile(inputFile, fileDTO);

        logger.info("========== FileController.upload End ==========");

        return new ResultDTO();
    }

    @RequestMapping(value = "/{fileNo}", method = RequestMethod.PUT)
    public ResultDTO modify(@RequestBody FileDTO fileDTO, @PathVariable final int fileNo) throws Exception{

        logger.info("========== FileController.modify Start ==========");

        fileDTO.setFileNo(fileNo);
        fileService.modifyFile(fileDTO);

        logger.info("========== FileController.modify End ==========");

        return new ResultDTO();
    }

    @RequestMapping(value = "/{fileNo}", method = RequestMethod.GET)
    public ResultDTO downLoad(@PathVariable final int fileNo, HttpServletResponse response) {

        logger.info("========== FileController.downLoad Start ==========");

        // 해당 파일 정보 가져오기
        FileDTO fileDTO = fileService.getFile(fileNo);

        File file = new File(fileDTO.getFilePath());

        String fileName = fileDTO.getOriginName();
        String fileType = fileDTO.getFileType();
        long fileLength = file.length();

        response.setHeader("Content-Disposition", "attachement; fileName=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", fileType);
        response.setHeader("Content-Length", "" + fileLength);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        try (FileInputStream fis = new FileInputStream(fileDTO.getFilePath()); OutputStream out = response.getOutputStream();) {
            int readCount = 0;
            byte[] buffer = new byte[1024];

            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            throw new RuntimeException("file Load Error");
        }

        logger.info("========== FileController.downLoad Start ==========");

        return new ResultDTO();
    }

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

}
