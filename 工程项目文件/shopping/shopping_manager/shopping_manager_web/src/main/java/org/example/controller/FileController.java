package org.example.controller;

import org.example.fastdfs.FastDFSClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {
    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam MultipartFile uploadFile) throws IOException {
        String fileId = FastDFSClient.uploadFile(uploadFile.getInputStream(), uploadFile.getOriginalFilename());
        if(fileId!=null){
            System.out.println("上传文件成功");
        }

        return fileId;
    }

}
