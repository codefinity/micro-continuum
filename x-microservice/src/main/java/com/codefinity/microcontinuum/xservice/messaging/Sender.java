package com.codefinity.microcontinuum.xservice.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@EnableBinding(MicroserviceSource.class)
public class Sender {

	public Sender() {

	}


	@Output(MicroserviceSource.MicroserviceQ)
	@Autowired
	private MessageChannel messageChannel;

	public void send(String message) {
		// template.convertAndSend("InventoryQ", message);
		messageChannel.send(MessageBuilder.withPayload(message).build());
	}
}

interface MicroserviceSource {
	public static String MicroserviceQ = "microserviceQ";

	@Output("microserviceQ")
	public MessageChannel microserviceQ();

}
