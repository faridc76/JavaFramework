package fr.esigelec.projetHibernate.dao;

public abstract class DAOFactory {
	
	public static final int HIBERNATE = 1;
	public static final int JDBC = 2;
	
	public abstract IPaysDAO getPaysDAO();
	public abstract IVilleDAO getVilleDAO();
	
	public static DAOFactory getDAOFactory(int type){
		switch(type){
		case HIBERNATE : 
			return new HibernateFactory();
		case JDBC : 
			return new JDBCFactory();
		default :
			return new HibernateFactory();
		}
	}
}
