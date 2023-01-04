package it.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import it.unisa.DriverManagerConnectionPool;




public class BranoModelDM implements DataModel <BranoBean> {
	
	
	public BranoBean doRetrieveByKey (String key) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BranoBean bean = new BranoBean();

		String query = "SELECT b.ID, b.titolo, b.prezzo, b.IVA, b.ID_album "
				+ "FROM brano b "
				+ "WHERE b.ID = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(key));

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				bean.setID(rs.getInt("b.ID"));
				bean.setTitolo(rs.getString("b.titolo"));
				bean.setPrezzo(rs.getDouble("b.prezzo"));
				bean.setIVA(rs.getDouble("b.IVA"));
				bean.setIdAlbum(rs.getInt("b.ID_album"));
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

	public Collection<BranoBean> DoRetriveByAlbumID(String code) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<BranoBean> products = new LinkedList<BranoBean>();

		String query = "SELECT b.ID, b.titolo, b.prezzo, b.IVA "
				+ "FROM brano b JOIN album a ON b.ID_album = a.ID "
				+ "WHERE b.ID_album = " + code;
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				BranoBean bean = new BranoBean();
				bean.setID(rs.getInt("b.ID"));
				bean.setTitolo(rs.getString("b.titolo"));
				bean.setPrezzo(rs.getDouble("b.prezzo"));
				bean.setIVA(rs.getDouble("b.IVA"));
				products.add(bean);
			}

		}finally {
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
	public Collection<BranoBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<BranoBean> products = new LinkedList<BranoBean>();

		String query = "SELECT * FROM brano";

		if (order != null && !order.equals("")) {
			query += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				BranoBean bean = new BranoBean();
				bean.setID(rs.getInt("ID"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setIVA(rs.getDouble("IVA"));
				bean.setIdAlbum(rs.getInt("ID_album"));
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
	public synchronized void doSave(BranoBean product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String query = "insert into brano(ID, titolo, prezzo, IVA , ID_album) values(?, ?, ?, ?, ?);";
				

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, product.getID());
			preparedStatement.setString(2, product.getTitolo());
			preparedStatement.setDouble(3, product.getPrezzo());
			preparedStatement.setDouble(4, product.getIVA());
			preparedStatement.setInt(5, product.getIdAlbum());
			
			
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
    public void doUpdate(BranoBean item) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String querySQL = "UPDATE brano set titolo=?, prezzo=?, IVA=?  where ID="+item.getID();
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			preparedStatement.setString(1,item.getTitolo());
			preparedStatement.setDouble(2, item.getPrezzo());
			preparedStatement.setDouble(3, item.getIVA());
		
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
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM brano WHERE ID = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, code);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}
	}
	
	
	
