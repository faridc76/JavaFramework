package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Bonus;

/**
 * Session Bean implementation class BonusSession
 */
@Stateless
public class BonusSession implements BonusSessionLocal {

	@PersistenceContext(unitName="bonus")
	private EntityManager entityManager;
	
    public BonusSession() {
    }
    
    public void create(Bonus bonus) {
    	entityManager.persist(bonus);
    }
    
    @SuppressWarnings("unchecked")
	public List<Bonus> getBonuses() {
    	return entityManager.createQuery("From Bonus").getResultList();
    }
}
