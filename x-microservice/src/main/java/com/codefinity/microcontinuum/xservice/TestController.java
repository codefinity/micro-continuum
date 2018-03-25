package com.codefinity.microcontinuum.xservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefinity.microcontinuum.xservice.remotecalls.YService;
import com.codefinity.microcontinuum.xservice.remotecalls.dto.User;

@RestController
@RefreshScope
public class TestController {

	@Value("${x-microservice.config-test-value}")
	private String testProperty;
	
	@Autowired
	private YService yService;
	
	@RequestMapping(value = "/testproperty")
	public String testProperty( ) {

		return testProperty;
	}
	
	@RequestMapping(value = "/testloadbalancing/{id}")
	public User testLoadBalancing(@PathVariable("id") Long id ) {

		return yService.getUser(id);
	}
}
