package it.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;

import it.unisa.DriverManagerConnectionPool;

public class OrdineDettaglioModelDM  implements DataModel<OrdineDettaglioBean>  {

	@Override
	public OrdineDettaglioBean doRetrieveByKey(String key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String querySQL = "SELECT * FROM dettaglioOrdine WHERE ID= ? ";
		
		OrdineDettaglioBean ordine = new OrdineDettaglioBean();
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(querySQL);
			preparedStatement.setInt(0,Integer.parseInt(key));
			
			System.out.println("doRetrieveByKey: " + preparedStatement);
			rs=preparedStatement.executeQuery();
			
			if(rs.next()) {
			    ordine.setId(rs.getInt("ID"));
			    ordine.setIdOrdine(rs.getInt("ID_ordine"));
				ordine.setTitolo(rs.getString("titolo"));
				ordine.setPrezzo(rs.getDouble("prezzo"));
				ordine.setIVA(rs.getDouble("IVA"));
				
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

	public Collection<OrdineDettaglioBean> doRetrieveAllByOrder(int nOrder) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String querySQL = "SELECT * FROM dettaglioOrdine WHERE ID_ordine= "+nOrder;
		
		Collection<OrdineDettaglioBean> ordini = new LinkedList<OrdineDettaglioBean>();
		
		try {
			
			connection= DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(querySQL);
			
			System.out.println("doRetrieveAllByOrder: " + preparedStatement);
			rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				OrdineDettaglioBean item = new OrdineDettaglioBean();
				    item.setId(rs.getInt("ID"));
				    item.setIdOrdine(rs.getInt("ID_ordine"));
					item.setTitolo(rs.getString("titolo"));
					item.setPrezzo(rs.getDouble("prezzo"));
					item.setIVA(rs.getDouble("IVA"));
					item.setIdAlbum(rs.getInt("ID_album"));
					item.setIdBrano(rs.getInt("ID_brano"));
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
	public void doSave(OrdineDettaglioBean item) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement codice = null;
		ResultSet rs = null;
		
		String query="INSERT INTO dettaglioOrdine (ID, ID_ordine, titolo, prezzo,IVA, ID_album, ID_brano)"
				     +"VALUES (?,?,?,?,?,?,?)";
		
		try {
			connection= DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,item.getId());
			preparedStatement.setInt(2,item.getIdOrdine());
			preparedStatement.setString(3,item.getTitolo());
			preparedStatement.setDouble(4,item.getPrezzo());
			preparedStatement.setDouble(5,item.getIVA());
			preparedStatement.setInt(6, item.getIdAlbum());
			preparedStatement.setInt(7,item.getIdBrano());
			
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
	public void doUpdate(OrdineDettaglioBean item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDelete(String code) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<OrdineDettaglioBean> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}