package it.model;

import java.sql.SQLException;
import java.util.Collection;

public interface DataModel<T> {

	public T doRetrieveByKey(String key) throws SQLException;

	public Collection<T> doRetrieveAll(String order) throws SQLException;

	public void doSave(T item) throws SQLException;

	public void doUpdate(T item) throws SQLException;

	public void doDelete(String code) throws SQLException;

}
