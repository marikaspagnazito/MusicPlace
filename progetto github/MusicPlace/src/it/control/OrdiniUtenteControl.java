package it.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.model.OrdineDettaglioModelDM;
import it.model.OrdineModelDM;

@WebServlet("/OrdiniUtenteControl")
public class OrdiniUtenteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrdiniUtenteControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdineModelDM model = new OrdineModelDM();
		String username = null;

		OrdineDettaglioModelDM modelB = new OrdineDettaglioModelDM();
		String ordine = (String) request.getParameter("order");
		
		if(ordine!=null) {
		try {
            int order = Integer.parseInt(ordine);
			request.setAttribute("dettagli", modelB.doRetrieveAllByOrder(order));
		}

		catch (SQLException e) {
			e.printStackTrace();

			request.setAttribute("error", e.getMessage());
		}

		}
		
		try {
			if (request.getSession().getAttribute("role")!=null) {
				username = (String) request.getSession().getAttribute("currentUser");
				request.setAttribute("ordiniUtente", model.doRetrieveByUsername(username));
			} else {

			}
		} catch (SQLException e) {
			e.printStackTrace();

			request.setAttribute("error", e.getMessage());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/OrdiniUtente.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
