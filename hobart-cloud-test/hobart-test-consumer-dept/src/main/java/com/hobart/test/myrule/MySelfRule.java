package com.hobart.test.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {
	
	/**
	 * Ribbon是客户端负载均衡，故可以在客户端切换负载均衡算法
	 * Ribbon的负载均衡算法有多种，可以查询相关资料
	 * 默认的是采用轮询算法
	 * 
	 */
	@Bean
	public IRule myRule(){
		//return new RoundRobinRule();	//轮询算法，但是如果某个服务挂了，还是会参与轮询
		//return new RandomRule();	//随机算法
		//return new RetryRule();		//采用的是轮询算法，但是如果某个服务挂了，一定时间后不参与轮询
		return new RandomRule_HB();
		
	}
}
