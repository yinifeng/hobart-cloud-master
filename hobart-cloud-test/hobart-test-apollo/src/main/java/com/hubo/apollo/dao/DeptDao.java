package com.hubo.apollo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hubo.apollo.model.Dept;

@Mapper
public interface DeptDao {
	boolean addDept(Dept dept);

	Dept findById(Long id);

	List<Dept> findAll();
}
