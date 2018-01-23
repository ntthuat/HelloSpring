package com.vogella.jersey.first;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class userService {
	Method me = new Method();

	@GET
	@Path("/allUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUSER() {
		List<User> user = new ArrayList<User>();
		user = me.getAllUser();
		GenericEntity<List<User>> entity = new GenericEntity<List<User>>(user) {
		};
		return Response.ok().entity(entity).build();
	}
	
	@GET
	@Path("/registerUser/{username}/{userpassword}/{fullname}/{classPerson}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registeruser(@PathParam("username") String username, @PathParam("userpassword") String userpassword,
			@PathParam("fullname") String fullname, @PathParam("classPerson") String classPerson) {
		System.out.println("------Registing New User-----");
		User user = new User();
		user = me.addUser(username, userpassword, fullname, classPerson);
		System.out.println(user.toString());
		return Response.ok().entity(user).build();
	}
	
}
