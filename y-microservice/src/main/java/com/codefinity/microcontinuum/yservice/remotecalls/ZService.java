package com.codefinity.microcontinuum.yservice.remotecalls;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("z-microservice")
public interface ZService {
  
    @RequestMapping(method = RequestMethod.GET, value = "/sleuthtest/{message}")
    String sleuthTest(@PathVariable("message") String message);
	
}
