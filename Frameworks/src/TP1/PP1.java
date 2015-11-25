package TP1;
import org.apache.log4j.Logger;
/**
 * 
 * @author Farid Chouakria
 *
 */
public class PP1 {
	
	//On déclare un Logger de la classe
	private static final Logger LOGGER = Logger.getRootLogger();

	public static void main(String[] args) {

		//On déclare different type d'éreur
		LOGGER.fatal("Erreur fatal");
		LOGGER.error("Erreur");
		LOGGER.warn("Avertissement");
		LOGGER.info("Information");
		LOGGER.debug("Debug");
		LOGGER.trace("Trace");
	}

}
