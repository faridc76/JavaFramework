package fr.esigelec.projetStruts.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import fr.esigelec.projetStruts.dao.IPersonneDAO;
import fr.esigelec.projetStruts.dto.Personne;

public class PersonneDAOImpl implements IPersonneDAO {

	@Override
	public void ajouter(Personne p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void supprimer(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Personne p = new Personne();
		p.setId(id);
		session.delete(p);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Personne> getListe() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Personne";
		List<Personne> retour = session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		return retour;
	}

	@Override
	public List<Personne> getFamille(String nom) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Personne WHERE nom = '" + nom + "'";
		List<Personne> retour = session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		return retour;
	}

}
