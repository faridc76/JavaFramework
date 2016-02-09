package session;

import java.util.List;

import javax.ejb.Local;

import entity.Bonus;

@Local
public interface BonusSessionLocal {

	public void create(Bonus bonus);
	public List<Bonus> getBonuses();
}
