package fr.esigelec.garage;

/**
 * 
 * @author m.huang.11, f.chouakria.13
 *
 */
public class Voiture {

	private int id;						// id
	private String immatriculation;		// immatriculation
	private String modele;				// modÃ¨le
	private int anneeConstruction;		// annÃ©e de construction
	private int km;						// km
	
	public Voiture() {
	}
	
	public Voiture(int id, String immatriculation,
			String modele, int anneeConstruction, int km) {
		this.id = id;
		this.immatriculation = immatriculation;
		this.modele = modele;
		this.anneeConstruction = anneeConstruction;
		this.km = km;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", immatriculation=" + immatriculation
				+ ", modele=" + modele + ", anneeConstruction="
				+ anneeConstruction + ", km=" + km + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getAnneeConstruction() {
		return anneeConstruction;
	}

	public void setAnneeConstruction(int anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	public boolean equals(Object o) {
		//Vérification de l'égalité des références
		if (o == this) {
			return true;
		}
		//On test le type du parametre
		if (o instanceof Voiture) {
			Voiture other = (Voiture) o;	
			//On test seulement la plaque d'imatriculation car elle unique
			if (!other.getImmatriculation().equals(this.getImmatriculation())) {
				return false;
			}
			//Si on arrive ici c'est que c'est égal
			return true;
		}
		return false;
	}
	
}
