package fr.esigelec.projetHibernate.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;

import fr.esigelec.projetHibernate.dao.IPaysDAO;
import fr.esigelec.projetHibernate.dto.Pays;

public class PaysDAOImpl implements IPaysDAO {

	private static Connection con = null;
	
	@Override
	public void ajouter(Pays p) throws ClassNotFoundException, SQLException, NamingException {
		con = ConnexionBDDPool.getInstance().getConnection();
		PreparedStatement ps = null;
		// insertion in database MySQL
		ps = con.prepareStatement(
				"INSERT INTO project ("
				+ "nom, "
				+ "superficie) VALUES(?, ?)");
		ps.setString(1, p.getNom());
		ps.setFloat(2, p.getSuperficie());
		ps.execute();
		ps.close();
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
		p.setId(rs.getInt("nom"));
		p.setNom(rs.getString("nom"));
		p.setSuperficie(rs.getFloat("superficie"));
		ps.close();
		con.close();
		return p;
	}

	@Override
	public List<Pays> getPays() throws ClassNotFoundException, SQLException, NamingException {
		List<Pays> tousPays = new LinkedList<Pays>();
		con = ConnexionBDDPool.getInstance().getConnection();
		PreparedStatement ps =  con.prepareStatement("SELECT * FROM pays");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Pays p = new Pays();
			p.setId(rs.getInt("id"));
			p.setNom(rs.getString("nom"));
			p.setSuperficie(rs.getFloat("superficie"));
			tousPays.add(p);
		}
		ps.close();
		//on ferme la connexion
		con.close();
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
		p.setId(rs.getInt("nom"));
		p.setNom(rs.getString("nom"));
		p.setSuperficie(rs.getFloat("superficie"));
		//On ferme
		ps.close();
		con.close();
		return p;
	}

	@Override
	public void update(Pays p) throws SQLException {
		con = ConnexionBDDPool.getInstance().getConnection();
		PreparedStatement ps =  con.prepareStatement("UPDATE `pays` SET `nom` = ?,`superficie` = ? WHERE `id` = ?");
		//On ajoute notre parametre
		ps.setString(1, p.getNom());
		ps.setFloat(2, p.getSuperficie());
		ps.setInt(3, p.getId());
		ps.execute();
		ps.close();
		con.close();
	}

	@Override
	public void delete(Pays p) throws SQLException {
		con = ConnexionBDDPool.getInstance().getConnection();
		PreparedStatement ps =  con.prepareStatement("DELETE * FROM pays WHERE 'id' = ?");
		//On ajoute notre parametre
		ps.setInt(1, p.getId());
		ps.execute();
		ps.close();
		con.close();	}

	@Override
	public void refresh(Pays p) throws SQLException {
		getPays(p.getId());
	}

}
