package it.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;

import it.unisa.DriverManagerConnectionPool;

public class UtenteModelDM implements DataModel <UtenteBean>  {


	
	public UtenteBean doRetrieveUtente (String username) {
		Connection connessione = null;
		PreparedStatement statement = null;
		UtenteBean utente = new UtenteBean();
		
		String query="SELECT *" + 
				" FROM utente" + 
				" WHERE username = '" + username + "'";
		try {
			connessione = DriverManagerConnectionPool.getConnection();
			statement = connessione.prepareStatement(query);

			ResultSet rs = statement.executeQuery(query);
				
			while (rs.next()) {
		    	utente.setUsername(rs.getString("username"));
				utente.setPassword(rs.getString("pasword"));
				utente.setEmail(rs.getString("email"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate("data_ordine"));
				utente.setData_nascita(calendar);
				utente.setCitta(rs.getString("citta"));
				utente.setProvincia(rs.getString("provincia"));
				utente.setCap(rs.getString("cap"));
				utente.setIndirizzo(rs.getString("indirizzo"));
				utente.setCivico(rs.getString("civico"));
				utente.setContatto(rs.getString("contatto"));
		      }
		      }
		      catch (Exception ex) 
		      {
		         System.out.println("Log In failed: An Exception has occurred! " + ex);
		      } 
			
		//some exception handling
		   finally 
		   {
		      if (statement != null) {
		         try {
		            statement.close();
		         } catch (Exception e) {}
		            statement = null;
		         }
			
		      if (connessione != null) {
		         try {
		            connessione.close();
		         } catch (Exception e) {
		         }

		         connessione = null;
		      }
		   }

		return utente;
		
	}

	@Override
	public UtenteBean doRetrieveByKey(String key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<UtenteBean> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(UtenteBean utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement codice = null;
		ResultSet rs = null;
		
		String query="INSERT INTO utente (username,pasword,email,nome,cognome,data_nascita,citta,provincia,cap,indirizzo,civico,contatto)"
				    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			connection= DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,utente.getUsername());
			preparedStatement.setString(2,utente.getPassword());
			preparedStatement.setString(3,utente.getEmail());
			preparedStatement.setString(4,utente.getNome());
			preparedStatement.setString(5,utente.getCognome());
			Date date = new Date(utente.getData_nascita().getTimeInMillis());
			preparedStatement.setDate(6,date);
			preparedStatement.setString(7,utente.getCitta());
			preparedStatement.setString(8,utente.getProvincia());
			preparedStatement.setString(9,utente.getCap());
			preparedStatement.setString(10,utente.getIndirizzo());
			preparedStatement.setString(11,utente.getCivico());
			preparedStatement.setString(12,utente.getContatto());
			
			preparedStatement.executeUpdate();

			connection.commit();
			
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}

	@Override
	public void doUpdate(UtenteBean item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDelete(String code) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
