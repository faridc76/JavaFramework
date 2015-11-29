package fr.esigelec.projetHibernate.dao;

import fr.esigelec.projetHibernate.dao.jdbc.*;

public class HibernateFactory extends DAOFactory {

	@Override
	public IPaysDAO getPaysDAO() {
		return new PaysDAOImpl();
	}

	@Override
	public IVilleDAO getVilleDAO() {
		return new VilleDAOImpl();
	}

}
