package com.codefinity.microcontinuum.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

	@Bean
	public CustomZuulFilter customFilter() {
		return new CustomZuulFilter();
	}
	
	@Bean
	public XSericeFallbackProvider xSericeFallbackProvide() {
		return new XSericeFallbackProvider();
	}
	
}
