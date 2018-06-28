package vn.com.tma.restful;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vn.com.tma.dao.ApplicationDAO;
import vn.com.tma.entity.Application;

@Path("/application")
public class ApplicationService {
	ApplicationDAO appDao= new ApplicationDAO();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createApplication(Application app){
		if(appDao.insertApplication(app)){
			return Response.ok().build();
		}
		return Response.status(404).build();
		
	}
	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getApplicatinByUser(@PathParam("username")String username){
		List<Application> applications= appDao.getApplicationByUser(username);
		GenericEntity<List<Application>> entity =
		          new GenericEntity<List<Application>>(applications) {};  
		  return Response.ok().entity(entity).build();
		
	}
	@Path("/approve")
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public Response approveApplication(String id){
		if(appDao.updateApplication(id, 1))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
	@Path("reject")
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public Response rejectApplication(String id){
		if(appDao.updateApplication(id, -1))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
	
}
