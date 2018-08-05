package com.hobart.test.base.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor // 空参构造函数
@Data
@Accessors(chain = true) // 链式调用
public class Dept implements Serializable {

	private static final long serialVersionUID = -8410480177962376850L;

	private Long dept_no;

	private String dept_name;

	private String db_source;

	public Dept(String dept_name) {
		this.dept_name = dept_name;
	}
}
