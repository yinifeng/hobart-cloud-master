package com.hubo.apollo.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

@Configuration
public class DruidConfiguration {
	@Autowired
	private RefreshScope refreshScope;
	@Autowired
	private DataSourceConfig dataSourceConfig;
	
    @Bean
    @org.springframework.cloud.context.config.annotation.RefreshScope
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();  
        datasource.setUrl(dataSourceConfig.getUrl());  
        datasource.setDriverClassName(dataSourceConfig.getDriverClassName());  
        datasource.setUsername(dataSourceConfig.getUsername());  
        datasource.setPassword(dataSourceConfig.getPassword());  
        datasource.setInitialSize(Integer.valueOf(dataSourceConfig.getInitialSize()));  
        datasource.setMinIdle(Integer.valueOf(dataSourceConfig.getMinIdle()));  
        datasource.setMaxWait(Long.valueOf(dataSourceConfig.getMaxWait()));  
        datasource.setMaxActive(Integer.valueOf(dataSourceConfig.getMaxActive()));  
        datasource.setMinEvictableIdleTimeMillis(
        		Long.valueOf(dataSourceConfig.getMinEvictableIdleTimeMillis())); 
        try {  
            datasource.setFilters("stat,wall");  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return datasource;  
    } 
    
    @Bean  
    public FilterRegistrationBean filterRegistrationBean() {  
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();  
        filterRegistrationBean.setFilter(new WebStatFilter());  
        filterRegistrationBean.addUrlPatterns("/*");  
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");  
        return filterRegistrationBean;  
    }  
  
    // 按照BeanId来拦截配置 用来bean的监控  
    @Bean(value = "druid-stat-interceptor")  
    public DruidStatInterceptor DruidStatInterceptor() {  
        DruidStatInterceptor druidStatInterceptor = new DruidStatInterceptor();  
        return druidStatInterceptor;  
    }  
  
    @Bean  
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {  
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();  
        beanNameAutoProxyCreator.setProxyTargetClass(true);  
        // 设置要监控的bean的id  
        //beanNameAutoProxyCreator.setBeanNames("sysRoleMapper","loginController");  
        beanNameAutoProxyCreator.setInterceptorNames("druid-stat-interceptor");  
        return beanNameAutoProxyCreator;  
    }
    
    @ApolloConfigChangeListener({"application"})
	public void onChange(ConfigChangeEvent changeEvent) {
			System.out.println("befor========" + dataSourceConfig.toString());
			refreshScope.refresh("dataSourceConfig");
			System.out.println("after========" + dataSourceConfig.toString());
	}
}
