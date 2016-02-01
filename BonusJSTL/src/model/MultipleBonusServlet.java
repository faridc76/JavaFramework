package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet for processing bonus for multiple users.
 * 
 * @author mincong-h
 */
@WebServlet("/multiple-bonus")
public class MultipleBonusServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6470619585301979577L;
	private final Logger log = Logger.getLogger(MultipleBonusServlet.class);
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String[] ssns, multipliers;
		Bonus[] bonuses;
		
		log.debug("Getting params from HTTP request");
		ssns = req.getParameterValues("ssn");
		multipliers = req.getParameterValues("multiplier");
		
		log.debug("Constucting multiple bonuses ...");
		bonuses = getBonuses(ssns, multipliers);
		for (Bonus bonus: bonuses) {
			log.debug(bonus);
		}
			
		req.setAttribute("bonuses", bonuses);
		log.debug("Finished. Dispatch to result.jsp");
		req.getRequestDispatcher("/multiple-result.jsp").forward(req, resp);
	}
	
	/**
	 * Get bonus from multiplier
	 * 
	 * @param multiplier
	 * @return
	 */
	private double getBonus(double multiplier) {
		return multiplier * 2;
	}
	
	/**
	 * Get multiple bonuses
	 * 
	 * @param ssn
	 * @param multiplier
	 * @return
	 */
	private Bonus[] getBonuses(String[] ssn, String[] multiplierStr) {
		// assume that 2 input arrays have the same length
		Bonus[] bonus = new Bonus[ssn.length];
		for (int i = 0; i < ssn.length; i++) {
			Bonus b = new Bonus();
			try {
				b.setSsn(ssn[i]);
				double m = Double.valueOf(multiplierStr[i]);
				b.setMultiplier(m);
				b.setBonus(getBonus(m));
			} catch (NumberFormatException e) {
				log.error(e.getStackTrace());
				b = null;
			} finally {
				bonus[i] = b;
			}
		}
		return bonus;
	}
}
