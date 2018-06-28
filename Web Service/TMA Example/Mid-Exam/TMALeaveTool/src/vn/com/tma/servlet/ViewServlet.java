package vn.com.tma.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import vn.com.tma.entity.Application;
import vn.com.tma.ultis.UriUltis;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		String username=(String) session.getAttribute("username");
		
		
		WebTarget target= UriUltis.getTarget();
		String leave= target.path("employee").path("leave").path(username).request().accept(MediaType.TEXT_PLAIN).get(String.class);
		request.setAttribute("leave", leave);
		
		String jsonArrayStr= target.path("application").path(username).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(jsonArrayStr);
		List<Application> applications=new ArrayList<>();
		JSONArray jsonArray= new JSONArray(jsonArrayStr);
		for(int i=0;i<jsonArray.length();i++){
			Application app= new Application();
			JSONObject json= jsonArray.getJSONObject(i);
			app.setId(json.getInt("id"));
			app.setLeave_days(json.getInt("leave_days"));
			app.setReason(json.getString("reason"));
			app.setStart_date(json.getString("start_date"));
			app.setStatus(json.getInt("status"));
			app.setUsername("username");
			applications.add(app);
			
		}
		request.setAttribute("applicationList", applications);
		RequestDispatcher dispatcher=null;
		System.out.println("admin:"+(boolean) session.getAttribute("admin"));
		if((boolean) session.getAttribute("admin")){
			dispatcher =this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp");
		}else{
			dispatcher =this.getServletContext().getRequestDispatcher("/WEB-INF/views/engineer.jsp");
		}
		
		dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
