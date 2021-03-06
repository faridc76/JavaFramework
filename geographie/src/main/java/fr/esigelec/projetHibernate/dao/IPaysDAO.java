package fr.esigelec.projetHibernate.dao;

import java.sql.SQLException;
import java.util.List;

import fr.esigelec.projetHibernate.dto.Pays;

public interface IPaysDAO {
	public void ajouter(Pays p) throws SQLException;
	public Pays getPays(int id) throws SQLException;
	public List<Pays> getPays() throws SQLException;
	public Pays getPays(String nomPays) throws SQLException;
	public void update(Pays p) throws SQLException;
	public void delete(Pays p) throws SQLException;
	public void refresh(Pays p) throws SQLException;
}
