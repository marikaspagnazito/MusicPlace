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

@WebServlet("/AdminOrdiniControl")
public class AdminOrdiniControl extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public AdminOrdiniControl () {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OrdineModelDM model = new OrdineModelDM();
		 OrdineDettaglioModelDM modelB=new OrdineDettaglioModelDM();
		 
	     String ordine=(String) request.getParameter("order");
	    
		
		if(ordine!=null) {
	     try {
	    	    int order=Integer.parseInt(ordine);
				request.setAttribute("dettagli",modelB.doRetrieveAllByOrder(order));
			}
			
			 catch (SQLException e) {
					e.printStackTrace();
					
					request.setAttribute("error",e.getMessage());
				}
		
		
		}
		
		
		try {
			request.setAttribute("ordini", model.doRetrieveAll("data_ordine"));
		}

		catch (SQLException e) {
			e.printStackTrace();

			request.setAttribute("error", e.getMessage());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/OrdiniViewAdmin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
