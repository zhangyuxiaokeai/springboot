package com.atguigu.boot.service.impl;

import com.atguigu.boot.mapper.EmployeeMapper;
import com.atguigu.boot.pojo.Employee;
import com.atguigu.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public Employee getEmployeeByid(Integer id) {
       return employeeMapper.getEmployeeByID(id);
    }
}
