package fr.esigelec.projetHibernate;

import java.util.List;

import fr.esigelec.projetHibernate.dao.IPaysDAO;
import fr.esigelec.projetHibernate.dao.IVilleDAO;
import fr.esigelec.projetHibernate.dao.hibernate.PaysDAOImpl;
import fr.esigelec.projetHibernate.dao.hibernate.VilleDAOImpl;
import fr.esigelec.projetHibernate.dto.Pays;
import fr.esigelec.projetHibernate.dto.Ville;

/**
 * 
 * @author m.huang.11, f.chouakria.13
 *
 */
public class Main {

	public static void main(String[] args) {
		
		ex6_crud();
		//ex6_cascade("none");
		//ex6_cascade("all");
		ex6_null();

	}
	
	private static void ex6_crud() {
		
		Pays france = new Pays(0, "France", 675000);
		Ville rouen = new Ville(0, "Rouen", 106560, france);
		System.out.println(france);
		System.out.println(rouen);
		
		// Implementation Hibernate
		// Les opérations CRUD :
		// Create/Read/Update/Delete
		System.out.println("Opérations avec Hibernate");
		IPaysDAO paysHbmDao = new PaysDAOImpl();        // impl hibernate
		IVilleDAO villeHbmDao = new VilleDAOImpl();     // impl hibernate
		List<Pays> pays;
		List<Ville> villes;
		
		// Create
		System.out.println("-----CREATE-----");
		paysHbmDao.ajouter(france);
		villeHbmDao.ajouter(rouen);
		
		// Read
		System.out.println("-----READ-----");
		pays = paysHbmDao.getPays();
		villes = villeHbmDao.getVilles();
		for(Pays p : pays)
			System.out.println(p);
		for(Ville v : villes)
			System.out.println(v);
		
		// Update
		System.out.println("-----UPDATE-----");
		Pays france2016 = paysHbmDao.getPays("France");
		float superficie = france2016.getSuperficie();
		france2016.setSuperficie(superficie + 1);
		paysHbmDao.update(france2016);
		
		// Read
		System.out.println("-----READ-----");
		pays = paysHbmDao.getPays();
		villes = villeHbmDao.getVilles();
		for(Pays p : pays)
			System.out.println(p);
		for(Ville v : villes)
			System.out.println(v);
		
		// Delete
		System.out.println("-----DELETE-----");
		paysHbmDao.delete(france2016);
		
		// Read
		System.out.println("-----READ-----");
		pays = paysHbmDao.getPays();
		villes = villeHbmDao.getVilles();
		for(Pays p : pays)
			System.out.println(p);
		for(Ville v : villes)
			System.out.println(v);
		
	}
	
	private static void ex6_cascade(String mode) {
		System.out.println("Cascade avec Hibernate");
		IVilleDAO villeHbmDao = new VilleDAOImpl();     // impl hibernate
		IPaysDAO paysHbmDao = new PaysDAOImpl();        // impl hibernate
		List<Ville> villes;
		switch(mode) {
			case "all":
				System.out.println("-----cascade='all'-----");
				// ajout
				Pays chine = new Pays(0, "中国 - Chine", 9641144);
				Ville pekin = new Ville(0, "北京 - Pékin", 20000000, chine);
				villeHbmDao.ajouter(pekin);
				// lecture
				villes = villeHbmDao.getVilles();
				for(Ville v : villes)
					System.out.println(v);
				break;
			case "none":
				System.out.println("-----cascade='none'-----");
				// ajout
				Pays algerie = new Pays(0, "الدزاير - Algérie", 2381741);
				Ville alger = new Ville(0, "الدزاير - Alger", 20000000, algerie);
				paysHbmDao.ajouter(algerie);
				villeHbmDao.ajouter(alger);
				// lecture
				villes = villeHbmDao.getVilles();
				for(Ville v : villes)
					System.out.println(v);
				break;
		}
	}
	
	private static void ex6_null() {
		System.out.println("Ville sans pays");
		IVilleDAO villeHbmDao = new VilleDAOImpl();     // impl hibernate
		Ville paris = new Ville(0, "Paris", 2241346, null);
		villeHbmDao.ajouter(paris);
	}
}
