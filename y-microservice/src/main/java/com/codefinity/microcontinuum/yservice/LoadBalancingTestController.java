package com.codefinity.microcontinuum.yservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LoadBalancingTestController {

	@Autowired
	Environment environment;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User user(@PathVariable String id) {

		String port = environment.getProperty("local.server.port");

		System.out.println("Load Bancing Controller Message received At Port: " + port);

		User user = new User();
		user.setName("User");
		user.setAge(25);
		user.setMobileNo("2567890");
		user.setAddress("Address");
		user.setActive(true);

		return user;

	}
}
