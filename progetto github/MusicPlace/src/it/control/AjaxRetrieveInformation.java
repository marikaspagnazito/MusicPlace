package it.control;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

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

@WebServlet("/AjaxRetrieveInformation")
public class AjaxRetrieveInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public  AjaxRetrieveInformation() {
		super();
	}


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out= response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

	
		ArtistaModelDM model = new ArtistaModelDM();
		AlbumModelDM modelA= new AlbumModelDM();
		BranoModelDM modelB= new BranoModelDM();
		Collection<ArtistaBean> listArtisti = new LinkedList<ArtistaBean>();
		Collection<AlbumBean> listAlbum = new LinkedList<AlbumBean>();
		Collection<BranoBean> listBrano = new LinkedList<BranoBean>();
		
		try {
			listArtisti = ( LinkedList<ArtistaBean>) model.doRetrieveAll("");
			listAlbum= ( LinkedList<AlbumBean>) modelA.doRetrieveAll("");
			listBrano= ( LinkedList<BranoBean>) modelB.doRetrieveAll("");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	
		
		try {
		
		JSONArray jArray = new JSONArray();
		
		//artisti
		for(ArtistaBean e: listArtisti) {
			JSONObject json = new JSONObject();
			json.put("nome", e.getNome());
			json.put("tipo", "Artista");
			json.put("ID", String.valueOf(e.getID()));
			
			jArray.put(json);
			}
		
		//album
		for(AlbumBean e: listAlbum) {
			JSONObject json = new JSONObject();
			json.put("nome", e.getTitolo());
			json.put("tipo", "Album");
			json.put("ID", String.valueOf(e.getID()));
			
			jArray.put(json);
			}
		
		//brano
				for(BranoBean e: listBrano) {
					JSONObject json = new JSONObject();
					json.put("nome", e.getTitolo());
					json.put("tipo", "Brano");
					json.put("ID", String.valueOf(e.getID()));
					
					jArray.put(json);
					}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		
		out.print(jArray.toString()); //response.getWriter().write
		
		
	   System.out.println("JSON file created: "+jArray);
	
		
		
		} catch (JSONException e) {

		}
		

	}  
}
