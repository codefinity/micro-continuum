package com.codefinity.microcontinuum.common.port.adapter.messaging.slothmq;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class ExchangeListener {

	private Set<String> messageTypes;

    public ExchangeListener() {
        super();

        this.establishMessageTypes();

    	SlothClient.instance().register(this);
    }

    public void close() {
    	SlothClient.instance().unregister(this);
    }

    protected abstract String exchangeName();

    protected abstract void filteredDispatch(String aType, String aTextMessage);

    protected abstract String[] listensTo();

	protected boolean listensTo(String aType) {
		Set<String> types = this.listensToMessageTypes();

		return types.isEmpty() || types.contains(aType);
	}

	protected abstract String name();

    private void establishMessageTypes() {
        String[] filterOutAllBut = this.listensTo();

        if (filterOutAllBut == null) {
            filterOutAllBut = new String[0];
        }

        this.setMessageTypes(new HashSet<String>(Arrays.asList(filterOutAllBut)));
    }

    private Set<String> listensToMessageTypes() {
    	return this.messageTypes;
    }

    private void setMessageTypes(HashSet<String> aMessageTypes) {
    	this.messageTypes = aMessageTypes;
	}
}
