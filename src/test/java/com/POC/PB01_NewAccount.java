package com.POC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.PageLocators.AppObjects;
import com.Utilities.ExtentReportUtil;

import common.BaseClass;
import common.BaseMethods;
import common.Utils;

public class PB01_NewAccount extends BaseClass {

	
	
	
	@Test
	// PB_01 will create new account and perform adding account into the transaction history and verify if the account is created
		public void PB_01_NewAccount() throws IOException {
		
		ExtentReportUtil.logstep("PB_01 - Create new account");
		
		appObjects = new AppObjects(driver);
		bm = new BaseMethods(driver);
        utils = new Utils(driver);
		
		Reporter.log("    ",true);
    	Reporter.log("Test case 1 : Start",true);
		
		
		utils.waitApptoLoad();
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.properties");
		prop.load(fis);
		String FirstName=prop.getProperty("FirstName");
		String LastName=prop.getProperty("LastName");
		String Email=prop.getProperty("Email");
		String Iban=prop.getProperty("Iban");
		String Password=prop.getProperty("Password");
		String BeneficiaryName1=prop.getProperty("BeneficiaryName1");
		String AccountNumber1=prop.getProperty("AccountNumber1");
		String Amount1=prop.getProperty("Amount1");
		String BeneficiaryName2=prop.getProperty("BeneficiaryName2");
		String AccountNumber2=prop.getProperty("AccountNumber2");
		String Amount2=prop.getProperty("Amount2");
		
		        
						
			
			appObjects.clickOnElement(appObjects.registermain);
			appObjects.firstname.sendKeys(FirstName);
			appObjects.lastname.sendKeys(LastName);
			appObjects.email.sendKeys(Email);
			appObjects.iban.sendKeys(Iban);
			appObjects.password.sendKeys(Password);
			appObjects.confirmpassword.sendKeys(Password);
			appObjects.clickOnElement(appObjects.male);
			appObjects.clickOnElement(appObjects.registerbtn1);
			Reporter.log("Account Created",true);
			appObjects.username.sendKeys(Email);
			appObjects.password1.sendKeys(Password);
			appObjects.clickOnElement(appObjects.loginbtn);		
			appObjects.clickOnElement(appObjects.transactionhistory);	
			appObjects.clickOnElement(appObjects.addbtn);
			appObjects.beneficiaryname.sendKeys(BeneficiaryName1);
			appObjects.accountnumber.sendKeys(AccountNumber1);
			appObjects.amount.sendKeys(Amount1);
			appObjects.clickOnElement(appObjects.sendmoneybtn);	
			appObjects.clickOnElement(appObjects.addbtn);
			appObjects.beneficiaryname.sendKeys(BeneficiaryName2);
			appObjects.accountnumber.sendKeys(AccountNumber2);
			appObjects.amount.sendKeys(Amount2);
			appObjects.clickOnElement(appObjects.sendmoneybtn);
			Reporter.log("Beneficiary Account Created",true);			
			appObjects.navigateBack();
			appObjects.navigateBack();
			
			Reporter.log("Test case 1 : Finished",true);
			Reporter.log("    ",true);
		}
	
	
    
    
}
    
    
    
    
 
    
    
    
    
    
    




