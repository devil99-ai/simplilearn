package com.simplilearn.RestAssuredDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LoggingInRestAssured {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(App.class);
	
	public static void main(String[] args ) {
		System.out.println("Hello world ");
		logger.trace("tracer level log");
		logger.debug("this is debug log");
		logger.info("this is info log");
		logger.error("this is error log");
		logger.fatal("this is fatal log");
		logger.warn("this is warn log");
	}

}
