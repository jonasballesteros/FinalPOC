package com.POC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PageLocators.AppObjects;
import com.Utilities.ExtentReportUtil;

import common.BaseClass;
import common.BaseMethods;
import common.Utils;

public class PB02_ViewRaport extends BaseClass {
	
	
	
	@Test
	// PB_02 will view the transaction in report view by amount	
		public void PB_02_ViewRaport() throws IOException {
		ExtentReportUtil.logstep("PB_02 - View Report");
		appObjects = new AppObjects(driver);
		bm = new BaseMethods(driver);
        utils = new Utils(driver); 
		
		Reporter.log("    ",true);
    	Reporter.log("Test case 2 : Start",true);
		
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.properties");
		prop.load(fis);
		String Email=prop.getProperty("Email");
		String Password=prop.getProperty("Password");
		String Amount1=prop.getProperty("Amount1");
		SoftAssert softAssert = new SoftAssert();
		
			appObjects.username.clear();
			appObjects.username.sendKeys(Email);
			appObjects.password1.clear();
			appObjects.password1.sendKeys(Password);
			appObjects.clickOnElement(appObjects.loginbtn);
			appObjects.clickOnElement(appObjects.transactionhistory);
			appObjects.navigateBack();
			appObjects.clickOnElement(appObjects.raports);		
			appObjects.clickOnElement(appObjects.alltransactionbyamount);
			appObjects.raportamount.sendKeys(Amount1);
			appObjects.clickOnElement(appObjects.viewreport);			
			softAssert.assertTrue(appObjects.verifyReportAmount().contains(Amount1), "Amount not matched");
			Reporter.log("Amount Not Matched",true);		
			appObjects.navigateBack();
			appObjects.navigateBack();
			appObjects.navigateBack();
			Reporter.log("Test case 2 : Finished",true);
			Reporter.log("    ",true);
			
			
		}
	
	
     
    
    
}
    
    
    
    
 
    
    
    
    
    
    




