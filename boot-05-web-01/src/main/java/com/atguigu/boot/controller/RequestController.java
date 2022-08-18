package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
@Controller
public class RequestController {
    @RequestMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("msg","chenggong");
        request.setAttribute("code",200);
        System.out.println("执行到了这里");
        return "forward:/success";//转发到success请求
    }
    @ResponseBody
    @GetMapping("/success")
    public String success( @RequestAttribute("msg") String msg,
                           @RequestAttribute("code")Integer code,
                           HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("code",code);
        map.put("request",request.getAttribute("msg"));
        return null;
    }
}
