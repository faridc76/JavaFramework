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
	// Lookup the bean using the ejb: namespace syntax which is explained here
	// https://docs.jboss.org/author/display/AS71/EJB+invocations+from+a+remote+client+using+JNDI
	private final String JNDI_BINDING = 
			//"ejb:/bonusEJB/Calculator!session.CalculatorRemote";
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
		
		// If there's any configuration problem, take a look at:
		// 
		// EJB invocations from a remote client using JNDI
		// https://docs.jboss.org/author/display/AS71/EJB+invocations+from+a+remote+client+using+JNDI
		// 
		// Remote EJB invocations via JNDI - EJB client API or remote-naming project
		// https://docs.jboss.org/author/display/AS71/Remote+EJB+invocations+via+JNDI+-+EJB+client+API+or+remote-naming+project
		//
		// javax.naming.NamingException: Failed instantiate InitialContextFactory org.jboss.naming.remote.client.InitialContextFactory from classloader
		// http://stackoverflow.com/questions/13065025/javax-naming-namingexception-failed-instantiate-initialcontextfactory-org-jboss
		//
		// Cannot connect to Remote EJB deployed to 7.1 instance, from another 7.1 instance
		// https://developer.jboss.org/thread/195516?tstart=0
		
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		props.put(Context.PROVIDER_URL, "remote://192.168.1.13:4447");
		props.put(Context.SECURITY_PRINCIPAL, "testuser");
        props.put(Context.SECURITY_CREDENTIALS, "testpassword");
		Context ctx = new InitialContext(props);   
		CalculatorRemote calculator = (CalculatorRemote) ctx.lookup(JNDI_BINDING);
		
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
