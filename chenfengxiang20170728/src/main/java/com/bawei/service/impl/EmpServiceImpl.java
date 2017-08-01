package com.bawei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bawei.mapper.EmpMapper;
import com.bawei.pojo.Dept;
import com.bawei.pojo.Employee;
import com.bawei.service.EmpService;
/**
 * @author 陈凤祥
 * @date 2017-07-28
 * 
 * 业务逻辑   实现操作
 * */
@Transactional
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper mapper;

	@Override
	public List<Dept> depts() {
		// TODO 自动生成的方法存根
		return mapper.depts();
	}

	@Override
	public void add(Employee employee) {
		mapper.add(employee);

	}

	@Override
	public Employee reg(Employee employee) {
		// TODO 自动生成的方法存根
		return mapper.reg(employee);
	}

	@Override
	public String isExits(Employee employee) {
		// TODO 自动生成的方法存根
		Employee e = mapper.reg(employee);
		if (e != null) {
			return String.valueOf(e.getD_id());
		}
		return "ok";

	}

	@Override
	public List<Employee> getall(Integer id) {
		// TODO 自动生成的方法存根
		return mapper.getall(id);
	}

}
