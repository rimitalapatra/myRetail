package com.myretail.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "server")
@Configuration("mongoProperties")

public class url {
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	private String host;
	private String protocol;
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	private int port;

}
