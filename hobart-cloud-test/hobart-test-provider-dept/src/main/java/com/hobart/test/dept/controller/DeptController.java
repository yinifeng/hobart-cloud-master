package com.hobart.test.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hobart.test.base.model.Dept;
import com.hobart.test.dept.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept){
		return deptService.add(dept);
	}
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id){
		return deptService.get(id);
	}
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list(){
		return deptService.list();
	}
	
	@Autowired
	private DiscoveryClient client;
	
	/**
	 * 提供rest访问服务发现
	 * @return
	 */
	@RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
	public Object listDiscovery(){
		//获取所有服务列表的集合
		List<String> services = client.getServices();
		System.out.println("================>"+services);
		//获取某个注册服务的注册列表
		List<ServiceInstance> instances = client.getInstances("HOBART-TEST-DEPT");
		instances.forEach(e -> {
			System.out.println(e.getServiceId() + "\t" + e.getHost() + "\t" + e.getPort() + "\t" + e.getUri());
		});
		return client;
	}
}
