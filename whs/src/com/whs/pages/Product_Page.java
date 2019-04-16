package com.whs.pages;

import java.util.List;

import javax.swing.text.Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.whs.Utility.Base_Class;
import com.whs.Utility.Excel_Utils;
import com.whs.Utility.Wait;
import com.whs.Utility_Log.Log;




public class Product_Page extends Base_Class {
	
	static By Searchbox = By.xpath(".//*[@id='search_string']");
	static By Searchbutton = By.xpath("//span[@class='input-group-addon']"); 
	static By product6801 = By.xpath("//img[@src='/wh_staging/uploads/images/5169_thumb.jpg']");
	static By productselectionforblank = By.xpath("//div[@class='sideFixedBox']//following::li[1]");
	static By firstinputbox = By.xpath(" //a[@class='color-quantity-accordion colorQtyArrowElem']//following::input[1]");
	static By BlackButton = By.xpath(".//*[@id='blankCustom']//a[1][@data-method='Blank']");
	static By EmbroideryButton = By.xpath(".//*[@id='blankCustom']//a[1][@data-method='Embroidery']");
	static By colorsAndQtyText = By.xpath("//a[@href='#colorsQuantity']");
	static By colorsAndQty =By.xpath("//div[@class='panel-title']//following-sibling::a[@href='#colorsQuantity']");
	static By priceEachBlank = By.xpath("//div[text()='Price Each']/following-sibling::*");
	static By subTotalPrice = By.xpath("//div[text()='Subtotal']//following::div[1]");
    static By artLibraryButton = By.xpath("//a[@class='artLibrary design-style-option'][@data-name='Art Library']");   
    static By artLibraryImg = By.xpath("//div[@class='searchBox']/following::span[1][text()='aabber']");
    static By messageAlertForStockDesign = By.xpath("//*[text()='Please select a stock design!']");
    static By addToCartButton= By.xpath("//button[text()='ADD TO CART']");
    static By messageAlertForFirstLineOfText= By.xpath("//*[text()='Please enter first line of text!']");
    static By messageAlertForDesignPosition= By.xpath("//*[text()='Please select a position!']");
    static By selectDesignPositionDropdown= By.xpath(".//*[@id='customise_text3']/following::div[47]");
    static By selecFirsttHatPosition = By.xpath(".//*[@id='customise_text3']/following::div[53]");
    static By addAdditionalEmbroidery = By.xpath("//button[text()='+ Add Additional Embroidery']");
    static By textOnlyButtonSecondPosition = By.xpath("//div[starts-with(@id, 'pos_id')][2]//following::a[@data-name='Text Only']");
    static By chooseYourFontForSecondPosiiotn = By.xpath("//h3[text()='Choose your font']//following::div[4]");
    static By selectDesignPositionDropdownForSecondPosition = By.xpath("//div[starts-with(@id, 'pos_id')][2]//descendant::div[@class='wSelect wSelect-theme-classic'][2]");
    static By selectSecondHatPosition = By.xpath("//div[starts-with(@id, 'pos_id')][2]//descendant::div[@class='position-section position-section-3']//descendant::div[text()='Off Center over Left Eyebrow When Wearing']");
    static By textOnlyButtonThirdPosition = By.xpath("//div[starts-with(@id, 'pos_id')][3]//following::a[@data-name='Text Only']");
    static By selectDesignPositionDropdownForThirdPosition = By.xpath("//div[starts-with(@id, 'pos_id')][3]//descendant::div[@class='wSelect wSelect-theme-classic'][2]");
    static By selectThirdHatPosition = By.xpath("//div[starts-with(@id, 'pos_id')][3]//descendant::div[@class='position-section position-section-3']//descendant::div[text()='Left Side Over Ear When Wearing']");
    static By countTotalEmbroideryPosition = By.xpath("//div[@class='customize-positions']//div[starts-with(@id, 'pos_id')]");
    static By emTablePrice = By.xpath("//div[@class='dozen-orders' and text() = '$6.66 ea.']");
    
    
    
    
    
    
   public static String dmessageAlertForStockDesign;
   public static String dmessageAlertForDesignPosition;
   public static int BlkProductNo;
   public static int BlkQty;
   public static double BlkPriceEach;
   public static int EMProductNo;
   public static int EMQty;
   public static double EMPriceEach;
   public static double EMPositionValue;
    
