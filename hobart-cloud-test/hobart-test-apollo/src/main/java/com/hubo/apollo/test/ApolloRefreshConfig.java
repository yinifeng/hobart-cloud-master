package com.hubo.apollo.test;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * To refresh the config bean when config is changed
 *
 * @author Jason Song(song_s@ctrip.com)
 */
@Component
public class ApolloRefreshConfig {

  @Autowired
  private RefreshScope refreshScope;

  @Autowired
  private AnnotatedBean annotatedBean;

  @ApolloConfigChangeListener({"application"})
  private void onChange(ConfigChangeEvent changeEvent) {
//    if (changeEvent.isChanged("timeout") || changeEvent.isChanged("batch")) {
//      System.out.println("before refresh "+annotatedBean.toString());
//      //could also call refreshScope.refreshAll();
//      refreshScope.refresh("annotatedBean");
//      System.out.println("after refresh "+annotatedBean.toString());
//    }
    
    System.out.println("before refresh "+annotatedBean.toString());
    //could also call refreshScope.refreshAll();
    refreshScope.refresh("annotatedBean");
    System.out.println("after refresh "+annotatedBean.toString());
  }
}
