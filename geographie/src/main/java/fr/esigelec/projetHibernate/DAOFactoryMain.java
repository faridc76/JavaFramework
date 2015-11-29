package fr.esigelec.projetHibernate;

import java.sql.SQLException;
import java.util.List;

import fr.esigelec.projetHibernate.dao.DAOFactory;
import fr.esigelec.projetHibernate.dto.Pays;
import fr.esigelec.projetHibernate.dto.Ville;

public class DAOFactoryMain {

	public static void main(String[] args) throws SQLException {
		
		DAOFactory hibernate = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);
		DAOFactory jdbc = DAOFactory.getDAOFactory(DAOFactory.JDBC);
		
		Pays france = new Pays(0, "France", 675000);
		Ville rouen = new Ville(0, "Rouen", 106560, france);
		Ville toulouse = new Ville(0, "Toulouse", 441802, france);
		Ville lyon = new Ville(0, "Lyon", 484344, france);
		
		System.out.println("-----CREATE:Hibernate-----");
		hibernate.getPaysDAO().ajouter(france);
		System.out.println(france);
		hibernate.getVilleDAO().ajouter(rouen);
		System.out.println(rouen);
		hibernate.getVilleDAO().ajouter(toulouse);
		System.out.println(toulouse);
		hibernate.getVilleDAO().ajouter(lyon);
		System.out.println(lyon);
		
		System.out.println("-----READ:JDBC-----");
		Pays pays = jdbc.getPaysDAO().getPays(france.getId());
		System.out.println(pays);
		List<Ville> villes = jdbc.getVilleDAO().getVilles();
		for(Ville v : villes) {
			if (pays.getId() == v.getPays().getId()) {
				System.out.println(v);
			}
		}
		
		System.out.println("-----ADD:JDBC-----");
		Ville paris = new Ville(0, "Paris", 2244000, france);
		jdbc.getVilleDAO().ajouter(paris);
		System.out.println(paris);
		
		System.out.println("-----DELETE:HIBERNATE-----");
		hibernate.getPaysDAO().delete(france);
			
	}

}
