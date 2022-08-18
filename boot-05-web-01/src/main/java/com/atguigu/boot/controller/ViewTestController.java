package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTestController {
    @RequestMapping("/atguigu")
    public String atguigu(Model model){
        model.addAttribute("msg","safsfsad");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
