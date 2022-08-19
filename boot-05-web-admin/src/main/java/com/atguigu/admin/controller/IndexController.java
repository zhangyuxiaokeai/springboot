package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
@GetMapping(value = {"/","/login"})
public String loginPaege(){
        /*
        访问登录页
         */
return "login";
}
@PostMapping("/login")
public String main(User user, HttpSession session, Model model){
    System.out.println(user.getUserName()+"  "+user.getPassword());
    if(!(StringUtils.isEmpty(user.getUserName())&&StringUtils.isEmpty(user.getPassword())))
    { //登录成功重定向到main页面
        //防止表单重复提交
        session.setAttribute("loginUser",user);
        return "redirect:/index.html";
    }else {
        model.addAttribute("msg","这个号密码错误");
        //回到登录页
        return "login";
    }


}

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/index.html")
public  String mainPage(HttpSession session,Model model){
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser!=null){
//            return "index";
//        }
//        model.addAttribute("msg","请重新登录");

        return "index";
}
}
