package com.hobart.test.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 服务监控
 * 
 * 被监控的服务必须依赖监控
 * <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
	
	监控页面
	http://localhost:9001/hystrix
	监控8001
	http://localhost:8001/hystrix.stream
 * 
 * @author hobart
 *
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_DashBoard_9001_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer_DashBoard_9001_App.class, args);
	}
}
