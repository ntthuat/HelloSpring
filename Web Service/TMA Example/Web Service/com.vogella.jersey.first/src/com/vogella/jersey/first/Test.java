package com.vogella.jersey.first;

import java.net.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import org.glassfish.jersey.client.ClientConfig;

import sun.security.action.GetBooleanSecurityPropertyAction;

public class Test {
	public static void main(String[] args){
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		
		String response = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
		
		String plainAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
	    String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
	    String htmlAnswer= target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);

	    System.out.println(response);
	    System.out.println(plainAnswer);
	    System.out.println(xmlAnswer);
	    System.out.println(htmlAnswer);
	}
	
	private static URI getBaseURI(){
		return UriBuilder.fromUri("http://localhost:8080/com.vogella.jersey.first").build();
	}
}
