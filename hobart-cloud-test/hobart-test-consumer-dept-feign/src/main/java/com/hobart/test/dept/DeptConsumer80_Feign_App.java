package com.hobart.test.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 如果要针对某个微服务采用某种特定的负载均衡算法：
 * 	1、首先加入注解@@RibbonClient(name="微服务名",configuration =xxx.class)
 * 	2、注意configuration的类不能和当前应用@ComponentScan扫描在同一包下,
 * 	      否则所有都会采用这个算法
 * 
 * @author hobart
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.hobart.test"})
@ComponentScan("com.hobart.test")
public class DeptConsumer80_Feign_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}
