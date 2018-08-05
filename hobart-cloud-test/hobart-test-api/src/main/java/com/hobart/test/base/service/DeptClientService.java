package com.hobart.test.base.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hobart.test.base.model.Dept;
import com.hobart.test.base.service.hystrix.DeptClientServiceFallbackFactory;

//@FeignClient("HOBART-TEST-DEPT")
//服务降级回调
@FeignClient(value="HOBART-TEST-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list();
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept);
}
