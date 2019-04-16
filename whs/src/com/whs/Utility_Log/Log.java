package com.whs.Utility_Log;

import org.apache.log4j.Logger;

public class Log {
	
	// initialize Log4j logs
		private static Logger Log = Logger.getLogger(Log.class.getName());
		//import org.apache.log4j.xml.DOMConfigurator; // Call Log
		//DOMConfigurator.configure("log4j.xml"); // In Main method
		
		public static void info(String message){
		Log.info(message);
		}

		// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
		
		public static void startTestCase(String sTestCaseName){
			 
			Log.info("****************************************************************************************");
		 
			Log.info("****************************************************************************************");
		 
			Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		 
			Log.info("****************************************************************************************");
		 
			Log.info("****************************************************************************************");
		 
			}
		
		
		
		
		//This is to print log for the ending of the test case
		 
		 public static void endTestCase(String sTestCaseName){
		 
			Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		 
			Log.info("X");
		 
			Log.info("X");
		 
			Log.info("X");
		 
			Log.info("X");
		 
			}
		
		
}
