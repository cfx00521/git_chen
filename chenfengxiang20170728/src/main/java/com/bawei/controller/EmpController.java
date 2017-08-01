package com.bawei.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.pojo.Dept;
import com.bawei.pojo.Employee;
import com.bawei.service.EmpService;
/**
 * @author 陈凤祥
 * @date 2017-07-28
 * 
 * 控制类   和页面交互
 * */
@Controller
@RequestMapping("emp")
public class EmpController {
	@Autowired
	private EmpService service;
	//得到全部部门
	@RequestMapping("depts")
	public String depts(HttpServletRequest request) {
		List<Dept> list = service.depts();
		request.setAttribute("list", list);
		return "index";
	}
	//添加
	@RequestMapping("add")
	public String add(Employee employee,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date sta,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		employee.setStarttime(sta);
		employee.setEndtime(end);
		System.out.println("--------------------------");
		service.add(employee);
		return "reg";
	}
	
	
	//是否存在
	@RequestMapping("isExits")
	@ResponseBody
	public String isExits(String name) {
		Employee employee = new Employee();
		employee.setEname(name);
		String s = service.isExits(employee);
		return s;
	}
	
	//登录
	@RequestMapping("reg")
	public String reg(Employee employee, HttpServletRequest request) {
		Employee reg = service.reg(employee);
		HttpSession session = request.getSession();
		session.setAttribute("reg", reg);
		if (reg != null && reg.getPassword().equals(employee.getPassword())) {
			request.setAttribute("msg", "你好   " + employee.getEname());
			return "forward:getall";
		} else {
			request.setAttribute("msg", "登录失败，请检查登录信息");
			return "reg";
		}
	}
	
	//得到全部
	@RequestMapping("getall")
	public String getall(@RequestParam(value="id",defaultValue="0") Integer id, HttpServletRequest request) {		
		List<Employee> list = service.getall(id);
		request.setAttribute("list", list);
		return "list";
	}
}
