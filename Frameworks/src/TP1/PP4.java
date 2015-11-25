package TP1;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
/**
 * 
 * @author Farid CHOUAKRIA
 *
 */
public class PP4 {
	//On déclare un Logger de la classe
	private static final Logger CLASSLOGGER = Logger.getLogger(PP4.class);
	//On déclae un Root Logger
	private static final Logger ROOTLOGGER = Logger.getRootLogger();
	//On déclare un Layout de type PatterLayout avec la date le message et un saut de ligne
	private static Layout layout = new PatternLayout("%d %m%n");
	//On declare un Appender de type "Conseole Appender" au quel on ajoute le layout precédent
	private static ConsoleAppender consoleAppender = new ConsoleAppender(layout);
	//On declare un Appender de type "FileAppender"
	private static FileAppender fileAppender;
	public static void main(String[] args) {
		try {
			//On ajoute au file appender un layout et le lien du fichier dans le quel on veut écrire
			fileAppender = new FileAppender(layout, "exception.log");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//On active les options de l'appender
		consoleAppender.activateOptions();
		//On ajoute les appender aux Logger
		CLASSLOGGER.addAppender(consoleAppender);
		ROOTLOGGER.addAppender(fileAppender);
		//On définit le level à ERROR pour le ROOTLOGGER
		ROOTLOGGER.setLevel(Level.ERROR);
		//On définit le level à ERROR pour le CLASSLOGGER
		CLASSLOGGER.setLevel(Level.INFO);
		//On déclare deux log info
		CLASSLOGGER.info("Information 1");
		CLASSLOGGER.info("Information 2");
		try {
			//On génere une exception
			System.out.println(5/0);
		} catch (ArithmeticException e) {
			ROOTLOGGER.error("Voici une exception : ", e);
		}
	}
}
