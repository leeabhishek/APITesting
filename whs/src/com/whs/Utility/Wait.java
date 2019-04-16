package com.whs.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait extends Base_Class {
	
	
	//=========Explicit Wait
	public static WebElement getWhenVisible(By locator, int timeout) {
 
     WebElement element = null;
 
     WebDriverWait wait = new WebDriverWait(driver, timeout);
 
       element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
 
       return element;
 
}
	
	//=========Static Wait
	public static void sleep(int num)
	{
		try {
			
			Thread.sleep(num);
		} 
		
		catch (InterruptedException e) {
			
			e.getMessage();
		}
	}
	
	

}
