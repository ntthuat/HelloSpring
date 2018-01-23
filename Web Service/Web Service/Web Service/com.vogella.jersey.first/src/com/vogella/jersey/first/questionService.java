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

@Path("/question")
public class questionService {
	// ApplicationDAO appDao= new ApplicationDAO();
	Method me = new Method();

	@GET
	@Path("/allQuestion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllQuestion() {
		List<question> ques = new ArrayList<question>();
		ques = me.getAllQuestion();
		GenericEntity<List<question>> entity = new GenericEntity<List<question>>(ques) {
		};
		return Response.ok().entity(entity).build();
	}
	
	@GET
    @Path("/updateScore/{username}/{classPerson}/{project}/{count}/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateScoreUser(@PathParam("username") String usernamee, @PathParam("classPerson") String classPersonn,
    		@PathParam("project") String projectt, @PathParam("count") String countt, @PathParam("number") String numberr) {
            System.out.println("------Updating score-----");
            int count = Integer.parseInt(countt);
            int number = Integer.parseInt(numberr);
            String username = usernamee;
            String classPerson = classPersonn;
            String project = projectt;
            me.updateScore(username, classPerson, project, count, number);
            List<person> per = me.showPerson();
            GenericEntity<List<person>> entity = new GenericEntity<List<person>>(per) {
            };
            return Response.ok().entity(entity).build();
    }
	
}
