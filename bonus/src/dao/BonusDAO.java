package dao;

import model.Bonus;

public class BonusDAO extends AbstractDAO<Bonus, String> {
	
	@Override
	public boolean delete(Bonus bonus) {
		return false;
	}
	
	@Override
	public boolean update(Bonus bonus) {
		return false;
	}
	
	@Override
	public Bonus find(String id) {
		Bonus bonus = null;
		return bonus;
	}
	
	public static BonusDAO getInstance() {
		BonusDAO instance = null;
		if (null == instance) { // first call 
			instance = new BonusDAO();
		}
		return (BonusDAO) instance;
	}
	
	@Override
	public boolean create(Bonus obj) {
		return false;
	}
}
