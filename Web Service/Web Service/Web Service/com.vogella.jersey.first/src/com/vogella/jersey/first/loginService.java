package com.vogella.jersey.first;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class loginService {
	Method method = new Method();

	 @GET
     @Path("/userlogin/{name}/{password}")
     @Produces(MediaType.APPLICATION_JSON)
	public Response checkLogin(@PathParam("name") String namee, @PathParam("password") String passwordd) {
		System.out.println("-----Checking login-----");
		String name = namee;
		String password = passwordd;
		User user = method.checkLogin(name, password);
		if (user != null) {
			System.out.println("Login Success with user: "+user.toString());
			return Response.ok().entity(user).build();
		} else {
			System.out.println("Login fail");
			return Response.status(404).build();
		}
	}
}
