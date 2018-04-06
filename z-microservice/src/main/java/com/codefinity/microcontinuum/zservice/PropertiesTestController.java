package com.codefinity.microcontinuum.zservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PropertiesTestController {

	@Value("${z-microservice.config-test-value}")
	private String testProperty;
	
	@RequestMapping(value = "/testproperty")
	public String greeting( ) {

		return testProperty;
	}
	
	@RequestMapping(value = "/sleuthtest/{message}")
	public String sleuthTest(@PathVariable("message") String message ) {

		return "sleuthTest";
	}
	
}
