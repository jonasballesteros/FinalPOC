package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


import common.BaseClass;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class Utils {
	static AndroidDriver driver;
	
	public Utils(AndroidDriver driver) {
		Utils.driver=driver;
	}
	
	public void waitApptoLoad() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	//assert text display
	 public void assertTextIsDisplayed(WebElement element) {
		{
		   String actualText = element.getText();
		   assert element.isDisplayed() : element + " is not displayed on the page /r /n - - - - - - - - - - - - - - -";
		   
		   System.out.println( actualText + " Text is displayed on the page");
		   System.out.println("- - - - - - - - - - - - - - -");
		}
	 }
	 
		public static void scrollDown() throws InterruptedException {
			((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 450, "width", 200, "height", 950,
				    "direction", "DOWN",
				    "percent", 10
				));
		}
	 
		public static void scollToText(String text) {
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
		
		}		
	
}