package test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTestJava9 {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("LoggerTestJava9");
		logger.info("Helloworld");
		logger.log(Level.SEVERE, "SEVERE");
		logger.log(Level.WARNING, "SEVERE");
		logger.log(Level.INFO, "SEVERE");
	}
}
