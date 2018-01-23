package com.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;
@Path("/login")
public class ViewClient {
	// Allows to insert contextual objects into the class,
		// e.g. ServletContext, Request, Response, UriInfo
		@Context
		UriInfo uriInfo;
		@Context
		Request request;

		@GET
		@Produces(MediaType.TEXT_HTML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void getUser(@FormParam("name") String name, @FormParam("password") String password,
				@Context HttpServletResponse servletResponse, @Context HttpServletRequest request) throws IOException {
			String page = "";
			System.out.println(name);
			System.out.println(password);
			WebTarget target = UriUltis.getTarget();
			Response res = target.path("login").path(name).path(password).request().accept(MediaType.APPLICATION_JSON)
					.get();
			if (res.getStatus() == 200) {
				String json = res.readEntity(String.class);
				JSONObject jsonOb = new JSONObject(json);
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				if (jsonOb.getString("type_account").equals("admin")) {
					session.setAttribute("admin", true);
					System.out.println("You are admin");
				} else {
					System.out.println("You are not admin");
					session.setAttribute("admin", false);
				}
				page = "../NewFile.jsp";

			} else {
				String errorStr = "Password or Username incorrecly";
				request.setAttribute("error", errorStr);
				page = "../login.jsp";
			}
			servletResponse.sendRedirect(page);
		}
}
