package com.codefinity.microcontinuum.xservice.remotecalls;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codefinity.microcontinuum.xservice.remotecalls.dto.User;

@FeignClient("y-microservice")
public interface YService {

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    User getUser(@PathVariable("id") Long id);
    
    @RequestMapping(method = RequestMethod.GET, value = "/sleuthtest/{message}")
    String sleuthTest(@PathVariable("message") String message);
	
}
