package fr.esigelec.projetHibernate.dao;

import java.sql.SQLException;
import java.util.List;

import fr.esigelec.projetHibernate.dto.Ville;

public interface IVilleDAO {
	public void ajouter(Ville v) throws SQLException;
	public Ville getVille(int id) throws SQLException;
	public List<Ville> getVilles()throws SQLException;
	public void update(Ville v) throws SQLException;
	public void delete(Ville v) throws SQLException;
	public void refresh(Ville v) throws SQLException;
}
