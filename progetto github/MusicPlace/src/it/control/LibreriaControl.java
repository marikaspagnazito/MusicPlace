package it.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import it.model.*;

@WebServlet("/LibreriaControl")
public class LibreriaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LibreriaControl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = null;
		OrdineModelDM model = new OrdineModelDM();
		OrdineDettaglioModelDM modelD = new OrdineDettaglioModelDM();
		AlbumModelDM modelA = new AlbumModelDM();
		BranoModelDM modelB = new BranoModelDM();
		
		List<Object> prodotti= new ArrayList<Object>();

		try {
			if (request.getSession().getAttribute("role")!=null) {
				username = (String) request.getSession().getAttribute("currentUser");
				Collection<OrdineBean> ordini= (Collection<OrdineBean>) model.doRetrieveByUsername(username);
				
				for (OrdineBean ordine: ordini) {
					int order=ordine.getNumeroOrdine();
					Collection<OrdineDettaglioBean> dettagli= (Collection<OrdineDettaglioBean>) modelD.doRetrieveAllByOrder(order);
					for(OrdineDettaglioBean dettaglio: dettagli) {
						int album=dettaglio.getIdAlbum();
						int brano=dettaglio.getIdBrano();
						
						if(album!=0) {
							AlbumBean al= modelA.doRetrieveByKey(String.valueOf(album));
							if(al!=null)
							prodotti.add(al);
						}else {
							BranoBean br= modelB.doRetrieveByKey(String.valueOf(brano));
							if(br!=null)
							prodotti.add(br);
						}
						
					}
					
				}
				
			}
			
			request.setAttribute("prodotti", prodotti);
			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Libreria.jsp");
			dispatcher.forward(request, response);
		
		} catch (SQLException e) {
			e.printStackTrace();

			request.setAttribute("error", e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
