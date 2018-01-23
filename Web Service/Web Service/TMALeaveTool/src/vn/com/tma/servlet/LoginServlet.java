package vn.com.tma.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import vn.com.tma.ultis.UriUltis;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password= request.getParameter("password");
		WebTarget target= UriUltis.getTarget();
		Response p=target.path("login").path(username).path(password).request().accept(MediaType.APPLICATION_JSON).get();
		if(p.getStatus()==200){
			String json= p.readEntity(String.class);
			JSONObject jsonOb= new JSONObject(json);
			HttpSession session= request.getSession();
			session.setAttribute("username", username);
			if(jsonOb.getInt("admin")==1){
				session.setAttribute("admin", true);
			}else{
				
				session.setAttribute("admin", false);
			}
			response.sendRedirect(this.getServletContext().getContextPath() + "/view");
			
	        
		}
		else{
			String errorStr= "Password or Username incorrecly";
			request.setAttribute("errorStr", errorStr);
			RequestDispatcher dispatcher =this.getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
	}

}
