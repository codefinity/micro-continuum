package com.codefinity.microcontinuum.yservice.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MicroserviceSink.class)
public class Receiver {

	private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
	
	public Receiver() {

	}

	@ServiceActivator(inputChannel = MicroserviceSink.MicroserviceQ)
	public void accept(String message) {
		
		logger.info("Receiver: Sleuth Message at Y-Microservice for RabbitMQ");

		System.out.println("Spring Cloud Stream Output: " + message);

		/*
		 * System.out.println("Spring Cloud Stream Output: "
		 * +(String)message.get("MESSAGE1") +", " +(String)message.get("MESSAGE2") +", "
		 * +(String)message.get("MESSAGE3"));
		 */

	}
}

interface MicroserviceSink {
	public static String MicroserviceQ = "microserviceQ";

	@Input("microserviceQ")
	public MessageChannel microserviceQ();

}
