package com.POC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PageLocators.AppObjects;
import com.PageLocators.HomePage;
import com.PageLocators.LoginPage;
import com.PageLocators.RaportsPage;
import com.PageLocators.TransactionHistory;
import com.Utilities.ExtentReportUtil;

import common.BaseClass;
import common.BaseMethods;
import common.Utils;

public class PB02_ViewRaport extends BaseClass {
	
	
	
	@Test
	// PB_02 will view the transaction in report view by amount	
		public void PB_02_ViewRaport() throws IOException {
		ExtentReportUtil.logstep("PB_02 - View Report");
	//	appObjects = new AppObjects(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		transactionHistory = new TransactionHistory(driver);
		raportsPage = new RaportsPage(driver);
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
		String Amount2=prop.getProperty("Amount2");
		SoftAssert softAssert = new SoftAssert();
		
		// Login Account
			loginPage.username.clear();
			loginPage.username.sendKeys(Email);
			loginPage.password1.clear();
			loginPage.password1.sendKeys(Password);
			bm.clickOnElement(loginPage.loginbtn);
			
		// Transaction history page validate transaction exists
			bm.clickOnElement(homePage.transactionhistory);
			bm.validateIfCorrectTransaction(transactionHistory.beneficiaryamount1, Amount1);
			bm.validateIfCorrectTransaction(transactionHistory.beneficiaryamount2, Amount2);
			bm.navigateBack();
			
		// View raports page validate if displaying correct transaction via amount
			bm.clickOnElement(homePage.raports);		
			bm.clickOnElement(raportsPage.alltransactionbyamount);
			raportsPage.raportamount.sendKeys(Amount1);
			bm.clickOnElement(raportsPage.viewreport);			
			bm.validateIfCorrectTransaction(raportsPage.reportamount, Amount1);			
			
		// Navigate back to login page
			bm.navigateBack();
			bm.navigateBack();
			bm.navigateBack();
			
			Reporter.log("Test case 2 : Finished",true);
			Reporter.log("    ",true);
			
			
		}
	
	
     
    
    
}
    
    
    
    
 
    
    
    
    
    
    




