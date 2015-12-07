
package fr.esigelec.projetStruts.dao;

import java.sql.SQLException;
import java.util.List;

import fr.esigelec.projetStruts.dto.Personne;

public interface IPersonneDAO {
	

	public void ajouter(Personne p) throws SQLException;
	
	public void supprimer(int id) throws SQLException;
	
	public List<Personne> getListe() throws SQLException;

	public List<Personne> getFamille(String nom) throws SQLException;

}
