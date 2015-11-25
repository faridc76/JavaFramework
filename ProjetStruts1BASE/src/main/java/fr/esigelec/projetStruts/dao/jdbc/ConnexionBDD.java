package fr.esigelec.projetStruts.dao.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;

public class ConnexionBDD {
	
	
	private static ConnexionBDD instance=null;
	private  Connection connection;
	
	
	private ConnexionBDD(){
		
				
		Properties prop = new Properties();
			
		InputStream in=null;
		try {
			//charge le fichier qui se trouve dans le classpath
			in=this.getClass().getResourceAsStream("/bdd.properties");
		
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		String driver=prop.getProperty("driverClassName");	
		String url= prop.getProperty("url");
		String login=prop.getProperty("username");
		String mdp=prop.getProperty("password"); 
		

	    
	      try {
	      	Class.forName (driver);
	      } catch (ClassNotFoundException e2) {
	         System.out.println("Impossible de charger le pilote de BDD "+e2);
	      }

	        
	      try {

	    
	         connection = DriverManager.getConnection(url,login,mdp);
	      } catch (SQLException eee) {
	         System.out.println("Connexion à la base de données mysql impossible");
	         eee.printStackTrace();
	      }
	      
	      
	      
	      
	}
		
	
	
	public static ConnexionBDD getInstance(){
		if(instance==null)
			instance=new ConnexionBDD();
		return instance;
	}
	
	public  Connection getConnection(){
		return connection;
	}
	
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
