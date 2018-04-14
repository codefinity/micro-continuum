package com.codefinity.microcontinuum.template;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

	@Value("${template-microservice.config-test-value}")
	private String testProperty;
	
	@RequestMapping(value = "/hello")
	public String testService() {

		return "Test-MicroService Working";
	}
	
	@RequestMapping(value = "/testproperty")
	public String greeting( ) {

		return testProperty;
	}
}
