package com.whs.TestScript;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.testng.annotations.Test;

import com.whs.Utility.Base_Class;
import com.whs.pages.Home_Page;



public class Verify_Home_Page {
	
	@Test
	
	public static void home() throws Throwable{
		
		Logger logger=Logger.getLogger("Verify_Home_Page");
		PropertyConfigurator.configure("Log4j.properties");
	
		logger.info("Verify Home Page Test Script");
	
		
		Base_Class.openApplication();
		
		logger.info("Application opened");
		
		Home_Page.verifyPageTitle();
		
		Home_Page.verifyDepartment();
		
		Home_Page.verifyCategory();
		
		Home_Page.verifyCustomEmbroidery();
		
		Home_Page.verifyScreenPrinting();
		
		Home_Page.verifyFreeDesignLibrary();
		
		Home_Page.verifyCustomPatches();
		
	    Home_Page.verifyText();
	    
	    Home_Page.verifySignUpEmail();
	    
	    Home_Page.verifySearch();
		
	    Home_Page.VerifyLinks();
		
		Base_Class.closeApplication();
		
		logger.info("Application closed");
		
	}

}
