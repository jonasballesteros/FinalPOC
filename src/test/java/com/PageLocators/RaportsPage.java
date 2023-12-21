package com.PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RaportsPage extends Utils {
	
	public AndroidDriver driver;
	
	public RaportsPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/btnRaportAmount")
	public WebElement alltransactionbyamount;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/etRaportAmount")
	public WebElement raportamount;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/btnViewRaportAmount")
	public WebElement viewreport;
	
	@AndroidFindBy(xpath="com.example.proiectmobilebanking:id/tv_amount")
	public WebElement viewreportamount;
	
	@AndroidFindBy(id="com.example.proiectmobilebanking:id/tv_amount")
	public WebElement reportamount;

}
