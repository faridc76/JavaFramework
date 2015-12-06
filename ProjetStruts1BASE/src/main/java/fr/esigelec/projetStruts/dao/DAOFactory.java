package fr.esigelec.projetStruts.dao;


public abstract class DAOFactory {
	
	public static final int HIBERNATE = 1;
	public static final int JDBC = 2;
	
	public abstract IPersonneDAO getPersonneDAO();
	
	public static DAOFactory getDAOFactory(int type){
		switch(type){
		case HIBERNATE : 
			return new HibernateFactory();
		case JDBC : 
			return new JDBCFactory();
		default :
			return new JDBCFactory();
		}
	}
}
