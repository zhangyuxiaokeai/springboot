package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@Slf4j
@RestController
public class HelloController {
    @Autowired
  private  Car car;


@RequestMapping("/car")
public Car car(){
    return car;
}
@RequestMapping("/hello")
    public String handle(@RequestParam("name")String name){
    log.info("请求进来啦");
        return "Hello ,Spring Boot2";
    }
}
