package com.whs.TestScript;


import org.testng.annotations.Test;

import com.whs.Utility.Base_Class;
import com.whs.pages.Product_Page;

public class Verify_Product_Page extends Base_Class {
	
	@Test(priority=2,groups="productpage")
	
	public static void verifyBlankHat () throws Throwable{
		
		 // Base_Class.openApplication();
		
		 
		 
		// Product_Page.moveToProductPage();
		 
		 Product_Page.verifyBlankHat();
		 
		 
			}
	
	
	@Test(priority=1,groups="productpage")
	public static void verifyEMHat() throws Throwable {
	
	
	
	Product_Page.verifyEmbroideryHats();
	
	
	       }
	
	}


