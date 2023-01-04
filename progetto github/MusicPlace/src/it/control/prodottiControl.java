package it.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.Iterator;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import it.model.AlbumBean;
import it.model.AlbumModelDM;
import it.model.BranoModelDM;

@WebServlet("/prodottiControl")
public class prodottiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public prodottiControl() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlbumModelDM modelA=new AlbumModelDM(); 
		BranoModelDM modelB= new BranoModelDM();
		
		try {
			request.setAttribute("album", modelA.doRetrieveAll("nome"));
			request.setAttribute("brani", modelB.doRetrieveAll("titolo"));
			request.setAttribute("playlistArtista", modelA.doRetrieveByArtista("9"));
			request.setAttribute("playlistAnno", modelA.doRetrieveByAnno(2021));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error",e.getMessage());
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/HomeView.jsp");
		dispatcher.forward(request, response);
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
