package com.atguigu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {
    @RequestMapping("/world")
    public String worldTest(){
        return "hello,world";
    }
}
