package session;

import java.util.List;

import javax.ejb.Local;

import entity.MultipleBonus;
import entity.Ssn;

@Local
public interface MultipleBonusSessionLocal {

	public void create(MultipleBonus multipleBonus);
	public List<MultipleBonus> getMultilpleBonuses();
	public MultipleBonus getMultipleBonus(Ssn ssn);
}
