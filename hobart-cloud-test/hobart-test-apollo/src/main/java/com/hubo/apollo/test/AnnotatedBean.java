package com.hubo.apollo.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@RefreshScope
@Component("annotatedBean")
public class AnnotatedBean {

  @Value("${timeout:200}")
  private int timeout;
  private int batch;

  @PostConstruct
  void initialize() {
    System.out.println("timeout is initialized as "+timeout);
    System.out.println("batch is initialized as "+batch);
  }

  @Value("${batch:100}")
  public void setBatch(int batch) {
    this.batch = batch;
  }


  @Override
  public String toString() {
    return String.format("[AnnotatedBean] timeout: %d, batch: %d", timeout, batch);
  }
}
