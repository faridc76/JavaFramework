package fr.esigelec.projetStruts.dao;

import fr.esigelec.projetStruts.dao.hibernate.PersonneDAOImpl;

public class HibernateFactory extends DAOFactory {
	
	public IPersonneDAO getPersonneDAO(){
		return new PersonneDAOImpl(); 
	}	

}
