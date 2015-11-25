package TP1;

import java.sql.*;

import org.apache.log4j.Logger;

import java.io.*;
/**
 * 
 * @author Farid Chouakria
 *
 */
public class PP7 {
	private static final Logger LOGGER = Logger.getLogger(PP7.class);
	
	
	public static void main(String[] args) throws IOException,SQLException {
		LOGGER.fatal("Erreur fatal");
		LOGGER.error("Erreur");
		LOGGER.warn("Avertissement");
		LOGGER.info("Information");
		LOGGER.debug("Debug");
		LOGGER.trace("Trace");
	}

}
