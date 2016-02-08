package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import model.Bonus;


/**
 * Servlet for processing bonus for a simple user.
 * 
 * @author mincong-h
 */
@WebServlet("/simple-bonus")
public class SimpleBonusServlet extends HttpServlet {

	private static final long serialVersionUID = -5727276180170917125L;
	private final Logger log = Logger.getLogger(SimpleBonusServlet.class);
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Bonus bonus = new Bonus();
		
		try {
		
			log.debug("Getting params from HTTP request");
			String ssn = req.getParameter("ssn");
			double multiplier = Double.valueOf(req.getParameter("multiplier"));
			double bonusAmount = getBonus(multiplier);
			
			log.debug("Constucting bonus ...");
			bonus.setSsn(ssn);
			bonus.setMultiplier(multiplier);
			bonus.setBonus(Double.toString(bonusAmount));
			log.debug(bonus);
		
		} catch (NumberFormatException e) {
			log.error(e.getStackTrace());
			bonus.setBonus(null); // if multiplier is not filled correctly
			
		} finally {
			req.setAttribute("bonus", bonus);
			log.debug("Finished. Dispatch to result.jsp");
			req.getRequestDispatcher("/simple-result.jsp").forward(req, resp);
		}
	}
	
	private double getBonus(double multiplier) {
		return multiplier * 100;
	}
}
