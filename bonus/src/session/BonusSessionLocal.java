package session;

import java.util.List;

import javax.ejb.Local;

import entity.Bonus;
import entity.Ssn;

@Local
public interface BonusSessionLocal {

	public void create(Bonus bonus);
	public List<Bonus> getBonuses();
	public Bonus getBonus(String ssn);
}
