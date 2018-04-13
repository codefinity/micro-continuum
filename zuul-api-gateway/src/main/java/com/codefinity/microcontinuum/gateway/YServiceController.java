package com.codefinity.microcontinuum.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YServiceController {

	@Autowired
	YServiceComponent yServiceComponent;

	@RequestMapping(value = "/y-service/user/{id}", method = RequestMethod.GET)
	String getHub(@PathVariable("id") Long id) {
		// logger.info(" [Hystrix enabled] Search Request in API gateway for getting
		// Hub, forwarding to search-service - ");
		System.out.println("Through Hystrix");
		return yServiceComponent.getUser(id);
	}

}
