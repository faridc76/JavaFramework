package session;

import java.util.List;

import javax.ejb.Local;

import entity.Ssn;

@Local
public interface SsnSessionLocal {

	public boolean createSsn(Ssn ssn);
	public Ssn getSsn(String ssn);
	public List<Ssn> getSsns();
}
