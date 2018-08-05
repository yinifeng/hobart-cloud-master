package com.hubo.apollo.config;

import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Configuration
@EnableApolloConfig(value = "application", order = 10)
public class AppConfig {
}
