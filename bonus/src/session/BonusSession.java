package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import entity.Bonus;

/**
 * Session Bean implementation class BonusSession
 */
@Stateless
public class BonusSession implements BonusSessionLocal {

	private Logger log = Logger.getLogger(BonusSession.class);
	@PersistenceContext(unitName="bonus")
	private EntityManager entityManager;
	
    public BonusSession() {
    }
    
    @Override
    public void create(Bonus bonus) {
    	entityManager.persist(bonus);
    }
    
    @Override
    public Bonus getBonus(String ssn) {
    	Bonus bonus = null;
    	String HQL = "SELECT b FROM Bonus b WHERE b.ssn = :ssn";
    	Query query = entityManager.createQuery(HQL);
    	query.setParameter("ssn", ssn);
    	try {
    		bonus = (Bonus) query.getSingleResult();
    	} catch (NoResultException e) {
    		log.warn("No result found for ssn = " + ssn);
    		log.warn(e.getMessage());
    	}
    	return bonus;
    }
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Bonus> getBonuses() {
    	return entityManager.createQuery("From Bonus").getResultList();
    }
}
