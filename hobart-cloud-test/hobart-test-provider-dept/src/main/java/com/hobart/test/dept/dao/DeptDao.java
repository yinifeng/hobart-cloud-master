package com.hobart.test.dept.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hobart.test.base.model.Dept;

@Mapper
public interface DeptDao {
	boolean addDept(Dept dept);

	Dept findById(Long id);

	List<Dept> findAll();
}
