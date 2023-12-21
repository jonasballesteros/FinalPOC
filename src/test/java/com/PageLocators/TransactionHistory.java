package com.PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TransactionHistory extends Utils {
	
	public AndroidDriver driver;
	
	public TransactionHistory(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
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
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView")
	public WebElement beneficiaryamount1;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView")
	public WebElement beneficiaryamount2;
	

}
