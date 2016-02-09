package model;

/**
 * Entite is used instead of this class.
 * 
 * @deprecated
 * @author minconghuang
 */
public class Bonus {
	private String ssn;
	private double multiplier;
	private String bonus;
	
	public Bonus() {
	}

	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public double getMultiplier() {
		return multiplier;
	}
	
	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}
	
	public String getBonus() {
		return bonus;
	}
	
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return "Bonus [ssn=" + ssn + ", multiplier=" + multiplier + ", bonus="
				+ bonus + "]";
	}
}
