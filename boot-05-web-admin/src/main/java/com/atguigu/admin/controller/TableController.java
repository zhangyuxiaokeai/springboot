package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_teble(){
        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //表格内容动态遍历
        List<User> users = Arrays.asList(new User("张三", "123456"), new User("周欢", "123456"),
                new User("sad", "123456"),
                new User("asdasda", "123456"),
                new User("张sss三", "123456"),
                new User("sadasd", "123456"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){
        int a=10/0;
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
