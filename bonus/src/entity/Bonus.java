package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the bonus database table.
 * 
 */
@Entity
@Table(name="bonus")
@NamedQuery(name="Bonus.findAll", query="SELECT b FROM Bonus b")
public class Bonus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ssn;

	private double bonus;

	public Bonus() {
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public double getBonus() {
		return this.bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}