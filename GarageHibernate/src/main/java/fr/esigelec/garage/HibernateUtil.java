package fr.esigelec.garage;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 
 * @author m.huang.11, f.chouakria.13
 *
 */
public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		// La SessionFactory est initialisée une seule fois pour toute l'application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configuration à partir du fichier hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry)
				.buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);	
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}