package fr.esigelec.projetHibernate.dto;

public class Pays {

	private int id;
	private String nom;
	private float superficie;
	
	public Pays() {}
	
	public Pays(int id, String nom, float superficie) {
		this.id = id;
		this.nom = nom;
		this.superficie = superficie;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public float getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "Pays [id=" + id + ", nom=" + nom + ", superficie=" + superficie
				+ "]";
	}
}
