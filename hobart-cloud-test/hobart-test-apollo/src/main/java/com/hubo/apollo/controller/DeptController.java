package com.hubo.apollo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.hubo.apollo.model.Dept;
import com.hubo.apollo.serivce.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	private String testSwitch;
	@Autowired
	private RefreshScope refreshScope;
	@ApolloConfig("application")
	private Config config;
	
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
		System.out.println("---->"+testSwitch);
		System.out.println("testSwitch====>"+config.getProperty("testSwitch", "没取到"));
		System.out.println("timeout====>"+config.getProperty("timeout", "没取到"));
		return deptService.list();
	}
	
	@org.springframework.cloud.context.config.annotation.RefreshScope
	@Value("${testSwitch:2}")
	public void setTestSwitch(String testSwitch) {
		this.testSwitch = testSwitch;
	}
	
    @ApolloConfigChangeListener
	public void onChange(ConfigChangeEvent changeEvent) {
			System.out.println("befor========" + testSwitch);
			//refreshScope.refresh("testSwitch");
			System.out.println(config.getPropertyNames());;
			setTestSwitch(config.getProperty("testSwitch", "没取到"));
			System.out.println("after========" + testSwitch);
	}
	
}
