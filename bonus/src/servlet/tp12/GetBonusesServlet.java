package servlet.tp12;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Bonus;

import org.jboss.logging.Logger;

import session.BonusSession;
import session.BonusSessionLocal;



/**
 * Servlet for processing bonus for a simple user.
 * 
 * @author mincong-h
 */
@WebServlet("/get-bonuses")
public class GetBonusesServlet extends HttpServlet {

	private static final long serialVersionUID = -5727276180170917125L;
	private final Logger log = Logger.getLogger(GetBonusesServlet.class);
	@EJB
	private BonusSessionLocal session;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		log.info("doPost called");
		List<Bonus> bonuses = session.getBonuses();
		if (bonuses != null) {
			for (Bonus bonus: bonuses) {
				log.info(bonus.getSsn() + ", " + bonus.getBonus());
			}
		} else {
			log.warn("No bonuses in table bonus of the database.");
		}
		log.info("redirect to index.jsp");
		resp.sendRedirect("index.jsp");
	}
}
