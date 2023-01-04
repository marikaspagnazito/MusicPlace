package it.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.model.UtenteBean;
import it.model.UtenteModelDM;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginControl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("un");
		String password = request.getParameter("pw");

		System.out.println(username);
		if (CheckLogin.IsAdministrator(username, password)) {
			request.getSession().setAttribute("role", "Administrator");
			response.sendRedirect("/MusicPlace/admin/OrdiniViewAdmin.jsp");
		} else if (CheckLogin.IsUtente(username, password)) {

			// setta parametro dell'utente corrente tramite username
			request.getSession().setAttribute("currentUser", username);

			// setta parametro dell'ruolo (role) con Admistrator || User
			request.getSession().setAttribute("role", "User");
			response.sendRedirect("HomeView.jsp");
		} else {
			response.sendRedirect("LoginView.jsp");
		}
	}
}


