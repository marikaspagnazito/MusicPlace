package it.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.model.AlbumBean;
import it.model.AlbumModelDM;
import it.model.ArtistaBean;
import it.model.ArtistaModelDM;
import it.model.BranoBean;
import it.model.BranoModelDM;

/**
 * Servlet implementation class DettaglioControl
 */
@WebServlet("/DettaglioControl")
public class DettaglioControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DettaglioControl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AlbumModelDM modelA = new AlbumModelDM();
		BranoModelDM modelB = new BranoModelDM();
		ArtistaModelDM modelAr = new ArtistaModelDM();

		String codice = (String) request.getParameter("product");

		try {
			  // dettaglio Album
			if (request.getParameter("type").equals("album")) {
				request.setAttribute("album", modelA.doRetrieveByKey(codice));
				request.setAttribute("brani", modelB.DoRetriveByAlbumID(codice));

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DettaglioAlbum.jsp");
				dispatcher.forward(request, response);

				// dettaglio Brano
			} else if (request.getParameter("type").equals("brano")) {
				BranoBean brano = (BranoBean) modelB.doRetrieveByKey(codice);

				String chiave = Integer.toString(brano.getIdAlbum());
				request.setAttribute("album", modelA.doRetrieveByKey(chiave));
				request.setAttribute("brano", brano);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DettaglioBrano.jsp");
				dispatcher.forward(request, response);

				// dettaglio Artista
			} else if (request.getParameter("type").equals("artista")) {
				System.out.println("caso artista:" + codice);
				ArtistaBean artista = (ArtistaBean) new ArtistaBean();
				artista = modelAr.doRetrivebyAlbumID(codice);
				request.setAttribute("artista", artista);

				String chiave = Integer.toString(artista.getID());
				request.setAttribute("album", modelA.doRetrieveByArtista(chiave));

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DettaglioArtista.jsp");
				dispatcher.forward(request, response);
			} else if(request.getParameter("type").equals("artistaAjax")) {
				ArtistaBean artista = (ArtistaBean) new ArtistaBean();
				artista=modelAr.doRetrieveByKey(codice);
				request.setAttribute("artista", artista);
				request.setAttribute("album", modelA.doRetrieveByArtista(codice));
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DettaglioArtista.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
