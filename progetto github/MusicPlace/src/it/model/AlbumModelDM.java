package it.model;

import it.unisa.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;



public class AlbumModelDM implements DataModel <AlbumBean>{
	
	@Override
	public AlbumBean doRetrieveByKey (String key) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		AlbumBean bean = new AlbumBean();

		String query = "SELECT a.ID, a.titolo, a.prezzo, a.casa_discografica, a.copertina, a.IVA, ar.nome, a.anno_produzione "
				+ "FROM (album a JOIN incisione i ON i.ID_album = a.ID) "
				+ "JOIN artista ar ON i.ID_Artista = ar.ID" +
				" WHERE a.ID="+ key;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				bean.setID(rs.getInt("a.ID"));
				bean.setArtista(rs.getString("ar.nome"));
				bean.setTitolo(rs.getString("a.titolo"));
				bean.setCasa_discografica(rs.getString("a.casa_discografica"));
				bean.setPrezzo(rs.getDouble("a.prezzo"));
				bean.setIVA(rs.getDouble("a.IVA"));
				bean.setCopertina(rs.getString("a.copertina"));
				bean.setAnnoProduzione(rs.getInt("a.anno_produzione"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}
	

	@Override
	public Collection<AlbumBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<AlbumBean> products = new LinkedList<AlbumBean>();

		String query = "SELECT a.ID, a.titolo, a.prezzo, a.casa_discografica, a.copertina, a.IVA, ar.nome , a.anno_produzione "
				+ "FROM (album a JOIN incisione i ON i.ID_album = a.ID) "
				+ "JOIN artista ar ON i.ID_Artista = ar.ID";

		if (order != null && !order.equals("")) {
			query += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);

			System.out.println("doRetrieveAll: " + preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				AlbumBean bean = new AlbumBean();
				bean.setID(rs.getInt("a.ID"));
				bean.setArtista(rs.getString("ar.nome"));
				bean.setTitolo(rs.getString("a.titolo"));
				bean.setCasa_discografica(rs.getString("a.casa_discografica"));
				bean.setPrezzo(rs.getDouble("a.prezzo"));
				bean.setIVA(rs.getDouble("a.IVA"));
				bean.setCopertina(rs.getString("a.copertina"));
				bean.setAnnoProduzione(rs.getInt("a.anno_produzione"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	public Collection<AlbumBean> doRetrieveByArtista(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<AlbumBean> products = new LinkedList<AlbumBean>();


		String query = "SELECT a.ID, a.titolo, a.prezzo, a.casa_discografica, a.copertina, a.IVA, a.anno_produzione "
				+ "FROM (album a JOIN incisione i ON i.ID_album = a.ID) "
				+ "JOIN artista ar ON i.ID_Artista = ar.ID "
				+ "WHERE ar.ID = "+id;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);

			System.out.println("doRetrieveByArtista: " + preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				AlbumBean bean = new AlbumBean();
				bean.setID(rs.getInt("a.ID"));
				bean.setTitolo(rs.getString("a.titolo"));
				bean.setCasa_discografica(rs.getString("a.casa_discografica"));
				bean.setPrezzo(rs.getDouble("a.prezzo"));
				bean.setIVA(rs.getDouble("a.IVA"));
				bean.setAnnoProduzione(rs.getInt("a.anno_produzione"));
				bean.setCopertina(rs.getString("a.copertina"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	public Collection<AlbumBean> doRetrieveByAnno(int anno) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<AlbumBean> products = new LinkedList<AlbumBean>();

		String query ="SELECT a.ID, a.titolo, a.prezzo, a.casa_discografica, a.copertina, a.IVA, a.anno_produzione "
				+ "FROM (album a JOIN incisione i ON i.ID_album = a.ID) "
				+ "JOIN artista ar ON i.ID_Artista = ar.ID "
		        + "WHERE a.anno_produzione= "+anno;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);

			System.out.println("doRetrieveByArtista: " + preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				AlbumBean bean = new AlbumBean();
				bean.setID(rs.getInt("a.ID"));
				bean.setTitolo(rs.getString("a.titolo"));
				bean.setCasa_discografica(rs.getString("a.casa_discografica"));
				bean.setPrezzo(rs.getDouble("a.prezzo"));
				bean.setIVA(rs.getDouble("a.IVA"));
				bean.setAnnoProduzione(rs.getInt("a.anno_produzione"));
				bean.setCopertina(rs.getString("a.copertina"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	

	public synchronized void doSave(AlbumBean product,int idArtista) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		
		try {
			
			String query = "insert into album (ID,titolo, casa_discografica, copertina, prezzo, IVA,anno_produzione) values(?, ? ,? , ?, ?, ?,?);";
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, product.getID());
			preparedStatement.setString(2, product.getTitolo());
			preparedStatement.setString(3, product.getCasa_discografica());
			preparedStatement.setString(4, product.getCopertina());
			preparedStatement.setDouble(5, product.getPrezzo());
			preparedStatement.setDouble(6, product.getIVA());
			preparedStatement.setInt(7, product.getAnnoProduzione());
			
			
			preparedStatement.executeUpdate();

			connection.commit();
			
			try {
				String query1="INSERT INTO incisione(ID_artista,ID_album) values (?,?)";
				preparedStatement1=connection.prepareStatement(query1);
				preparedStatement1.setInt(1,idArtista);
				preparedStatement1.setInt(2, product.getID());
				
				preparedStatement1.executeUpdate();
				connection.commit();
				preparedStatement1.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		finally {
			try {
				if (preparedStatement != null) 
					preparedStatement.close();
			}
			  finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
			}
	}
	
	@Override
    public void doUpdate(AlbumBean item) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String querySQL = "UPDATE album set titolo=?, casa_discografica=?, prezzo=?, IVA=? , anno_produzione=? "
				+ " WHERE ID=" +item.getID();   
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			preparedStatement.setString(1,item.getTitolo());
			preparedStatement.setString(2,item.getCasa_discografica());
			preparedStatement.setDouble(3,item.getPrezzo());
			preparedStatement.setDouble(4,item.getIVA());
			preparedStatement.setInt(5,item.getAnnoProduzione());
			
		
			preparedStatement.executeUpdate();
			connection.commit();
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	

	@Override
	public void doDelete(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		
		
		String deleteAlbum = "DELETE FROM album WHERE ID = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement1= connection.prepareStatement(deleteAlbum);
			preparedStatement1.setString(1, code);
			preparedStatement1.executeUpdate();
			try {
				String deleteBrani="DELETE FROM brano WHERE ID_album= ?";
				preparedStatement2= connection.prepareStatement(deleteBrani);
				preparedStatement2.setString(1, code);
				preparedStatement2.executeUpdate();
				try {
					String deleteIncisione="DELETE FROM incisione WHERE ID_album= ?";
					preparedStatement3= connection.prepareStatement(deleteIncisione);
					preparedStatement3.setString(1, code);
					preparedStatement3.executeUpdate();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement1 != null && preparedStatement2!=null  && preparedStatement3!=null)
					preparedStatement1.close();
				    preparedStatement2.close();
				    preparedStatement3.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}


	@Override
	public void doSave(AlbumBean item) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	}
	

