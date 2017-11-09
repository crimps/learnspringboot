package com.crimps.learnspringboot.service.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author crimps
 * @create 2017-11-09 15:19
 **/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {
}
