package com.bawei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bawei.mapper.DeptMapper;
import com.bawei.pojo.Dept;
import com.bawei.service.DeptService;

@Transactional
@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptMapper mapper;
	
	@Override
	public List<Dept> getdept() {
		// TODO Auto-generated method stub
		return mapper.getdept();
	}

}
