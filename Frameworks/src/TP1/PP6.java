package TP1;

import org.apache.log4j.Logger;
/**
 * 
 * @author Farid Chouakria
 *
 */
public class PP6 {
	//On d�clare un Logger de class
	private static final Logger LOGGER = Logger.getLogger(PP6.class);
	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			//On d�clare different type d'�reur
			LOGGER.fatal("Erreur fatal");
			LOGGER.error("Erreur");
			LOGGER.warn("Avertissement");
			LOGGER.info("Information");
			LOGGER.debug("Debug");
			LOGGER.trace("Trace");
		}
	}

}
