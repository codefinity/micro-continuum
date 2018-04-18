package com.codefinity.microcontinuum.common.port.adapter.messaging.slothmq;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

public class ClientRegistration {

	private Set<String> exchanges;
	private InetAddress ipAddress;
	private int port;

	ClientRegistration(InetAddress anIPAddress, int aPort) {
		super();

		try {
	        this.exchanges = new HashSet<String>();
            this.ipAddress = anIPAddress == null ? InetAddress.getLocalHost() : anIPAddress;
            this.port = aPort;
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Cannot create client registration because unknown host.");
        }
	}

    ClientRegistration(int aPort) {
        this(null, aPort);
    }

	public void addSubscription(String anExchangeName) {
		System.out.println("ADDING EXCHANGE: " + anExchangeName);
		this.exchanges.add(anExchangeName);
	}

	public boolean matches(InetAddress anIPAddress, int aPort) {
		return this.ipAddress.toString().equals(anIPAddress.toString()) && this.port == aPort;
	}

	public boolean isSubscribedTo(String anExchangeName) {
		return this.exchanges.contains(anExchangeName);
	}

	public InetAddress ipAddress() {
		return this.ipAddress;
	}

	public int port() {
		return this.port;
	}

	public void removeSubscription(String anExchangeName) {
		this.exchanges.remove(anExchangeName);
	}

	@Override
	public String toString() {
		return "ClientRegistration [ipAddress=" + this.ipAddress + ", port="
				+ this.port + ", exchanges=" + this.exchanges + "]";
	}
}
