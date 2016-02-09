package servlet.tp15;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import session.MultipleBonusSessionLocal;
import entity.Bonus;
import entity.MultipleBonus;
import entity.Ssn;


/**
 * Servlet for adding a list of bonuses, where one ssn corresponds at multiple
 * multipliers.
 * 
 * @author mincong-h
 */
@WebServlet("/add-bonuses")
public class AddBonusesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2311153561342418289L;
	private final Logger log = Logger.getLogger(AddBonusesServlet.class);
	@EJB
	private MultipleBonusSessionLocal multipleBonusSession;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String[] ssns, multipliers;
		MultipleBonus[] multipleBonuses = null;
		
		log.debug("Getting params from HTTP request");
		ssns = req.getParameterValues("ssn");
		multipliers = req.getParameterValues("multiplier");
		
		log.debug("Constucting multiple bonuses ...");
		multipleBonuses = getBonuses(ssns, multipliers);
		for (MultipleBonus multipleBonus: multipleBonuses) {
			log.info(multipleBonus);
			multipleBonusSession.create(multipleBonus);
		}
		req.setAttribute("multipleBonuses", multipleBonuses);
		log.debug("Finished. Dispatch to result.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	/**
	 * Get multiple bonuses
	 * 
	 * @param ssn
	 * @param multiplier
	 * @return
	 */
	private MultipleBonus[] getBonuses(String[] ssn, String[] multiplierStr) {
		
		// 2 input arrays do not have the same length
		MultipleBonus[] multipleBonus = new MultipleBonus[multiplierStr.length];
		for (int i = 0; i < multiplierStr.length; i++) {
			
			MultipleBonus b = new MultipleBonus();
			int iSsn = (int) i / 3;
			log.info("(i, iSsn) = (" + i + ", " + iSsn + ")");
			try {
				Ssn _ssn = new Ssn();
				_ssn.setSsn(ssn[iSsn]);
				b.setSsn(new Ssn());
				double m = Double.valueOf(multiplierStr[i]);
				b.setBonus(m);
			
			} catch (NumberFormatException e) {
				log.error(e.getStackTrace());
				b.setBonus(-1); // if multiplier is not filled correctly
			
			} finally {
				String msg = String.format("bonus[%d]=%s", i, b.toString());
				log.info(msg);
				multipleBonus[i] = b;
			}
		}
		return multipleBonus;
	}
}
