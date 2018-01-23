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

@Path("/person")
public class personService {
	// ApplicationDAO appDao= new ApplicationDAO();
	Method me = new Method();

	// @GET
	// @Path("/leave/{username}")
	// @Produces(MediaType.TEXT_PLAIN)
	// public Response getLeave(@PathParam("username")String username){
	// int sumleave= emDao.getLeave(username);
	// return Response.ok().entity(sumleave).build();

	@GET
	@Path("/personResult")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllQuestion() {
		List<person> per = new ArrayList<person>();
		per = me.getAllPerson();
		GenericEntity<List<person>> entity = new GenericEntity<List<person>>(per) {
		};
		return Response.ok().entity(entity).build();
	}	
}
