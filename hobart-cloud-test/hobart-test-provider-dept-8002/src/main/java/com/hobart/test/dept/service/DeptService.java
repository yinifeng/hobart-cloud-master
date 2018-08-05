package com.hobart.test.dept.service;

import java.util.List;

import com.hobart.test.base.model.Dept;

public interface DeptService {
	boolean add(Dept dept);

	Dept get(Long id);

	List<Dept> list();
}
