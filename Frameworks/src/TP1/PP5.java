package TP1;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.LF5Appender;

public class PP5 {
	//On d�clare un Logger de class
	private static final Logger LOGGER = Logger.getLogger(PP5.class);
	//On declare un Appender de type "LF5Appender"
		private static LF5Appender appender;

	public static void main(String[] args) {
		
		appender = new LF5Appender();
		
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
