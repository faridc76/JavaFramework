package fr.esigelec.projetHibernate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import fr.esigelec.projetHibernate.dao.IPaysDAO;
import fr.esigelec.projetHibernate.dao.hibernate.HibernateUtil;
import fr.esigelec.projetHibernate.dto.Pays;

/**
 * 
 * @author m.huang.11, f.chouakria.13
 *
 */
public class PaysDAOImpl implements IPaysDAO {

	/**
	 * Ajouter un pays
	 * @param p pays
	 */
	public void ajouter(Pays p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Récupération d'un pays avec son id
	 * @param id id du pays
	 * @return instance pays
	 */
	public Pays getPays(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Pays retour = (Pays) session.get(Pays.class, id);
		session.getTransaction().commit();
		session.close();
		return retour;
	}
	
	/**
	 * Récupération de l'ensemble de pays
	 * @return tous pays
	 */
	public List<Pays> getPays() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// get pays en utilisant HQL
		String hql = "from Pays";
		@SuppressWarnings("unchecked")
		List<Pays> retour = session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		return retour;
	}
	
	/**
	 * Récupératio d'un pays avec son nom
	 * @param nomPays nom du pays
	 * @return instance pays
	 */
	public Pays getPays(String nomPays) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// get pays en utilisant HQL
		String hql = "from Pays where nom = :nomPays";
		Pays retour = (Pays) session.createQuery(hql)                // créer la requête
		                            .setString("nomPays", nomPays)   // set le nom du pays
		                            .uniqueResult();                 // exécuter
		session.getTransaction().commit();
		session.close();
		return retour;
	}
	
	/**
	 * Mise-à-jour d'un pays
	 * @param p pays
	 */
	public void update(Pays p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Suppression d'un pays
	 * @param p
	 */
	public void delete(Pays p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Refresh d'un pays
	 * @param p pays
	 */
	public void refresh(Pays p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.refresh(p);
		session.getTransaction().commit();
		session.close();
	}
	
}
