package com.hubo.apollo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "mysql")
@Component("dataSourceConfig")
@RefreshScope
public class DataSourceConfig implements InitializingBean{
	//@Value("${url}")
	private String url;
	//@Value("${driverClassName}")
	private String driverClassName;
	//@Value("${username}")
	private String username;
	//@Value("${password}")
	private String password;
	//@Value("${initialSize}")
	private String initialSize;
	//@Value("${minIdle}")
	private String minIdle;
	//@Value("${maxWait}")
	private String maxWait;
	//@Value("${maxActive}")
	private String maxActive;
	//@Value("${minEvictableIdleTimeMillis}")
	private String minEvictableIdleTimeMillis;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}

	public String getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}

	public String getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}

	public String getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}

	public String getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init========>"+toString());
		
	}

	@Override
	public String toString() {
		return "DataSourceConfig [url=" + url + ", driverClassName=" + driverClassName + ", username=" + username
				+ ", password=" + password + ", initialSize=" + initialSize + ", minIdle=" + minIdle + ", maxWait="
				+ maxWait + ", maxActive=" + maxActive + ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis
				+ "]";
	}
	
	
	
	
}
