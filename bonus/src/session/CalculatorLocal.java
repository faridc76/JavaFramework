package session;

import javax.ejb.Local;

/**
 * Interface for calculator
 * 
 * @author mincong-h
 */
@Local
public interface CalculatorLocal {
	public double bonus(double multiplier);
}
