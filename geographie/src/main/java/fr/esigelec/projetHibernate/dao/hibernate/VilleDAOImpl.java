package fr.esigelec.projetHibernate.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import fr.esigelec.projetHibernate.dao.IVilleDAO;
import fr.esigelec.projetHibernate.dto.Ville;

public class VilleDAOImpl implements IVilleDAO {
	
	/**
	 * ajouter une ville
	 * @param v ville
	 */
	public void ajouter(Ville v) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(v);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Récupération d'une ville avec son id
	 * @param id identifiant de la ville
	 * @return instance ville
	 */
	public Ville getVille(int id) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Ville retour = (Ville) session.get(Ville.class, id);
		session.getTransaction().commit();
		session.close();
		return retour;
	}
	
	/**
	 * Récupération de l'ensemble de villes
	 * @return l'ensemble de villes
	 */
	public List<Ville> getVilles() throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// get pays en utilisant HQL
		String hql = "from Ville";
		@SuppressWarnings("unchecked")
		List<Ville> retour = session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		return retour;
	}
	
	/**
	 * Mise-à-jour d'une ville 
	 * @param v ville
	 */
	public void update(Ville v) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(v);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Suppression d'une ville
	 * @param v ville
	 */
	public void delete(Ville v) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(v);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Refresh d'une ville
	 * @param v
	 */
	public void refresh(Ville v) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.refresh(v);
		session.getTransaction().commit();
		session.close();
	}
}
