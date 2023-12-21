package com.PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends Utils {
	public AndroidDriver driver;
	
	public HomePage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/imgHistory")
	public WebElement transactionhistory;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/btnRaport")
	public WebElement raports;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/btnDeleteAccount")
	public WebElement deleteaccount;
	

}
