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
 * Servlet implementation class adminCatalogoControl
 */
@WebServlet("/adminCatalogoControl")
public class adminCatalogoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public adminCatalogoControl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AlbumModelDM modelA = new AlbumModelDM();
		ArtistaModelDM modelAr= new ArtistaModelDM();
		BranoModelDM modelB = new BranoModelDM();
		AlbumBean album = new AlbumBean();
		BranoBean brano = new BranoBean();
		ArtistaBean artista=new ArtistaBean();
		
		
		String action = request.getParameter("action");
		String codice = (String) request.getParameter("id");
		try {
			if (action !=null) {
				if(action.equalsIgnoreCase("delete")) {
						modelA.doDelete(codice);
			     }
				else if(action.equalsIgnoreCase("inserimentoAlbum")) {
					String albumId=request.getParameter("IdAlbum");
					int idAlbum=Integer.parseInt(albumId);
					album.setID(idAlbum);
					album.setTitolo(request.getParameter("titolo"));
					album.setCasa_discografica(request.getParameter("casa_disc"));
					String prezzo=request.getParameter("prezzo");
					double price=Double.parseDouble(prezzo);
					album.setPrezzo(price);
					album.setIVA((price*22)/100);
					String anno=request.getParameter("anno");
					int annoProd=Integer.parseInt(anno);
					album.setAnnoProduzione(annoProd);
					String idArtista=request.getParameter("artista");
					int IDArtista=Integer.parseInt(idArtista);
					String copertina=request.getParameter("copertina");
					album.setCopertina(copertina);
					modelA.doSave(album,IDArtista);
				}else if(action.equalsIgnoreCase("inserimentoArtista")){
					artista.setNome(request.getParameter("nome"));
					artista.setFoto(request.getParameter("foto"));
					modelAr.doSave(artista);
				}else {
					String albumId=request.getParameter("IDAlbum");
					int idAlbum=Integer.parseInt(albumId);
					album.setID(idAlbum);
					album.setTitolo(request.getParameter("titolo"));
					album.setCasa_discografica(request.getParameter("casad"));
					String prezzo=request.getParameter("prezzo");
					double price=Double.parseDouble(prezzo);
					album.setPrezzo(price);
					album.setIVA((price*22)/100);
					String anno=request.getParameter("anno");
					int annoProd=Integer.parseInt(anno);
					album.setAnnoProduzione(annoProd);
					modelA.doUpdate(album);
				}
			}
		} catch (SQLException e2) {
			System.out.println("Error:" + e2.getMessage());
		}

		try {
			request.setAttribute("album", modelA.doRetrieveAll("nome"));
			request.setAttribute("artisti", modelAr.doRetrieveAll("nome"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/catalogoView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
