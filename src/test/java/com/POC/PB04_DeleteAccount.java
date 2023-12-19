package com.POC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PageLocators.AppObjects;
import common.BaseClass;
import common.BaseMethods;
import common.Utils;
import com.Utilities.ExtentReportUtil;

public class PB04_DeleteAccount extends BaseClass {
	
	
	@Test
	// PB_04 will perform deletion of account and validate invalid username and password	
		public void PB_04_DeleteAccount() throws IOException {
		ExtentReportUtil.logstep("PB_04 - Delete account");
		appObjects = new AppObjects(driver);
		bm = new BaseMethods(driver);
        utils = new Utils(driver); 
					
			Reporter.log("    ",true);
	    	Reporter.log("Test case 4 Start",true);
	    	
	    	Properties prop=new Properties();
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.properties");
			prop.load(fis);
			String Email=prop.getProperty("Email");
			String Password=prop.getProperty("Password");
			
			   	
	    	appObjects.username.clear();
			appObjects.username.sendKeys(Email);
			appObjects.password1.clear();
			appObjects.password1.sendKeys(Password);
			bm.clickOnElement(appObjects.loginbtn);
			bm.clickOnElement(appObjects.deleteaccount);
			bm.getAccountErased();
			Reporter.log("Account Erased",true);			
			appObjects.username.sendKeys(Email);
			appObjects.password1.sendKeys(Password);
			bm.clickOnElement(appObjects.loginbtn);
			bm.getInvalidUsername();
			Reporter.log("Invalid username or password",true);
					
			
			Reporter.log("Test case 4 : Finished",true);
			Reporter.log("    ",true);
    }	
     
    
    
}
    
    
    
    
 
    
    
    
    
    
    




