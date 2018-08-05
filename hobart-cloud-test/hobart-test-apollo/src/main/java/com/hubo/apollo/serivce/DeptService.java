package com.hubo.apollo.serivce;

import java.util.List;

import com.hubo.apollo.model.Dept;

public interface DeptService {
	boolean add(Dept dept);

	Dept get(Long id);

	List<Dept> list();
}
