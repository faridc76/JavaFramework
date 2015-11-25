package fr.esigelec.garage;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import fr.esigelec.garage.HibernateUtil;

/**
 * 
 * @author m.huang.11, f.chouakria.13
 *
 */
public class VoitureDAO {
	
	private static final Logger logger = Logger.getLogger(VoitureDAO.class.getName());

	/**
	 * Ajout d'une nouvelle instance dans la BDD
	 * @param v voiture
	 */
	public void ajouter(Voiture v) {
		logger.debug("Ajout d'une voiture...");
		logger.debug(v);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(v);
		session.getTransaction().commit();
		session.close();
		logger.debug("Ajout est fini.");
	}
	
	/**
	 * Suppression d'une instance existante dans la BDD
	 * @param v voiture
	 */
	public void supprimer(Voiture v) {
		logger.debug("Suppression d'une voiture...");
		logger.debug(v);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(v);
		session.getTransaction().commit();
		session.close();
		logger.debug("Suppression est finie.");
	}
	
	/**
	 * Suppression d'une instance existante dans la BDD par id
	 * @param idVoiture id de voiture
	 */
	public void supprimer(int idVoiture) {
		logger.debug("Suppression d'une voiture (avec idVoiture)...");
		logger.debug("idVoiture=" + idVoiture);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// suppression en utilisant HQL
		String hql = "delete from Voiture where id = :idVoiture";
		logger.debug("hql=" + hql);
		session.createQuery(hql)
		       .setInteger("idVoiture", idVoiture)
		       .executeUpdate();
		session.getTransaction().commit();
		session.close();
		logger.debug("Suppresion est finie.");
	}
	
	/**
	 * Maj la distance roulée par une voiture
	 * @param v voiture
	 * @param distance la distance supplémentaire
	 */
	public void rouler(Voiture v, int distance) {
		logger.debug("Maj la distance roulée...");
		logger.debug(v);
		logger.debug("distance=" + distance);
		int km = v.getKm() + distance;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// maj en utilisant HQL
		String hql = "update Voiture set km = :km where id = :id";
		logger.debug("hql=" + hql);
		session.createQuery(hql)                // créer la requête
		       .setInteger("km", km)            // set la nouvelle distance
		       .setInteger("id", v.getId())     // set id
		       .executeUpdate();                // exécuter
		session.getTransaction().commit();
		session.close();
		logger.debug("Maj est finie.");
	}
	
	/**
	 * Recuperation d'une instance existante dans la BDD
	 * @param idVoiture id de voiture
	 * @return une instance de voiture
	 */
	public Voiture get(int idVoiture) {
		logger.debug("Recuperation d'une voiture avec idVoiture=" + idVoiture + "...");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Voiture retour = (Voiture) session.get(Voiture.class, idVoiture);
		session.getTransaction().commit();
		session.close();
		logger.debug("Recuperation est finie.");
		logger.debug("v=" + retour);
		return retour;
	}

	/**
	 * Recuperation de l'ensemble de voitures existante dans la BDD
	 * @return liste de voitures
	 */
	@SuppressWarnings("unchecked")
	public List<Voiture> getVoitures() {
		logger.debug("Recuperation de l'ensemble de voitures existante...");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// get voitures en utilisant HQL
		String hql = "from Voiture";
		logger.debug("hql=" + hql);
		List<Voiture> retour = session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		logger.debug("Recuperation est finie");
		return retour;
	}
}
