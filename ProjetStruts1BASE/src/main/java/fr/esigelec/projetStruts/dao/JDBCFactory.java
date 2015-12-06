package fr.esigelec.projetStruts.dao;

import fr.esigelec.projetStruts.dao.jdbc.PersonneDAOImpl;

public class JDBCFactory extends DAOFactory {
	
	public IPersonneDAO getPersonneDAO(){
		return new PersonneDAOImpl(); 
	}	
}
