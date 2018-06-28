package com.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class UriUltis {
	private static final WebTarget target= creatWebtarget();
	private static WebTarget creatWebtarget(){
		ClientConfig config = new ClientConfig();
		Client client =ClientBuilder.newClient(config);
		
		WebTarget target= client.target(UriBuilder.fromUri("http://localhost:8080/com.vogella.jersey.first/rest").build());
		return target;
		
	}
	public static WebTarget getTarget() {
		return target;
	}

}
