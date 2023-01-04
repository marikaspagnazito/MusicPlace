package it.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import it.model.*;

@WebServlet("/RegistrazioneControl")
public class RegistrazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegistrazioneControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteModelDM model = new UtenteModelDM();
		UtenteBean utente=new UtenteBean();
		
		
		utente.setUsername(request.getParameter("user"));
		utente.setPassword(request.getParameter("pass"));
		utente.setEmail(request.getParameter("email"));
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		
		
		
		
		String dateInString = request.getParameter("data_nascita");
		String [] list = dateInString.split("-");
		String year = list[0];
		String month = list[1];
		String day = list[2];
		Date dateOfBirth = new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(day)+1);
		java.sql.Date sqlDate = new java.sql.Date(dateOfBirth.getTime());

		 Calendar calendar = Calendar.getInstance();
		calendar.setTime( sqlDate    );
		utente.setData_nascita(calendar);
		 
		
		utente.setCitta(request.getParameter("citta"));
		utente.setProvincia(request.getParameter("provincia"));
		utente.setCap(request.getParameter("cap"));
		utente.setIndirizzo(request.getParameter("indirizzo"));
		utente.setCivico(request.getParameter("civico"));
		utente.setContatto(request.getParameter("contatto"));
		
		try {
			 model.doSave(utente);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginView.jsp");
		dispatcher.forward(request, response);
	}

		

}
