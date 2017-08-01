package com.bawei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bawei.pojo.Dept;
import com.bawei.pojo.Employee;
/**
 * @author 陈凤祥
 * @date 2017-07-28
 * 
 * dao层接口类
 * */
public interface EmpMapper {
	List<Dept> depts();
	
	void add(Employee employee);
	
	Employee reg(Employee employee);
	
	List<Employee> getall(@Param("id")Integer id);
	
}
