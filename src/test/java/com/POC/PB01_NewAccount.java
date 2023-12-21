package com.POC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.PageLocators.AppObjects;
import com.PageLocators.HomePage;
import com.PageLocators.LoginPage;
import com.PageLocators.MainPage;
import com.PageLocators.RegisterPage;
import com.PageLocators.TransactionHistory;
import com.Utilities.ExtentReportUtil;

import common.BaseClass;
import common.BaseMethods;
import common.Utils;

public class PB01_NewAccount extends BaseClass {

	
	
	
	@Test
	// PB_01 will create new account and perform adding account into the transaction history and verify if the account is created
		public void PB_01_NewAccount() throws IOException {
		
		ExtentReportUtil.logstep("PB_01 - Create new account");
		
	//	appObjects = new AppObjects(driver);
		mainPage = new MainPage(driver);
		registerPage = new RegisterPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		transactionHistory = new TransactionHistory(driver);	
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
		String WrongEmail=prop.getProperty("WrongEmail");
		String Iban=prop.getProperty("Iban");
		String Password=prop.getProperty("Password");
		String BeneficiaryName1=prop.getProperty("BeneficiaryName1");
		String AccountNumber1=prop.getProperty("AccountNumber1");
		String Amount1=prop.getProperty("Amount1");
		String BeneficiaryName2=prop.getProperty("BeneficiaryName2");
		String AccountNumber2=prop.getProperty("AccountNumber2");
		String Amount2=prop.getProperty("Amount2");
		String ToastEmail=prop.getProperty("ToastEmail");
		String ToastAccountCreated=prop.getProperty("ToastAccountCreated");
		
		// Register New Account        
			bm.clickOnElement(mainPage.registermain);
			registerPage.firstname.sendKeys(FirstName);
			registerPage.lastname.sendKeys(LastName);
			registerPage.email.sendKeys(WrongEmail);			
			registerPage.iban.sendKeys(Iban);
			registerPage.password.sendKeys(Password);
			registerPage.confirmpassword.sendKeys(Password);
			bm.clickOnElement(registerPage.male);
			bm.clickOnElement(registerPage.registerbtn1);
			bm.validateToast(ToastEmail);
	//		bm.validateToastEmail(ToastEmail);
			registerPage.email.clear();
			registerPage.email.sendKeys(Email);
			bm.clickOnElement(registerPage.registerbtn1);
			bm.validateToast(ToastAccountCreated);
			Reporter.log("Account Created",true);
			
		// Login newly created account	
			loginPage.username.sendKeys(Email);
			loginPage.password1.sendKeys(Password);
			bm.clickOnElement(loginPage.loginbtn);		
			
		// Add account inside transaction history page	
			bm.clickOnElement(homePage.transactionhistory);	
			bm.clickOnElement(transactionHistory.addbtn);
			transactionHistory.beneficiaryname.sendKeys(BeneficiaryName1);
			transactionHistory.accountnumber.sendKeys(AccountNumber1);
			transactionHistory.amount.sendKeys(Amount1);
			bm.clickOnElement(transactionHistory.sendmoneybtn);	
			bm.clickOnElement(transactionHistory.addbtn);
			transactionHistory.beneficiaryname.sendKeys(BeneficiaryName2);
			transactionHistory.accountnumber.sendKeys(AccountNumber2);
			transactionHistory.amount.sendKeys(Amount2);
			bm.clickOnElement(transactionHistory.sendmoneybtn);
			bm.validateIfCorrectTransaction(transactionHistory.beneficiaryamount1, Amount1);
			bm.validateIfCorrectTransaction(transactionHistory.beneficiaryamount2, Amount2);
			Reporter.log("Beneficiary Account Created",true);	
			
		// Navigate back to login page
			bm.navigateBack();
			bm.navigateBack();
			
			Reporter.log("Test case 1 : Finished",true);
			Reporter.log("    ",true);
		}
	
	
    
    
}
    
    
    
    
 
    
    
    
    
    
    




