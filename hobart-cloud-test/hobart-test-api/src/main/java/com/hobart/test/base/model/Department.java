package com.hobart.test.base.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 微服务序列化
 * @author hobart
 * lombok 通过注解可以省略get、set方法
 */

//@AllArgsConstructor //全参构造函数
@NoArgsConstructor //空参构造函数
@Data
@Accessors(chain=true) //链式调用
public class Department implements Serializable{
	private static final long serialVersionUID = -6203312810627690914L;
	
	private Long deptNo;
	
	private String deptName;
	/** 数据库来源 */
	private String dbSource;
	
	public Department(String dbSource){
		this.dbSource=dbSource;
	}
}
