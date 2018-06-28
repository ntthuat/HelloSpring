package vn.com.tma.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vn.com.tma.entity.Application;
import vn.com.tma.ultis.UriUltis;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String reason = request.getParameter("reason");
		int leave_day = Integer.parseInt(request.getParameter("leave_days"));
		String start_date = request.getParameter("start_date");
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("username");
		int status=0;
		if((boolean) session.getAttribute("admin"))
			status=1;
		Application app = new Application(leave_day, reason,status, start_date, username);

		WebTarget target = UriUltis.getTarget();
		Response p = target.path("application").request().post(Entity.entity(app, MediaType.APPLICATION_JSON));
		System.out.println(p.getStatus());
		if (p.getStatus() == 200) {
			//errorStr = "insert Success";

		} else {
			//RequestDispatcher dispatcher =this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp");
			//dispatcher.forward(request, response);
		}
		response.sendRedirect(this.getServletContext().getContextPath() + "/view");
		

	}

}
