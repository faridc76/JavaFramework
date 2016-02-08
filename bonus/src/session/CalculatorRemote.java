package session;

import javax.ejb.Remote;

/**
 * Interface for calculator
 * 
 * @author mincong-h
 */
@Remote
public interface CalculatorRemote {
	public double bonus(double multiplier);
}
