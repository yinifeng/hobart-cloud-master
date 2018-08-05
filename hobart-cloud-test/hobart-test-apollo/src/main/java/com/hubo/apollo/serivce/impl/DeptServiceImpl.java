package com.hubo.apollo.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubo.apollo.dao.DeptDao;
import com.hubo.apollo.model.Dept;
import com.hubo.apollo.serivce.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;

	@Override
	public boolean add(Dept dept) {
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptDao.findAll();
	}

}
