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
	//On d�clare un Logger de la classe
	private static final Logger CLASSLOGGER = Logger.getLogger(PP4.class);
	//On d�clae un Root Logger
	private static final Logger ROOTLOGGER = Logger.getRootLogger();
	//On d�clare un Layout de type PatterLayout avec la date le message et un saut de ligne
	private static Layout layout = new PatternLayout("%d %m%n");
	//On declare un Appender de type "Conseole Appender" au quel on ajoute le layout prec�dent
	private static ConsoleAppender consoleAppender = new ConsoleAppender(layout);
	//On declare un Appender de type "FileAppender"
	private static FileAppender fileAppender;
	public static void main(String[] args) {
		try {
			//On ajoute au file appender un layout et le lien du fichier dans le quel on veut �crire
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
		//On d�finit le level � ERROR pour le ROOTLOGGER
		ROOTLOGGER.setLevel(Level.ERROR);
		//On d�finit le level � ERROR pour le CLASSLOGGER
		CLASSLOGGER.setLevel(Level.INFO);
		//On d�clare deux log info
		CLASSLOGGER.info("Information 1");
		CLASSLOGGER.info("Information 2");
		try {
			//On g�nere une exception
			System.out.println(5/0);
		} catch (ArithmeticException e) {
			ROOTLOGGER.error("Voici une exception : ", e);
		}
	}
}
