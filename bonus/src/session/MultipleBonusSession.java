package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import entity.MultipleBonus;
import entity.Ssn;

/**
 * Session Bean implementation class MultipleBonusSession
 */
@Stateless
public class MultipleBonusSession implements MultipleBonusSessionLocal {

	@PersistenceContext(unitName="bonus")
	private EntityManager entityManager;
	
	private Logger log = Logger.getLogger(MultipleBonusSession.class);
	
    public MultipleBonusSession() {
        log.debug("MultipleBonusSession() called");
    }

	@Override
	public void create(MultipleBonus multipleBonus) {
		log.info("create() called");
		entityManager.persist(multipleBonus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MultipleBonus> getMultilpleBonuses() {
		log.info("getMultilpleBonuses() called");
		return entityManager.createQuery("From MultipleBonus").getResultList();
	}

	@Override
	public MultipleBonus getMultipleBonus(Ssn ssn) {
		log.info("getMultipleBonus() called");
		MultipleBonus multipleBonus = null;
    	String HQL = "SELECT m FROM MultipleBonus m WHERE m.Ssn.ssn = :ssn";
    	Query query = entityManager.createQuery(HQL);
    	query.setParameter("ssn", ssn);
    	try {
    		multipleBonus = (MultipleBonus) query.getSingleResult();
    	} catch (NoResultException e) {
    		log.warn("No result found for ssn = " + ssn);
    		log.warn(e.getMessage());
    	}
    	return multipleBonus;
	}
}
