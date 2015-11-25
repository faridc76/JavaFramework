package TP1;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.XMLLayout;
/**
 * 
 * @author Farid Chouakria
 *
 */
public class PP3 {
	//On d�clare un Root Logger
	private static final Logger LOGGER = Logger.getLogger(PP3.class);
	//On declare un Appender de type "FileAppender"
	private static FileAppender appender;
	//On d�clare des Layout de type xml et html
	private static Layout xmlLayout, htmlLayout;

	public static void main(String[] args) {
		//On instancie les layout pour le xml et l'html
		xmlLayout = new XMLLayout();
		htmlLayout = new HTMLLayout();
		try {
			//On d�finit les fichiers de soties
			appender = new FileAppender(xmlLayout, "pp3.xml");
			appender = new FileAppender(htmlLayout, "pp3.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.addAppender(appender);
		//On d�clare different type d'�reur
		LOGGER.fatal("Erreur fatal");
		LOGGER.error("Erreur");
		LOGGER.warn("Avertissement");
		LOGGER.info("Information");
		LOGGER.debug("Debug");
		LOGGER.trace("Trace");
		appender.close();
	}
}