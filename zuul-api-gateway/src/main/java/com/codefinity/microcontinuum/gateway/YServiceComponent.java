package com.codefinity.microcontinuum.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class YServiceComponent {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getDefaultHub")
	public String getUser(@PathVariable("id") Long id) {
		
		System.out.println("Calling through Hystrix Command");
		
		String hub = restTemplate.getForObject("http://y-microservice/user/" + "id", String.class);
		return hub;
	}

	public String getDefaultHub(@PathVariable("id") Long id) {
		return "Possibily SFO";
	}

}
