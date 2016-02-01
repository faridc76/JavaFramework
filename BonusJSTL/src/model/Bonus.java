package model;

public class Bonus {
	private String ssn;
	private double multiplier;
	private double bonus;
	
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
	
	public double getBonus() {
		return bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return "Bonus [ssn=" + ssn + ", multiplier=" + multiplier + ", bonus="
				+ bonus + "]";
	}
}
