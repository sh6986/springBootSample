package com.example.bootsample.view.common.controller;

import com.example.bootsample.biz.file.controller.FileController;
import com.example.bootsample.biz.file.model.FileDTO;
import com.example.bootsample.biz.file.service.IFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping(value = "/view/file")
public class VFileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    IFileService fileService;

    @RequestMapping(value = "/list")
    public String fileList() {
        return "file/fileList";
    }

    /**
     * 파일 다운로드
     * @param fileNo
     * @return
     */
    @RequestMapping(value = "/{fileNo}", method = RequestMethod.GET)
    public void downLoad(@PathVariable final int fileNo, HttpServletResponse response) throws IOException {

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

    }

}
