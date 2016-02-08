package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.jboss.logging.Logger;

public abstract class AbstractDAO<T, T1> {

	private Connection connect = null;
	private Logger log = Logger.getLogger(AbstractDAO.class.getName());
	
	public AbstractDAO() {
		try {
			this.setConnect(DBManager.getConnect());
		} catch (SQLException e) {
			log.error(e.getStackTrace());
		}
	}
	
	public abstract boolean create(T obj);
	public abstract boolean delete(T obj);
	public abstract boolean update(T obj);
	public abstract T find(T1 id);

	public Connection getConnect() {
		return connect;
	}
	
	public void setConnect(Connection connect) {
		this.connect = connect;
	}
}
