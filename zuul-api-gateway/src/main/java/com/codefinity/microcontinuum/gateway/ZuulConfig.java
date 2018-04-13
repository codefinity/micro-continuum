package com.codefinity.microcontinuum.gateway;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ZuulConfig {

	@Bean
	public CustomZuulFilter customFilter() {
		return new CustomZuulFilter();
	}
	
	@Bean
	public YSericeFallbackProvider ySericeFallbackProvide() {
		return new YSericeFallbackProvider();
	}
	
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
      return new RestTemplate();
    }	
}
