package fr.esigelec.projetStruts.dao.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import fr.esigelec.projetStruts.dao.IPersonneDAO;
import fr.esigelec.projetStruts.dto.Personne;

public class PersonneDAOImpl implements IPersonneDAO {

	
	/**
	 * Ajoute une personne dans la BDD
	 * @param p la personne à ajouter
	 */
	@Override
	public void ajouter(Personne p) {
		PreparedStatement stmt=null;
		Connection con=ConnexionBDDPool.getInstance().getConnection();
		try {
			stmt=con.prepareStatement("INSERT INTO personne (nom,prenom) VALUES (?,?)");
			stmt.setString(1,p.getNom());
			stmt.setString(2,p.getPrenom());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			ConnexionBDDPool.close(stmt);
		}
	}

	/**
	 * Récupère la liste des personne de la BDD
	 * @return la liste des personnes
	 */
	@Override
	public List<Personne> getListe() {
		List<Personne> retour=new ArrayList<Personne>();
		PreparedStatement stmt=null;
		Connection con=ConnexionBDDPool.getInstance().getConnection();
		try {
			stmt=con.prepareStatement("SELECT * FROM  personne");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				retour.add(new Personne(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnexionBDDPool.close(stmt);
		}
		return retour;
	}


	/**
	 * Supprime une personne de la BDD à partir de son id
	 * @param id id de la personne à supprimer
	 */
	@Override
	public void supprimer(int id) {
		PreparedStatement stmt=null;
		Connection con=ConnexionBDDPool.getInstance().getConnection();
		try {
			stmt=con.prepareStatement("DELETE FROM personne WHERE id=?");
			stmt.setInt(1,id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnexionBDDPool.close(stmt);
		}
		
	}

	

}
