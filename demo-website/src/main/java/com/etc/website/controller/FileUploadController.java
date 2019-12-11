package com.etc.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传控制器
 * @author ChenDang
 * @date 2019/12/4 0004
 */
@Controller
public class FileUploadController {

    /**
     * 普通文件上传方法(使用zuul转发到上传页面http://localhost:8082/webreq/web/file，然后上传文件。
     * 在调试模式下，设置断点是不会停在断点。要调试需要直接访问该网页http://localhost:8080/web/file,不要转发)
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam(value = "file",required = true)MultipartFile file) throws IOException {

        //获取文件字节流
        byte[] bytes = file.getBytes();
        File saveFile = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes,saveFile);
        return saveFile.getAbsolutePath();
    }
}
