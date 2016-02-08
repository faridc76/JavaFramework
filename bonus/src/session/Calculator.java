package session;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculator
 * 
 * @author mincong-h
 */
@Stateless
public class Calculator implements CalculatorLocal {

    private final int BONUS_RATE = 100;
	
    public Calculator() {
    }
	
	@Override
	public double bonus(double multiplier) {
		return multiplier * BONUS_RATE;
	}
}
