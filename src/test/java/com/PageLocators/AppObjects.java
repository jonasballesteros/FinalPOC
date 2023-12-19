package com.PageLocators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import common.Utils;
import com.Utilities.ExtentReportUtil;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppObjects extends Utils{
	public AndroidDriver driver;
	
	public AppObjects(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	@AndroidFindBy(id="com.example.proiectmobilebanking:id/login_main_button")
	public WebElement loginmain;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/register_button_main")
	public WebElement registermain;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/register_button")
	public WebElement registerbtn;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/et_firstName")
	public WebElement firstname;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/et_lastName")
	public WebElement lastname;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/et_email")
	public WebElement email;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/et_iban")
	public WebElement iban;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/et_password")
	public WebElement password;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/et_confirmPassword")
	public WebElement confirmpassword;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/rb_male")
	public WebElement male;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/bt_register")
	public WebElement registerbtn1;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/tv_username")
	public WebElement username;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/tv_password")
	public WebElement password1;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/login_button")
	public WebElement loginbtn;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/imgHistory")
	public WebElement transactionhistory;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/fabAdd")
	public WebElement addbtn;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/et_beneficiary2")
	public WebElement beneficiaryname;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/et_accountNumber2")
	public WebElement accountnumber;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/et_amount2")
	public WebElement amount;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/btn_send2")
	public WebElement sendmoneybtn;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/btnRaport")
	public WebElement raports;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/btnRaportAmount")
	public WebElement alltransactionbyamount;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/etRaportAmount")
	public WebElement raportamount;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/btnViewRaportAmount")
	public WebElement viewreport;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/btnDeleteAccount")
	public WebElement deleteaccount;
	
	@AndroidFindBy(xpath=".//*[contains(@text, 'Account erased')]")
	public WebElement toastmessage;
	
	@AndroidFindBy(xpath="com.example.proiectmobilebanking:id/tv_amount")
	public WebElement viewreportamount;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/tv_amount")
	public WebElement reportamount;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView")
	public WebElement beneficiaryamount1;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView")
	public WebElement beneficiaryamount2;
	
	
	
	
	}
	


	 



	
	



