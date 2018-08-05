package com.hubo.apollo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

@Component
public class DataSourceRefres {
	@Autowired
	private RefreshScope refreshScope;
	@Autowired
	private DataSourceConfig dsc;
	
    @ApolloConfigChangeListener
	public void onChange(ConfigChangeEvent changeEvent) {
			System.out.println("befor========" + dsc.toString());
			refreshScope.refresh("dataSourceConfig");
			refreshScope.refresh("dataSource");
			System.out.println("after========" + dsc.toString());
	}
}
