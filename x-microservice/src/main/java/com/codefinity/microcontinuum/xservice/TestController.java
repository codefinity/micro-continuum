package com.codefinity.microcontinuum.xservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefinity.microcontinuum.xservice.messaging.Sender;
import com.codefinity.microcontinuum.xservice.remotecalls.YService;
import com.codefinity.microcontinuum.xservice.remotecalls.dto.User;

@RestController
//Refreshes the property on refresh command
@RefreshScope
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Value("${x-microservice.config-test-value}")
	private String testProperty;
	
	@Value("${x-microservice.config-busrefresh-test-value}")
	private String testBusProperty;

	@Autowired
	private YService yService;

	@Autowired
	private Sender sender;
	
	@RequestMapping(value = "/hello")
	public String testService() {

		return "Service Working";
	}

	@RequestMapping(value = "/configservertest")
	public String testProperty() {

		return testProperty;
	}
	
	@RequestMapping(value = "/configserverbusrefreshtest")
	public String configServerBusRefreshTest() {

		return testBusProperty;
	}
	
	@RequestMapping(value = "/feigntest/{id}")
	public User testLoadBalancing(@PathVariable("id") Long id) {

		return yService.getUser(id);
	}

	/*@RequestMapping(value = "/testloadbalancing/{id}")
	public User testLoadBalancing(@PathVariable("id") Long id) {

		return yService.getUser(id);
	}*/

	@RequestMapping(value = "/cloudstreamingtest")
	public String testSpringCloudStreaming() {

		logger.info("Controller: Sleuth Message at X-Microservice for RabbitMQ");
		
		sender.send("Hello !");

		/*
		 * Map<String, Object> message = new HashMap<String, Object>();
		 * message.put("MESSAGE1", "message-1"); message.put("MESSAGE2", "message-2");
		 * message.put("MESSAGE3", "message-3");
		 * 
		 * sender.send(message);\
		 */
		 

		return "Message Sent";

	}

	/*@RequestMapping(value = "/elklogtest")
	public String elkLoTest() {

		logger.info("This is a log message");

		return "Message Logged";

	}*/
	
	/*@RequestMapping(value = "/sleuthtest")
	public String sleuthTest() {
		
		logger.info("Sleuth Message at X-Microservice");

		String message = yService.sleuthTest("Sleuth Test Message");
		
		logger.info("Sleuth Message End");
		
		return message;
	}*/

}
