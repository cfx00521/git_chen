package com.bawei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bawei.pojo.Dept;
import com.bawei.pojo.Emp;
import com.bawei.service.DeptService;

@Controller
@RequestMapping("dept")
public class UserController {
	@Autowired
	private DeptService service;
	
	@RequestMapping("getDe")
	public ModelAndView getDe(ModelAndView modelAndView){
		List<Dept> list = service.getdept();
		modelAndView.addObject("list", list);
		for (Dept dept : list) {
			List<Emp> list2 = dept.getEmps();
			for (Emp emp : list2) {
				System.out.println(emp.getEname());
			}
		}
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
}
