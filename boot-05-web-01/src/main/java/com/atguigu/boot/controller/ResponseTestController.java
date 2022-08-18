package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {



    /*
    1.浏览器发请求直接返回xml        【application/xml】     jacksonXmlConverter
    2.如果是ajax请求返回json           【application/json】  jacksonXmlConverter
    如果是硅谷app发请求，返回自定义协议数据  [application/x-guigu]    xxxxConverter
     步骤：
     1添加自定义的messageConverter进系统底层
     2.系统底层就会统计出所有的MessageConverter能操作那些类型
     3.客户端内容协商  [guigu--->guigu]

     */
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setUsername("张撒谎");
        person.setAge(18);
        person.setDate(new Date());
        return person;
    }
}
