package TP1;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
/**
 * 
 * @author Farid Chouakria
 *
 */
public class PP2 {
	//On déclare un Logger de la classe
	private static final Logger LOGGER = Logger.getRootLogger();
	//On declare un Appender de type "Conseole Appender"
	private static ConsoleAppender appender = new ConsoleAppender();
	//On déclare un Layout de type PatterLayout avec la date le message et un saut de ligne
	private static Layout layout = new PatternLayout("%d %m%n");
		
	public static void main(String[] args) {
		//On ajoute le layout à l'appender
		appender.setLayout(layout);
		//On active les options de l'appender
		appender.activateOptions();
		//On ajoute l'appender au Logger
		LOGGER.addAppender(appender);
		//On définit le level à INFO
		LOGGER.setLevel(Level.INFO);
			
			
		//On déclare different type d'éreur
		LOGGER.fatal("Erreur fatal");
		LOGGER.error("Erreur");
		LOGGER.warn("Avertissement");
		LOGGER.info("Information");
		LOGGER.debug("Debug");
		LOGGER.trace("Trace");
	}
}
