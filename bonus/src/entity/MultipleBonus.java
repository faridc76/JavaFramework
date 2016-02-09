package entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * TP15 The persistent class for the multiple_bonus database table.
 * 
 */
@Entity
@Table(name="multiple_bonus")
@NamedQuery(name="MultipleBonus.findAll", query="SELECT m FROM MultipleBonus m")
public class MultipleBonus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double bonus;

	//bi-directional many-to-one association to Ssn
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ssn")
	private Ssn ssn;

	public MultipleBonus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBonus() {
		return this.bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Ssn getSsn() {
		return this.ssn;
	}

	public void setSsn(Ssn ssn) {
		this.ssn = ssn;
	}

}