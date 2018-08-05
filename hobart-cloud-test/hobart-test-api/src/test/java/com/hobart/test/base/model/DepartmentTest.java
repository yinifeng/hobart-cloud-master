package com.hobart.test.base.model;

import org.junit.Test;

public class DepartmentTest {

	@Test
	public void test() {
		// lombok 通过注解可以省略get、set方法
		Department dept = new Department();
		dept.setDeptName("财务部").setDeptNo(1L).setDbSource("DB01");
		System.out.println(dept.getDeptName());
		System.out.println(dept.toString());
	}

}
