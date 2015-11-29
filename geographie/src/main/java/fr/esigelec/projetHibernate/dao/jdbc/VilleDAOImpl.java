package fr.esigelec.projetHibernate.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fr.esigelec.projetHibernate.dao.IVilleDAO;
import fr.esigelec.projetHibernate.dto.Pays;
import fr.esigelec.projetHibernate.dto.Ville;

public class VilleDAOImpl implements IVilleDAO {
	
	private static Connection con = null;

	@Override
	public void ajouter(Ville v) throws SQLException {
		//On recupere la connextion
		con = ConnexionBDDPool.getInstance().getConnection();
		PreparedStatement ps = null;
		// La requete
		ps = con.prepareStatement(
				"INSERT INTO ville ("
				+ "nom, "
				+ "nb_habitants,"
				+ "id_pays)"
				+ " VALUES(?, ?, ?)",  Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, v.getNom());
		ps.setInt(2,v.getNbHabitants());
		ps.setInt(3,v.getPays().getId());
		//On execute la requete
		ps.execute();
		//On recupere l'id généré
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.first()) {
			// on récupère l'id généré
			//On l'ajoute au pays
			v.setId(rs.getInt(1));
		}
		ps.close();
		//On ferme la connexion
		con.close();

	}

	@Override
	public Ville getVille(int id) throws SQLException {
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		//On recupere la requete
		PreparedStatement ps =  con.prepareStatement("SELECT * FROM ville  WHERE `id` = ?");
		//On ajoute notre parametre
		ps.setInt(1, id);
		//On execute la requete
		ResultSet rs = ps.executeQuery();
		//On va au resultat
		rs.next();
		//On crée une ville
		Ville v = new Ville();
		//on ajoute les infos a la ville
		v.setId(rs.getInt("id"));
		v.setNom(rs.getString("nom"));
		v.setNbHabitants(rs.getInt("nb_habitants"));
		//On récupere l'id du pays
		int idPays = rs.getInt("id_pays");
		//On crée un objet dao pays
		PaysDAOImpl dao = new PaysDAOImpl();
		//On recupere le pays lié à la ville
		Pays p = dao.getPays(idPays);
		//On ajoute le pays à la ville
		v.setPays(p);
		ps.close();
		//On ferme la connexion
		con.close();
		//On retourne 
		return v;
	}

	@Override
	public List<Ville> getVilles() throws SQLException {
		PaysDAOImpl dao = new PaysDAOImpl();
		Ville v = null;
		List<Ville> toutesVilles = new LinkedList<Ville>();
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		//On recupere la requete
		PreparedStatement ps =  con.prepareStatement("SELECT * FROM ville");
		//On execute la requete
		ResultSet rs = ps.executeQuery();
		//On va au resultat
		while(rs.next()) {
			//On crée une ville
			v = new Ville();
			//on ajoute les infos au pays
			v.setId(rs.getInt("id"));
			v.setNom(rs.getString("nom"));
			v.setNbHabitants(rs.getInt("nb_habitants"));
			int idPays = rs.getInt("id_pays");
			//On recupere le pays lié à la ville
			
			Pays p = dao.getPays(idPays);
			System.out.println(p);
			//on ajoute le pays a la ville
			v.setPays(p);
			//on ajoute la ville à la liste
			toutesVilles.add(v);
		}
		ps.close();
		con.close();
		return toutesVilles;
	}

	@Override
	public void update(Ville v) throws SQLException {
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		//la requete sql à executer 
		PreparedStatement ps =  con.prepareStatement("UPDATE `ville` SET `nom` = ?,`nb_habitants` = ?,"
				+ "`id_pays` = ? WHERE `id` = ?");
		//On ajoute notre parametre
		ps.setString(1, v.getNom());
		ps.setInt(2, v.getNbHabitants());
		ps.setInt(3, v.getPays().getId());
		ps.setInt(4, v.getId());
		//On execute la requete
		ps.execute();
		ps.close();
		//on ferme la connexion
		con.close();
	}

	@Override
	public void delete(Ville v) throws SQLException {
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		//La requete
		PreparedStatement ps =  con.prepareStatement("DELETE FROM ville WHERE `id` = ?");
		//On ajoute notre parametre
		ps.setInt(1, v.getId());
		//On execute la requete
		ps.execute();
		ps.close();
		//On ferme la connexion
		con.close();	
	}

	@Override
	public void refresh(Ville v) throws SQLException {
		v = getVille(v.getId());
	}

}
