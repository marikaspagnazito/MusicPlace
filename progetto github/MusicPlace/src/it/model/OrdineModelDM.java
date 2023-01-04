package it.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;

import it.unisa.DriverManagerConnectionPool;
import it.model.DataModel;
import it.model.OrdineBean;

public class OrdineModelDM implements DataModel<OrdineBean> {
	
   public int nextId() throws SQLException {
		
		ArrayList<OrdineBean> orders = (ArrayList<OrdineBean>) this.doRetrieveAll("");
		if(orders.size()==0)
			return 1;
		int next = (orders.get(orders.size()-1).getNumeroOrdine())+1;
		
		return next;

	}
	
	public OrdineBean doRetrieveByKey(String key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String querySQL = "SELECT * FROM ordine WHERE Numero_Ordine = ? ";
		
		OrdineBean ordine = new OrdineBean();
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(querySQL);
			preparedStatement.setInt(0, Integer.parseInt(key));
			
			System.out.println("doRetrieveByKey: " + preparedStatement);
			rs=preparedStatement.executeQuery();
			
			if(rs.next()) {
			    ordine.setNumeroOrdine(rs.getInt("numeroOrdine"));
			    ordine.setUserName(rs.getString("username"));
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate("data_ordine"));
				ordine.setData(calendar);
				ordine.setIVA(rs.getDouble("IVA"));
				ordine.setNumeroCarta(rs.getString("numero_carta"));
				ordine.setPrezzo(rs.getDouble("somma_pagata"));
				
			}
			
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return ordine;
		
	}
	
	public Collection<OrdineBean> doRetrieveByUsername(String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String querySQL = "SELECT * FROM ordine WHERE username = ? ORDER BY username";
		
		Collection<OrdineBean> ordini = new LinkedList<OrdineBean>();
		
		try {
			
			connection= DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(querySQL);
			preparedStatement.setString(1, username);
			
			System.out.println("doRetrieveAllByUsername: " + preparedStatement);
			rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				OrdineBean item = new OrdineBean();
				item.setNumeroOrdine(rs.getInt("Numero_Ordine"));
				item.setUserName(rs.getString("username"));
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate("data_ordine"));
				item.setData(calendar);
				item.setIVA(rs.getDouble("IVA"));
				item.setNumeroCarta(rs.getString("numero_carta"));
				item.setPrezzo(rs.getDouble("somma_pagata"));
				
				ordini.add(item);
			}
			
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return ordini;
	}
	
	public Collection<OrdineBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "SELECT a.Numero_Ordine,a.data_ordine,a.somma_pagata,a.IVA, a.numero_carta,a.username "
				+ " FROM ordine a";
		
		if (order != null && !order.equals("")) {
			querySQL += " ORDER BY " + order;
		}
		
		Collection<OrdineBean> ordini = new ArrayList<OrdineBean>();
		
		try {
			
			connection= DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(querySQL);
			
			System.out.println("doRetrieveAll: " + preparedStatement);
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				OrdineBean item = new OrdineBean();
				item.setNumeroOrdine(rs.getInt("a.Numero_Ordine"));
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate("a.data_ordine"));
				item.setData(calendar);
				item.setPrezzo(rs.getDouble("a.somma_pagata"));
				item.setIVA(rs.getDouble("a.IVA"));
				item.setNumeroCarta(rs.getString("a.numero_carta"));
				item.setUserName(rs.getString("a.username"));
				
				ordini.add(item);
			}
			
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return ordini;
	}

	@Override
	public void doSave(OrdineBean item) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement codice = null;
		ResultSet rs = null;
		
		String query="INSERT INTO ordine (Numero_Ordine, data_ordine, somma_pagata, IVA, numero_carta, username)"
				     +"VALUES (?,?,?,?,?,?)";
		
		try {
			connection= DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,item.getNumeroOrdine());
			Date date = new Date(item.getData().getTimeInMillis());
			preparedStatement.setDate(2,date);
			preparedStatement.setDouble(3,item.getPrezzo());
			preparedStatement.setDouble(4,item.getIVA());
			preparedStatement.setString(5,item.getNumeroCarta());
			preparedStatement.setString(6,item.getUserName());
			
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
	public void doUpdate(OrdineBean item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDelete(String code) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	

}
