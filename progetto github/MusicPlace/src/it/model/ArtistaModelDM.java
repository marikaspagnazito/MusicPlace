package it.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import it.unisa.DriverManagerConnectionPool;

public class ArtistaModelDM implements DataModel <ArtistaBean>{

	
	@Override
	public ArtistaBean doRetrieveByKey (String key) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArtistaBean bean = new ArtistaBean();

		String query = "SELECT a.ID, a.nome, a.foto "
				+ "FROM artista a "
				+ "WHERE a.ID= " + key;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				bean.setID(rs.getInt("a.ID"));
				bean.setNome(rs.getString("a.nome"));
				bean.setFoto(rs.getString("a.foto"));
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
	
	public ArtistaBean doRetrivebyAlbumID (String key) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArtistaBean bean = new ArtistaBean();
		
		String query= "SELECT ar.ID, ar.nome, ar.foto "
				+ "FROM (album a JOIN incisione i ON i.ID_album = a.ID) "
				+ "JOIN artista ar ON i.ID_Artista = ar.ID "
				+ "WHERE a.ID = "+ key;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				bean.setID(rs.getInt("ar.ID"));
				bean.setNome(rs.getString("ar.nome"));
				bean.setFoto(rs.getString("ar.foto"));
			}

		}catch (SQLException e) {
			e.printStackTrace();
			
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
	public Collection<ArtistaBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ArtistaBean> products = new LinkedList<ArtistaBean>();

		String query = "SELECT * FROM artista";

		if (order != null && !order.equals("")) {
			query += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				ArtistaBean bean = new ArtistaBean();
				bean.setID(rs.getInt("ID"));
				bean.setNome(rs.getString("nome"));
				bean.setFoto(rs.getString("foto"));
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
	
	@Override
	public synchronized void doSave(ArtistaBean product) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String query = "insert into artista(nome,foto) values(?, ?);";
				

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product.getNome());
			preparedStatement.setString(2, product.getFoto());
			
			
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
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
		
	}
	
	@Override
	public void doUpdate(ArtistaBean item) throws SQLException {
		
	}
	
}
