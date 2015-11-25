
package fr.esigelec.projetStruts.dao;

import java.util.List;

import fr.esigelec.projetStruts.dto.Personne;

public interface IPersonneDAO {
	

	public void ajouter(Personne p);
	
	public void supprimer(int id);
	
	public List<Personne> getListe();

}
