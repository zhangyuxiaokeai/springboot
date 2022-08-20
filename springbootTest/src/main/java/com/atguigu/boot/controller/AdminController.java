package com.atguigu.boot.controller;

import com.atguigu.boot.pojo.Employee;
import com.atguigu.boot.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
    @Autowired
    EmployeeServiceImpl employeeService;
    @ResponseBody
    @GetMapping ("/update/{id}")
    public Employee querEmployee(@PathVariable("id")Integer id){
        System.out.println(id);
        Employee employeeByid = employeeService.getEmployeeByid(id);
        System.out.println(employeeByid.toString());
        return employeeByid;
    }
}
