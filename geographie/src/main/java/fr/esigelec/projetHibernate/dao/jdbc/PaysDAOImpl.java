package fr.esigelec.projetHibernate.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import fr.esigelec.projetHibernate.dao.IPaysDAO;
import fr.esigelec.projetHibernate.dto.Pays;

public class PaysDAOImpl implements IPaysDAO {

	private static Connection con = null;
	
	@Override
	public void ajouter(Pays p) throws SQLException {
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		PreparedStatement ps = null;
		// La requete
		ps = con.prepareStatement(
				"INSERT INTO pays ("
				+ "nom, "
				+ "superficie) VALUES(?, ?)");
		//On ajoute les parametre
		ps.setString(1, p.getNom());
		ps.setFloat(2, p.getSuperficie());
		//On execute la requete
		ps.execute();
		ps.close();
		//on ferme la connexion
		con.close();	
	}

	@Override
	public Pays getPays(int id) throws SQLException {
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		//On recupere la requete
		PreparedStatement ps =  con.prepareStatement("SELECT * FROM pays  WHERE 'id' = ?");
		//On ajoute notre parametre
		ps.setInt(1, id);
		//On execute la requete
		ResultSet rs = ps.executeQuery();
		//On va au resultat
		rs.next();
		//On crée un pays
		Pays p = new Pays();
		//on ajoute les infos au pays
		p.setId(rs.getInt("id"));
		p.setNom(rs.getString("nom"));
		p.setSuperficie(rs.getFloat("superficie"));
		ps.close();
		//On ferme la connexion
		con.close();
		//On retourne le pays
		return p;
	}

	@Override
	public List<Pays> getPays() throws SQLException {
		//On crée une liste de pays
		List<Pays> tousPays = new LinkedList<Pays>();
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		//La requete 'selec'
		PreparedStatement ps =  con.prepareStatement("SELECT * FROM pays");
		//On recupere le resultat
		ResultSet rs = ps.executeQuery();
		//On boucle tant qu'il y a des résultats
		while (rs.next()) {
			// On crée un pays
			Pays p = new Pays();
			//On ajoute les info
			p.setId(rs.getInt("id"));
			p.setNom(rs.getString("nom"));
			p.setSuperficie(rs.getFloat("superficie"));
			//On ajoute le pays a la liste
			tousPays.add(p);
		}
		ps.close();
		//on ferme la connexion
		con.close();
		//On retourne la liste
		return tousPays;
	}

	@Override
	public Pays getPays(String nomPays) throws SQLException {
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		//On recupere la requete
		PreparedStatement ps =  con.prepareStatement("SELECT * FROM pays  WHERE 'nom' = ?");
		//On ajoute notre parametre
		ps.setString(1, nomPays);
		//On execute la requete
		ResultSet rs = ps.executeQuery();
		//On va au resultat
		rs.next();
		//On crée un pays
		Pays p = new Pays();
		//on ajoute les infos au pays
		p.setId(rs.getInt("id"));
		p.setNom(rs.getString("nom"));
		p.setSuperficie(rs.getFloat("superficie"));
		//On ferme
		ps.close();
		con.close();
		//On retourne le pays
		return p;
	}

	@Override
	public void update(Pays p) throws SQLException {
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		//La requete
		PreparedStatement ps =  con.prepareStatement("UPDATE `pays` SET `nom` = ?,`superficie` = ?"
				+ " WHERE `id` = ?");
		//On ajoute notre parametre
		ps.setString(1, p.getNom());
		ps.setFloat(2, p.getSuperficie());
		ps.setInt(3, p.getId());
		//On execute
		ps.execute();
		ps.close();
		//On ferme la connexion
		con.close();
	}

	@Override
	public void delete(Pays p) throws SQLException {
		//On recupere la connexion
		con = ConnexionBDDPool.getInstance().getConnection();
		//La requete
		PreparedStatement ps =  con.prepareStatement("DELETE * FROM pays WHERE 'id' = ?");
		//On ajoute notre parametre
		ps.setInt(1, p.getId());
		//On execute la requete
		ps.execute();
		ps.close();
		//on ferme la connexion
		con.close();
	}

	@Override
	public void refresh(Pays p) throws SQLException {
		//On utilise une fonction que nous possedons déjà
		p = getPays(p.getId());
	}

}
