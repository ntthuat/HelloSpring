package vn.com.tma.restful;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vn.com.tma.dao.ApplicationDAO;
import vn.com.tma.dao.EmployeeDAO;
import vn.com.tma.entity.Employee;

@Path("/employee")
public class EmployeeService {
	ApplicationDAO appDao= new ApplicationDAO();
	EmployeeDAO emDao= new EmployeeDAO();
	
	@GET
	@Path("/leave/{username}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getLeave(@PathParam("username")String username){
		int sumleave= emDao.getLeave(username);
		return Response.ok().entity(sumleave).build();
		
	}
	@GET
	@Path("/engineer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEngineer(){
		List<Employee> employees= emDao.getAllEngineer();
		GenericEntity<List<Employee>> entity =
		          new GenericEntity<List<Employee>>(employees) {};  
		  return Response.ok().entity(entity).build();
	}

	
}

