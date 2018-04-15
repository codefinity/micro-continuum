package com.codefinity.microcontinuum.user.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {
	
	private static final Logger logger = LoggerFactory.getLogger(KeyController.class);
	
	@RequestMapping(value = "/key")
	public String testService() {

		return "key";
	}
}