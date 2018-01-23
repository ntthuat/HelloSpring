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
import vn.com.tma.entity.Employee;
import vn.com.tma.ultis.UriUltis;

/**
 * Servlet implementation class ApproveSevlet
 */
@WebServlet("/approvereject")
public class ApproveRejectSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveRejectSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		
		
		WebTarget target= UriUltis.getTarget();
		
		String jsonEnginee= target.path("employee").path("engineer").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		JSONArray jsonArrEnginee= new JSONArray(jsonEnginee); 
		List<Employee> listEnginee= new ArrayList<>();
		for(int i=0;i<jsonArrEnginee.length();i++){
			Employee enginee= new Employee();
			JSONObject json= jsonArrEnginee.getJSONObject(i);
			enginee.setUsername(json.getString("username"));
			listEnginee.add(enginee);
		}
		request.setAttribute("engineeList", listEnginee);
		
		String username=request.getParameter("employee");
		if(username==null)
			username=listEnginee.get(0).getUsername();
		String leave= target.path("employee").path("leave").path(username).request().accept(MediaType.TEXT_PLAIN).get(String.class);
		request.setAttribute("leave", leave);
		request.setAttribute("user", username);
	
		String jsonArrayStr= target.path("application").path(username).request().accept(MediaType.APPLICATION_JSON).get(String.class);
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
			app.setUsername(username);
			applications.add(app);
		}
		if(!(boolean) session.getAttribute("admin")){
			System.out.println("not admin");
			response.sendRedirect(this.getServletContext().getContextPath() + "/view");
		}else{
			request.setAttribute("applicationList", applications);
			RequestDispatcher dispatcher =this.getServletContext().getRequestDispatcher("/WEB-INF/views/approve.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
