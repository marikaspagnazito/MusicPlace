package it.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.model.AlbumModelDM;
import it.model.BranoBean;
import it.model.BranoModelDM;

@WebServlet("/adminDettaglioCatalogoControl")
public class adminDettaglioCatalogoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public adminDettaglioCatalogoControl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AlbumModelDM modelA = new AlbumModelDM();
		BranoModelDM modelB = new BranoModelDM();
		BranoBean brano=new BranoBean();

		String action = request.getParameter("action");
		String key= (String) request.getParameter("product");
		String codice = (String) request.getParameter("id");
		String IdAlbum=null;

		try {
			if (action != null) {
				if(action.equalsIgnoreCase("delete")) {
					modelB.doDelete(key);
					
				}
				else if(action.equals("inserimentoBrano")) {
					brano.setTitolo(request.getParameter("titolo"));
					String prezzo=request.getParameter("prezzo");
					double price=Double.parseDouble(prezzo);
					brano.setPrezzo(price);
					brano.setIVA((price*22)/100);
					IdAlbum= request.getParameter("idAlbum");
					int idAlbum=Integer.parseInt(IdAlbum);
					brano.setIdAlbum(idAlbum);
					modelB.doSave(brano);
					
				}else {
					String chiave=request.getParameter("IDBrano");
					brano.setID(Integer.parseInt(chiave));
					brano.setTitolo(request.getParameter("titolo"));
					String prezzo=request.getParameter("prezzo");
					double price=Double.parseDouble(prezzo);
					brano.setPrezzo(price);
					brano.setIVA((price*22)/100);
					modelB.doUpdate(brano);
					BranoBean bean=modelB.doRetrieveByKey(chiave);
				    int IDAlbum=bean.getIdAlbum();
				    IdAlbum=String.valueOf(IDAlbum);
				}
			}
		} catch (SQLException e2) {
			System.out.println("Error:" + e2.getMessage());
		}

		try {
			if(codice==null) {
				request.setAttribute("album", modelA.doRetrieveByKey(IdAlbum));
				request.setAttribute("brani", modelB.DoRetriveByAlbumID(IdAlbum));
			}else {
		request.setAttribute("album", modelA.doRetrieveByKey(codice));
		request.setAttribute("brani", modelB.DoRetriveByAlbumID(codice));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/catalogoDettaglioView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
