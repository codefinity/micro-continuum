package com.codefinity.microcontinuum.yservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codefinity.microcontinuum.yservice.remotecalls.ZService;

@RestController
@RefreshScope
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	Environment environment;

	@Autowired
	private ZService zService;
	
	@RequestMapping(value = "/hello")
	public String testService() {

		return "Y-MicroService Working";
	}

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

	@RequestMapping(value = "/sleuthtest/{message}")
	public String sleuthTest(@PathVariable("message") String message) {

		logger.info("Sleuth Message at Y-Microservice");

		return zService.sleuthTest(message);
	}
}
