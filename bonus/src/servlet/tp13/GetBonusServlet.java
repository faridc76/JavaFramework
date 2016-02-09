package servlet.tp13;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Bonus;

import org.jboss.logging.Logger;

import session.BonusSessionLocal;



/**
 * TP13: Servlet for find an existing bonus using its ssn from database.
 * 
 * @author mincong-h
 */
@WebServlet("/get-bonus")
public class GetBonusServlet extends HttpServlet {

	private static final long serialVersionUID = -5727276180170917125L;
	private final Logger log = Logger.getLogger(GetBonusServlet.class);
	@EJB
	private BonusSessionLocal session;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		log.info("doPost called");
		req.getSession().setAttribute("targetBonus", null); // reset targetBonus
		String ssn = req.getParameter("ssn");
		Bonus bonus = session.getBonus(ssn);
		if (bonus != null) {
			log.info(bonus.getSsn() + ", " + bonus.getBonus());
			req.getSession().setAttribute("targetBonus", bonus);
		}
		log.info("redirect to index.jsp");
		resp.sendRedirect("index.jsp");
	}
}
