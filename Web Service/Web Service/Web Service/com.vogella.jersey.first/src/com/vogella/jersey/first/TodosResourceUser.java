package com.vogella.jersey.first;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

// Will map the resource to the URL todos
@Path("/todoUser")
public class TodosResourceUser {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// Return the list of todos to the user in the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<User> getTodosBrowser() {
		List<User> todos = new ArrayList<User>();
		return todos;
	}

	// Return the list of todos for applications
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getTodos() {
		List<User> todos = new ArrayList<User>();
		return todos;
	}

	// retuns the number of todos
	// Use http://localhost:8080/com.vogella.jersey.todo/rest/todos/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return null;
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newTodo(@FormParam("name") String name, @FormParam("password") String password,
			@Context HttpServletResponse servletResponse, @Context HttpServletRequest request) throws IOException {
		String page = "";
		// Configuration configuration = new Configuration();
		// configuration.configure("hibernate.cfg.xml");
		// System.out.println("Cau hinh thanh cong");
		// SessionFactory factory = configuration.buildSessionFactory();
		// Session session1 = factory.openSession();
		Method simpleTest = new Method();
		User user = simpleTest.checkLogin(name, password);
		HttpSession session = request.getSession();
		if (user == null) {
			System.out.println("Dang nhap that bai");
			page = "../login.jsp";
		} else {
			System.out.println("Dang nhap thanh cong");
			if (user.getType_account().equals("admin")) {
				page = "../NewFile.jsp";
			} else {
				page = "../NewFile2.jsp";
			}
			session.setAttribute("user", user);
			System.out.println(user.toString());
		}
		servletResponse.sendRedirect(page);

		//
	}

	// Defines that the next path parameter after todos is
	// treated as a parameter and passed to the TodoResources
	// Allows to type http://localhost:8080/com.vogella.jersey.todo/rest/todos/1
	// 1 will be treaded as parameter todo and passed to TodoResource
	// @Path("{todo}")
	// public TodoResource getTodo(@PathParam("todo") String id) {
	// return new TodoResource(uriInfo, request, id);
	// }

}