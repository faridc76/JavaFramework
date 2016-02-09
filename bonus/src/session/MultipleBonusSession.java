package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        log.info("MultipleBonusSession called");
    }

	@Override
	public void create(MultipleBonus multipleBonus) {
		log.info("create called");
		entityManager.persist(multipleBonus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MultipleBonus> getMultilpleBonuses() {
		log.info("getMultilpleBonuses called");
		return entityManager.createQuery("From MultipleBonus").getResultList();
	}

	@Override
	public MultipleBonus getMultipleBonus(Ssn ssn) {
		log.info("getMultipleBonus");
		return null;
	}

}
