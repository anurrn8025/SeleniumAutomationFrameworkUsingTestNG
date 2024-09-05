package com.automation.tests.Scripts;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logerTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log=LogManager.getLogger(logerTest.class);
		log.info("browser has been lanched");
		log.warn("printing warning meassages");
		log.debug("printing debug messages");
		log.error("printing error");
		log.fatal("priting fatal messages");
		log.info("completed");

	}

}
