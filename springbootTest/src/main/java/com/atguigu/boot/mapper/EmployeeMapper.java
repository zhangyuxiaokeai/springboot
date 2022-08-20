package com.atguigu.boot.mapper;

import com.atguigu.boot.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    public Employee getEmployeeByID(Integer id);
}
