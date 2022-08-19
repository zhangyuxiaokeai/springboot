package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 *文件上传
 */
@Controller
@Slf4j
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        System.out.println("执行这里 ");
    return "form/form_layouts";

    }

    /**
     * MultipartFile 自动封装上传的文件
     * @param email
     * @param userName
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userName")String userName,
                         @RequestParam("headerImg") MultipartFile headerImg,
                         @RequestParam("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email="+email+"username:"+userName+"headerImg :"+headerImg.getSize()+"photos :"+photos.length );
       if(!headerImg.isEmpty()){
           //保存到服务器
           String originalFilename = headerImg.getOriginalFilename();
           headerImg.transferTo(new File("D:\\"+originalFilename));
       }
        if(photos.length>0){
            for (int i = 0; i < photos.length; i++) {
                if(!photos[i].isEmpty()){
                    String originalFilename = photos[i].getOriginalFilename();
                    photos[i].transferTo(new File("D:\\test\\"+originalFilename));
                }
            }
        }
        return "index";
    }
}
