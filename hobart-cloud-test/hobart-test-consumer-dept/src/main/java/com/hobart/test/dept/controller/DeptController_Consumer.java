package com.hobart.test.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hobart.test.base.model.Dept;

@RestController
//@RequestMapping("/consumer")
public class DeptController_Consumer {
	
	//private static final String REST_URL_PREFIX="http://localhost:8001";
	//注册中心的服务名
	private static final String REST_URL_PREFIX="http://HOBART-TEST-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add",method=RequestMethod.GET)
	public boolean add(Dept dept){
		System.out.println(dept);
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list",method=RequestMethod.GET)
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
	
	/**
	 * 提供rest访问服务发现
	 * @return
	 */
	@RequestMapping(value="/consumer/dept/discovery",method=RequestMethod.GET)
	public Object listDiscovery(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
}
