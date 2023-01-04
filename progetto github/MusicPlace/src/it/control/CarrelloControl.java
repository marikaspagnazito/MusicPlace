package it.control;

import it.model.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CarrelloControl")
public class CarrelloControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CarrelloControl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		AlbumModelDM modelA = new AlbumModelDM();
		BranoModelDM modelB = new BranoModelDM();

		String key = request.getParameter("product");

		//aggiunta elemento al carrello
		if (request.getParameter("action").equals("add")) {
			try {
				if (request.getParameter("type").equals("album")) {
					AlbumBean album = modelA.doRetrieveByKey(key);
					cart.addItem(album);
				} else {
					BranoBean brano = modelB.doRetrieveByKey(key);
					cart.addItem(brano);
				}

				request.getSession().setAttribute("cart", cart);
             
			//aggiungere funzionalità per ritornare alla pagina precedente
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CarrelloView.jsp");
				dispatcher.forward(request, response);
		
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error");
			}
		 //cancella elemento dal carrello
		} else if (request.getParameter("action").equals("delete")) {
			
			try {
				if (request.getParameter("type").equals("album")) {
					AlbumBean album = modelA.doRetrieveByKey(key);
					cart.deleteItem(album);
				} else {
					BranoBean brano = modelB.doRetrieveByKey(key);
					cart.deleteItem(brano);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error");
			}
			
			request.getSession().setAttribute("cart", cart);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CarrelloView.jsp");
				dispatcher.forward(request, response);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
