package it.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutControl")
public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LogoutControl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			   if(session.getAttribute("role").equals("Administrator")) {
				session.removeAttribute("role");
				session.invalidate();
			   }else {
				   session.removeAttribute("role");
				   session.removeAttribute("currentUser");
				   session.invalidate();
			   }
			}
			   
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/HomeView.jsp"));

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
