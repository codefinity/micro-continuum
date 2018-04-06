package com.codefinity.microcontinuum.chat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PropertiesTestController {

	@Value("${x-microservice.config-test-value}")
	private String testProperty;
	
	@RequestMapping(value = "/testproperty")
	public String greeting( ) {

		return testProperty;
	}
}
