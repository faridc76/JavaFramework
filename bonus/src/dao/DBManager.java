package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	private static Connection connect;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bonus";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	private DBManager() {
	}
	
	private static void initConnexion(String driver, String url, String login,
			String password) throws SQLException {
		
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection(url, login, password);
			connect.setAutoCommit(false);
			System.out.println("Connexion reussie");
		
		} catch (ClassNotFoundException e) {
			System.out.println("erreur chargement pilote JDBC");
			System.exit(0);
		
		} catch (SQLException e) {
			System.out.println("erreur connexion base de données");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public static Connection getConnect() throws SQLException {
		if (!(connect instanceof Connection)) {
			initConnexion(DRIVER, URL, USER, PASS);
		}
		return connect;
	}
}