    public static String ExcelPath = "E:\\Codes\\whs\\TestData\\TestData.xlsx";
	
	
         //============Verify blank hat
         public static void verifyBlankHat() throws Exception{
        	 
        	 double dSubTotal;
        	 double dTotalqty;
        	 
        	Logger logger = Logger.getLogger("Verify_Product_Page");
     		PropertyConfigurator.configure("Log4j.properties");
     		Log.startTestCase("Verify Blank Hat");
     		
     	
     		
     		System.out.println("This is Blank hat verify Method");
     		Reporter.log("This is Blank hat verify Method");
     		logger.info("This is Blank hat verify Method");
     		System.out.println("");
     		
     		//===============Add product no and product quantity via excel for Blank Hat
        	 
        	 
        	 Excel_Utils.setExcelFile(ExcelPath);
        	 int rows = Excel_Utils.getRowCount(0);
        	 System.out.println("Row count for Blank hat sheet:"+rows);
        	 System.out.println("");
        	 
        	 for(int i=1;i<=rows;i++)
        	 {
        	 
        		 BlkProductNo = Excel_Utils.getNumericData(0, i, 0);
        		 BlkQty = Excel_Utils.getNumericData(0, i, 1);
        		 BlkPriceEach = Excel_Utils.getNumericDatadouble(0, i, 2);
        		 
        		 String DlkProductNo = Integer.toString(BlkProductNo);
        		 String DBlkQty = Integer.toString(BlkQty);
        	 
            driver.findElement(Searchbox).sendKeys(DlkProductNo);
            logger.info("Product No entered for Blank hat");
            
            Wait.sleep(2000);
     		
     		driver.findElement(Searchbutton).click();
     		logger.info("Search Button clicked");
     		
     		 //Wait.sleep(2000);
     		 WebElement eleBlkProduct = Wait.getWhenVisible(product6801, 30);
     		
             ((JavascriptExecutor)driver).executeScript("scroll(0,300)");
     		
             Wait.sleep(2000);
     		
            eleBlkProduct.click();
     		logger.info("Product No clicked");
     		
     		//we need to apply explict wait. 
     		//Thread.sleep(30000);
        	 
     		WebElement eleBLkItemSelected = Wait.getWhenVisible(productselectionforblank, 40);
        	 
        	 
     		 eleBLkItemSelected.click();
        	 logger.info("Blank Item selected");
        	 
        	 Wait.sleep(2000);
        	
        	 driver.findElement(firstinputbox).sendKeys(DBlkQty);
        	 logger.info("Product quantity entered for blank hat");
        	 
        	 Wait.sleep(2000);
        	 
        	 String Totalqty=driver.findElement(firstinputbox).getAttribute("value");
        	
        	 dTotalqty=Double.parseDouble(Totalqty);
        	
        	
        	
        	 
        	driver.findElement(BlackButton).click();
        	logger.info("Blank hat button selected");
        	
        	Wait.sleep(2000);
        	 
        	 String  priceEachBlankvalue = driver.findElement(priceEachBlank).getText();
        	
        	 String a = priceEachBlankvalue.substring(1);
        	
        	 
        	 double a1 = Double.parseDouble(a);
        	
        	 
        	 dSubTotal = (dTotalqty*12)*(a1);
        	 
        	 
        	//=======Comparing price Each of blank hats
        	 if(a1==BlkPriceEach){
        		 
        		 logger.info("Price Each Matched");
        		 
        	 }
        	 
        	 else{
        		 
        		 logger.info("Price Each Unmatched");
        		 
        	 }
        	 
        	 
        	 
        	 String subTotal = driver.findElement(subTotalPrice).getText();
        	 String splitSubTotal =subTotal.substring(1);
        	 
        	 double ddsubTotal =Double.parseDouble(splitSubTotal);
        	 
        	 //=============Comparing Sub-total of blank hats
        	 if(ddsubTotal == dSubTotal){
        		 
        		  logger.info("SubTotal Matched");
        		  //======Excel Writing for Pass
        		  Excel_Utils.setCellData(ExcelPath, 0, i, 3, "PASS");
        		  System.out.println("Test Case Passed");
        		  logger.info("Test Case Passed");
        		  Log.endTestCase("Verify Blank Hat");
        		  System.out.println("");
        		  
        		 
        	 }
        	 else{
        		 
        		 logger.info("SubToal UnMatched");
        		 //==========Excel writing for Failed
        		 Excel_Utils.setCellData(ExcelPath, 0, i, 3, "Fail");
        		 System.out.println("Test Case Failed");
        		 logger.info("Test Case Failed");
        		 System.out.println("");
        		 
        		 
        	 }
        	 
        	 
        	 
        	 
        	 }
         }
         
         
         
            
         //===========Verify Embroidery Hat
         public static void verifyEmbroideryHats() throws Exception{
        	 
        	 Logger logger = Logger.getLogger("Verify_Product_Page");
      		 PropertyConfigurator.configure("Log4j.properties");
      		 
      		 Log.startTestCase("Verify Embroidery Hat");
      		 System.out.println("");
        	 
        	 driver.navigate().refresh();
        	 System.out.println("This is Embroidery Hat Verify Method");
        	 logger.info("This is Embroidery Hat Verify Method");
        	 System.out.println("");
        	 
        	 
        	 //Add Product no and product quantity via excel for Embroidery Hat
        	 
        	
        	Excel_Utils.setExcelFile(ExcelPath);
        	int rows = Excel_Utils.getRowCount(1);
        	System.out.println("Row count for Embroidery Sheet = "+rows);
        	System.out.println("");
        	
        	for(int i=1;i<=rows;i++)
        	{
        	 
        	 
        	 
        	 EMProductNo = Excel_Utils.getNumericData(1, i, 0);
        	 EMQty = Excel_Utils.getNumericData(1, i, 1);
        	 EMPriceEach = Excel_Utils.getNumericDatadouble(1, i, 2);
        	 EMPositionValue = Excel_Utils.getNumericDatadouble(1, i, 3);
        	 
        	 String DEMProductNo = Integer.toString(EMProductNo);
        	 String DEMQty = Integer.toString(EMQty);
        	 
        	 
        	 
        	 
        	 
        	 
        	 driver.findElement(Searchbox).sendKeys(DEMProductNo);
             logger.info("Product No entered for Embroidery hat");
             
             Wait.sleep(2000);
      		
      		driver.findElement(Searchbutton).click();
      		logger.info("Search Button clicked");
      		
      		WebElement eleHat = Wait.getWhenVisible(product6801, 30);
      		
      		
            ((JavascriptExecutor)driver).executeScript("scroll(0,300)");
      		
      		Wait.sleep(2000);
      		
      		
      		eleHat.click();
      	
      		logger.info("Product No clicked");
      		
      	 
      		
      		WebElement eleSelectEMHat = Wait.getWhenVisible(productselectionforblank, 40);
      		
         	 
         	 
         	 
         	 eleSelectEMHat.click();
         	 logger.info("Embrodery Item selected");
        	 
        	 driver.findElement(firstinputbox).sendKeys(DEMQty);
        	 logger.info("Product quantity entered for Embroidery hat");
        	 
        	 driver.findElement(EmbroideryButton).click();
        	 logger.info("Embroidery button selected for Embroidery Hat");
        	 
        	 driver.findElement(artLibraryButton).click();
        	 logger.info("Art Library option selected for Embroidery Hat");
        	 
        	 
        	 
        	 driver.findElement(addToCartButton).click();
        	 logger.info("Add To Cart button Clicked to verify the Message Alert for Stock Design");
        	 
        	 dmessageAlertForStockDesign = driver.findElement(messageAlertForStockDesign).getText();
        	 
        	 if(dmessageAlertForStockDesign.contains("Please select a stock design!")){
        		 
        	 System.out.println("Test Case Pass for stock design message alert");
        	 logger.info("Test Case Pass for stock design message alert");
        	 
        	 }
        	 
        	 else{
        		 
        		 System.out.println("Test case Failed");
        		 logger.info("Test case Failed");
        		 
        		 }
        	 
        	 
        	driver.findElement(artLibraryImg).click();
        	logger.info("Image selected from Art Library Gallery");
        	
        	Wait.sleep(3000);
        	
        	driver.findElement(addToCartButton).click();
        	logger.info("Add To Cart button Clicked to verify the Message Alert for Design Position");
        	
        	dmessageAlertForDesignPosition = driver.findElement(messageAlertForDesignPosition).getText();
        	
        	if(dmessageAlertForDesignPosition.contains("Please select a position!")){
        		
        		System.out.println("Test Case Pass for design position message alert");
        		logger.info("Test Case Pass for design position message alert");
        		
        		}
        	
        	
        	else{
        		
        		System.out.println("Test case failed for design position message alert");
        		logger.info("Test case failed for design position message alert");
        		}
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(selectDesignPositionDropdown).click();
        	logger.info("Click event fired for select design position drop down for 1st position");
        	
        	driver.findElement(selecFirsttHatPosition).click();
        	logger.info("Design position selected from drop down for 1st design position");
        	
        	
        	driver.findElement(addAdditionalEmbroidery).click();
        	logger.info("Click event fired for 2nd design position");
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(textOnlyButtonSecondPosition).click();
        	logger.info("Text only option selected for 2nd position");
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(chooseYourFontForSecondPosiiotn).click();
        	logger.info("Font item selected from Gallery");
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(selectDesignPositionDropdownForSecondPosition).click();
        	logger.info("Click event fired for select design position drop down for 2nd position");
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(selectSecondHatPosition).click();
        	logger.info("Design position selected from drop down for 2nd design position");
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(addAdditionalEmbroidery).click();
        	logger.info("Click event fired for 3rd design position");
        	
        	Wait.sleep(2000);
        	
        
        	driver.findElement(textOnlyButtonThirdPosition).click();
        	logger.info("Text only option selected for 3rd position");
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(chooseYourFontForSecondPosiiotn).click();
        	logger.info("Font item selected from Gallery");
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(selectDesignPositionDropdownForThirdPosition).click();
        	logger.info("Click event fired for select design position drop down for 3rd position");
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(selectThirdHatPosition).click();
        	logger.info("Design position selected from drop down for 3rd design position");
        	
        	
        	List<WebElement> list   = driver.findElements(countTotalEmbroideryPosition);
        	
        	int designPosition = list.size();
        	
        	int totalDesignPosition = designPosition-1;
        	
        	System.out.println("Total Design Position For Embroidery Hat"+designPosition);
        	
        	double priceEach = EMPriceEach + (EMPositionValue*totalDesignPosition);
        	
        	System.out.println("Price Each for Embroidery Hat = "+priceEach);
        	
        	Wait.sleep(2000);
        	
        	((JavascriptExecutor)driver).executeScript("scroll(0,-500)");
        	
        	
        	
        	
        	Wait.sleep(2000);
        	
        	driver.findElement(colorsAndQty).click();
        	
        	Wait.sleep(2000);
        	
        	String dFirstinputbox = driver.findElement(firstinputbox).getAttribute("value");
        	logger.info("Quantity for Embroidery Hat = "+dFirstinputbox);
        	System.out.println("Quantity for Embroidery Hat = "+dFirstinputbox);
        	System.out.println("");
        	
        	
        	driver.findElement(colorsAndQty).click();
        	
        	Wait.sleep(2000);
        	
        	((JavascriptExecutor)driver).executeScript("scroll(0,450)");
        	
        	double a2 = Double.parseDouble(dFirstinputbox);
        	
        	double subTotal = (priceEach * (a2*12));
        	
        	System.out.println("SubTotal for Embroider Hat = "+subTotal);
        	
        	
        	String dPriceEachEM = driver.findElement(priceEachBlank).getText();
        	
        	String splitdPriceEachEM = dPriceEachEM.substring(1);
        	
        	double b2 = Double.parseDouble(splitdPriceEachEM);
        	
        	if(priceEach == b2){
        		
        		logger.info("Price Each Match for Embroidery Hats");
        		System.out.println("Price Each Match for Embroidery Hats");
        		System.out.println("");
        		System.out.println("");
        		
        	}
        	
        	else{
        		
        		logger.info("Price Each not Match for Embroidery Hats");
        		System.out.println("Price Each not Match for Embroidery Hats");
        		System.out.println("");
        	}
        	
        	
        	
        	String Dsubtotal = driver.findElement(subTotalPrice).getText();
        	
        	String SplitDsubtotal = Dsubtotal.substring(1);
        	
        	double DDsubtotal = Double.parseDouble(SplitDsubtotal);
        	
        	if(DDsubtotal == subTotal){
        		
        		logger.info("SubTotal Match for Embroidery Hats");
        		System.out.println("SubTotal Match for Embroidery Hats");
        		Excel_Utils.setCellData(ExcelPath, 1, i, 4, "PASS");
        		System.out.println("");
        		System.out.println("");
        		Log.endTestCase("Verify Embroidery Hat");
        	}
        	
        	else{
        		
        		logger.info("SubTotal not Match for Embroidery Hats");
        		System.out.println("SubTotal not Match for Embroidery Hats");
        		Excel_Utils.setCellData(ExcelPath, 1, i, 4, "FAIL");
        		System.out.println("");
        		
        	}
        	
        	
        	
        	
        	 
        	}
        	
         }

         
         
         
         
         
         
}
