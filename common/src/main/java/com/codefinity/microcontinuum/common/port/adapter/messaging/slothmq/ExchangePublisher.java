package com.codefinity.microcontinuum.common.port.adapter.messaging.slothmq;

public class ExchangePublisher {

	private String exchangeName;

	public ExchangePublisher(String anExchangeName) {
		super();

		this.exchangeName = anExchangeName;
	}

	public void publish(String aType, String aMessage) {
		SlothClient.instance().publish(this.exchangeName(), aType, aMessage);
	}

	private String exchangeName() {
		return this.exchangeName;
	}
}
