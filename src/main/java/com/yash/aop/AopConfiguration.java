package com.yash.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfiguration {

	@Bean
	public LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}

}
