package fr.esigelec.projetStruts.dao;


public class PersonneDAOFactory {
	
	
	public static IPersonneDAO getPersonneDAO(){
		return new fr.esigelec.projetStruts.dao.jdbc.PersonneDAOImpl(); 
	}
	
		
	
}
