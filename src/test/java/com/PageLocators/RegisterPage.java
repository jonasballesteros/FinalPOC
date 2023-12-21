package com.PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterPage extends Utils {
	
	public AndroidDriver driver;
	
	public RegisterPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
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
	
	

}
