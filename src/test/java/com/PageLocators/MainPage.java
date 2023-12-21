package com.PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainPage extends Utils {
	
	public AndroidDriver driver;
	
	public MainPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/login_main_button")
	public WebElement loginmain;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/register_button_main")
	public WebElement registermain;

}
