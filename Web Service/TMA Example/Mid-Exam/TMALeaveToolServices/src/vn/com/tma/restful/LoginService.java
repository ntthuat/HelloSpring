package vn.com.tma.restful;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vn.com.tma.dao.EmployeeDAO;
import vn.com.tma.entity.Employee;
import vn.com.tma.entity.ResultService;

@Path("/login")
public class LoginService {
	EmployeeDAO emDao= new EmployeeDAO();
	
	@Path("/{user}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkLogin(@PathParam("user")String username,@PathParam("password")String password){
		System.out.println("scas");
		Employee employee= emDao.checkLogin(username, password);
		ResultService resultService= new ResultService();
		if(employee!=null){
			return Response.ok().entity(employee).build();
		}else{
			resultService.setError(1);
			resultService.setMesssage("Login error");
			return Response.status(404).entity(resultService).build();
		}
		
	}
}
