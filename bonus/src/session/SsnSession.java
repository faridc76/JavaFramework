package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import entity.Ssn;

/**
 * Session Bean implementation class SsnSession
 */
@Stateless
public class SsnSession implements SsnSessionLocal {

	@PersistenceContext(unitName="bonus")
	private EntityManager entityManager;
    private Logger log = Logger.getLogger(SsnSession.class);
    
    public SsnSession() {
    }

	@Override
	public boolean createSsn(Ssn ssn) {
		boolean canBeCreated = true;
		try {
			entityManager.persist(ssn);
		} catch (Exception e) {
			log.warn("ssn=" + ssn + " cannot be created. It might already exist.");
			canBeCreated = false;
		}
		return canBeCreated;
	}

	@Override
	public Ssn getSsn(String ssn) {
		log.info("getSsn() called");
		Ssn _ssn = null;
    	String HQL = "SELECT s FROM Ssn s WHERE s.ssn = :ssn";
    	Query query = entityManager.createQuery(HQL);
    	query.setParameter("ssn", ssn);
    	try {
    		_ssn = (Ssn) query.getSingleResult();
    	} catch (NoResultException e) {
    		log.warn("No result found for ssn = " + ssn);
    		log.warn(e.getMessage());
    	}
    	return _ssn;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Ssn> getSsns() {
		log.info("getSsns() called");
		return entityManager.createQuery("From Ssn").getResultList();
	}
}
