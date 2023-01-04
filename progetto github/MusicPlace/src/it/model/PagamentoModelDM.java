package it.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;

import it.unisa.DriverManagerConnectionPool;

public class PagamentoModelDM implements DataModel<PagamentoBean>{


	public Collection<PagamentoBean> doRetrieveByUtente(String key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection <PagamentoBean> pagamenti = new LinkedList<PagamentoBean>();
		String query = "SELECT p.numero, p.circuito, p.scadenza "
				+ "FROM ( metodo_pagamento p JOIN utilizzo u ON p.numero=u.numero_carta) "
				+ " JOIN utente a ON u.username_utente = a.username "
				+ " WHERE a.username= '"+ key + "'";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				PagamentoBean bean= new PagamentoBean();
				bean.setNumeroCarta(rs.getString("p.numero"));
				bean.setCircuito(rs.getString("p.circuito"));
				bean.setData(rs.getString("p.scadenza"));
				pagamenti.add(bean);
				
			}
		
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return pagamenti;
		
	}

	@Override
	public Collection<PagamentoBean> doRetrieveAll(String order) throws SQLException {
		return null;
	}

	
	public void doSave(PagamentoBean item,String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		
      try {
			
			String query = "insert into metodo_pagamento (numero, titolare, circuito, scadenza, CVV) values(?, ?, ?, ?, ?);";
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, item.getNumeroCarta());
			preparedStatement.setString(2, item.getTitolare());
			preparedStatement.setString(3, item.getCircuito());
			preparedStatement.setString(4, item.getData());
			preparedStatement.setString(5, item.getCvv());
			
			preparedStatement.executeUpdate();
			connection.commit();
			try {
				String query1="INSERT INTO utilizzo(username_utente, numero_carta) values (?,?)";
				preparedStatement1=connection.prepareStatement(query1);
				preparedStatement1.setString(1,username);
				preparedStatement1.setString(2, item.getNumeroCarta());
				
				preparedStatement1.executeUpdate();
				connection.commit();
				preparedStatement1.close();
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
      }finally {
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
	public void doUpdate(PagamentoBean item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDelete(String code) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PagamentoBean doRetrieveByKey(String key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(PagamentoBean item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}
