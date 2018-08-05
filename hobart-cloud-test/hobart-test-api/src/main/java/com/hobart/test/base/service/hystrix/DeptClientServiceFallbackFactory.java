package com.hobart.test.base.service.hystrix;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hobart.test.base.model.Dept;
import com.hobart.test.base.service.DeptClientService;

import feign.hystrix.FallbackFactory;

/**
 * 处理服务降级
 * @author hobart
 *
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new DeptClientService(){

			@Override
			public Dept get(Long id) {
				// TODO Auto-generated method stub
				return new Dept().setDept_no(id)
						.setDept_name("该ID:"+id+"没有对应的信息,Consumer客户端提供的降级信息,此刻Provider提供服务已经关闭")
						.setDb_source("no this database in MYSQL");
			}

			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
	}

}
