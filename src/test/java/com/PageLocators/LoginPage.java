package com.PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends Utils {
	
	public AndroidDriver driver;
	
	public LoginPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/tv_username")
	public WebElement username;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/tv_password")
	public WebElement password1;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/login_button")
	public WebElement loginbtn;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/register_button")
	public WebElement registerbtn;

}
