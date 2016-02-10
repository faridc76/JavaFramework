package entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ssn database table.
 * 
 */
@Entity
@NamedQuery(name="Ssn.findAll", query="SELECT s FROM Ssn s")
public class Ssn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ssn;

	//bi-directional many-to-one association to MultipleBonus2
	@OneToMany(mappedBy="ssn", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<MultipleBonus> multipleBonuses;

	public Ssn() {
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<MultipleBonus> getMultipleBonuses() {
		return this.multipleBonuses;
	}

	public void setMultipleBonuses(List<MultipleBonus> multipleBonuses) {
		this.multipleBonuses = multipleBonuses;
	}

	public MultipleBonus addMultipleBonus(MultipleBonus multipleBonus) {
		getMultipleBonuses().add(multipleBonus);
		multipleBonus.setSsn(this);

		return multipleBonus;
	}

	public MultipleBonus removeMultipleBonus(MultipleBonus multipleBonus) {
		getMultipleBonuses().remove(multipleBonus);
		multipleBonus.setSsn(null);

		return multipleBonus;
	}

}