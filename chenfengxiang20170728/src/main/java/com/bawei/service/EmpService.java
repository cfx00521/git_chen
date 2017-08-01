/**
 * 
 */
package com.bawei.service;

import java.util.List;

import com.bawei.pojo.Dept;
import com.bawei.pojo.Employee;

/**
 * @author 陈凤祥
 * @date 2017-07-28
 * 
 * service 接口   
 * */
public interface EmpService {
	List<Dept> depts();
	
	void add(Employee employee);
	
	Employee reg(Employee employee);
	
	String isExits(Employee employee);
	
	List<Employee> getall(Integer id);
}

