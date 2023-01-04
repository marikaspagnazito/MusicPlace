package it.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.model.ArtistaModelDM;


@WebServlet("/adminArtistiControl")
public class adminArtistiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public adminArtistiControl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArtistaModelDM model=new ArtistaModelDM();
		
		try {
			request.setAttribute("artisti", model.doRetrieveAll("nome"));
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error",e.getMessage());
		}
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/admin/ArtistaView.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
