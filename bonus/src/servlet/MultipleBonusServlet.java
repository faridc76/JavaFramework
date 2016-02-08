package servlet;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import session.CalculatorRemote;
import model.Bonus;


/**
 * Servlet for processing bonus for multiple users.
 * 
 * @author mincong-h
 */
@WebServlet("/multiple-bonus")
public class MultipleBonusServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6470619585301979577L;
	private final Logger log = Logger.getLogger(MultipleBonusServlet.class);
	//private final String HOST = "10.20.33.102";
	//private final String HOST = "localhost";
	private final String CALCULATOR_REMOTE = 
			//"java:global/bonusEJB/Calculator!session.CalculatorRemote";
			//"java:jboss/exported/bonusEJB/Calculator!session.CalculatorRemote";
			"ejb:/bonusEJB/Calculator!session.CalculatorRemote";
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String[] ssns, multipliers;
		Bonus[] bonuses = null;
		
		log.debug("Getting params from HTTP request");
		ssns = req.getParameterValues("ssn");
		multipliers = req.getParameterValues("multiplier");
		
		log.debug("Constucting multiple bonuses ...");
		try {
			bonuses = getBonuses(ssns, multipliers);
			for (Bonus bonus: bonuses) {
				log.debug(bonus);
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
			//log.error(e.getMessage());
			
		} finally {
			req.setAttribute("bonuses", bonuses);
			log.debug("Finished. Dispatch to result.jsp");
			req.getRequestDispatcher("/multiple-result.jsp").forward(req, resp);
		}
	}
	
	/**
	 * Get multiple bonuses
	 * 
	 * @param ssn
	 * @param multiplier
	 * @return
	 */
	private Bonus[] getBonuses(String[] ssn, String[] multiplierStr)
			throws NamingException {
		
		// call remote EJB calculator
		//Properties props = new Properties();
		//props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		//props.put(Context.PROVIDER_URL, "http-remoting://" + HOST +":8080");
		//props.put("jboss.naming.client.ejb.context", true);
		//InitialContext ctx = new InitialContext(props);
		Properties prop = new Properties();
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx = new InitialContext(prop);
		log.info("lookup=" + CALCULATOR_REMOTE);
		CalculatorRemote calculator = (CalculatorRemote) ctx.lookup(CALCULATOR_REMOTE);
		log.debug("Context has been successfully initialized.");
		
		// assume that 2 input arrays have the same length
		Bonus[] bonus = new Bonus[ssn.length];
		for (int i = 0; i < ssn.length; i++) {
			
			Bonus b = new Bonus();
			try {
				b.setSsn(ssn[i]);
				double m = Double.valueOf(multiplierStr[i]);
				b.setMultiplier(m);
				b.setBonus(Double.toString(calculator.bonus(m)));
			
			} catch (NumberFormatException e) {
				log.error(e.getStackTrace());
				b.setBonus(null); // if multiplier is not filled correctly
			
			} finally {
				String msg = String.format("bonus[%d]=%s", i, b.toString());
				log.debug(msg);
				bonus[i] = b;
			}
		}
		return bonus;
	}
}