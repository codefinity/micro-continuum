package com.codefinity.microcontinuum.yservice.messaging;

import java.util.Map;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MicroserviceSink.class)
public class Receiver {

	public Receiver() {

	}

	@ServiceActivator(inputChannel = MicroserviceSink.MicroserviceQ)
	public void accept(String message) {

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
