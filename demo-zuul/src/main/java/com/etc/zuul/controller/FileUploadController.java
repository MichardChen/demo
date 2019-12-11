package com.etc.zuul.controller;

import com.etc.component.jwt.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
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
     * 文件上传类
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

    @Login
    @ResponseBody
    @GetMapping("/test")
    public String index(){
        return "test zuul";
    }
}
