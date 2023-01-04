package it.control;

import it.model.*;

public class CheckLogin {
	
	
	
	public static boolean IsUtente(String username, String password) {
		try{
			UtenteModelDM model = new UtenteModelDM();
			UtenteBean user = (UtenteBean) model.doRetrieveUtente(username);
			if(user != null){		
	           if(user.getPassword().equals(password)) {
	        	   return true;
	           }
	           else {
	        	   return false;
	           }
			}
		}catch(Exception e){
			 System.out.println(e);
		}
		return false;
	}
	
	public static boolean IsAdministrator(String username, String password) {
		
		if((username.equals("Marika") && password.equals("0000")) || (username.equals("Piero") && password.equals("0000")))
			return true;
		else
			return false;
	}
}
