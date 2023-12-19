package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.ExtentReportUtil;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseMethods extends Utils {
	
public AndroidDriver driver;
	
	public BaseMethods(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	//For Passed Steps, get screenshot
	public String passedGetScreenshot() {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	  //String for saving the screenshot to desired path
		String destination = System.getProperty("user.dir") + "\\ExtentReport\\PassedTestsScreenshots\\Passed - "+dateName+".jpeg";
		//String for the output for extent report
		String screenshotLoc = "../PassedTestsScreenshots/Passed - "+dateName+".jpeg";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotLoc;
	}
	//For Failed Steps, get screenshot
	public String failedGetScreenshot() {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	    //String for saving the screenshot to desired path
		String destination = System.getProperty("user.dir") + "\\ExtentReport\\FailedTestsScreenshots\\Error - "+dateName+".png";
		//String for the output for extent report
		String screenshotLoc = "../FailedTestsScreenshots/Error - "+dateName+".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotLoc;
	}	
		
		
		public void clickOnElement(WebElement ele) {
			boolean status = false;
			try {
				ele.click();
				status = true;
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if (status==true) {
				
				ExtentReportUtil.pass("Element Clicked");
				ExtentReportUtil.logger.log(LogStatus.PASS, ExtentReportUtil.logger.addScreenCapture(passedGetScreenshot()));
								
			}
			
			else {
				
				ExtentReportUtil.fail("Element Not Clicked");
				ExtentReportUtil.logger.log(LogStatus.FAIL, ExtentReportUtil.logger.addScreenCapture(failedGetScreenshot()));
				
			}
						
		
		}
		
		public void navigateBack() {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			ExtentReportUtil.pass("Navigated Back");
			ExtentReportUtil.logger.log(LogStatus.PASS, ExtentReportUtil.logger.addScreenCapture(passedGetScreenshot()));
		
		}
		

		public void validateIfDisplayedTrue(WebElement ele) {
		Assert.assertTrue(ele.isDisplayed());
		System.out.println("View Raport Amount is Displayed");
		
		}	
		
		public String getAccountErased() {
			WebElement toastElem = driver.findElement(By.xpath(".//*[contains(@text, 'Account erased')]"));
			ExtentReportUtil.pass("Account Erased");
			ExtentReportUtil.logger.log(LogStatus.PASS, ExtentReportUtil.logger.addScreenCapture(passedGetScreenshot()));
			return toastElem.getText();
			
			
			
		}
		
		public String getInvalidUsername() {
			WebElement toastElem = driver.findElement(By.xpath(".//*[contains(@text, 'Invalid username or password!')]"));
			ExtentReportUtil.pass("Invalid Username");
			ExtentReportUtil.logger.log(LogStatus.PASS, ExtentReportUtil.logger.addScreenCapture(passedGetScreenshot()));
			return toastElem.getText();
		}
		
		public String verifyReportAmount() throws IOException {
			
			Properties prop=new Properties();
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.properties");
			prop.load(fis);
			String Amount1=prop.getProperty("Amount1");
			WebElement reportamount = driver.findElement(By.id("com.example.proiectmobilebanking:id/tv_amount"));
			ExtentReportUtil.fail("Amount Not Matched");
			ExtentReportUtil.logger.log(LogStatus.FAIL, ExtentReportUtil.logger.addScreenCapture(failedGetScreenshot()));
			return reportamount.getText();
			
		}
		
		
		public void validateIfCorrectText(WebElement ele, String expectedValue) {
			String actualValue = null;
			
			try {
				actualValue = ele.getText();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (actualValue.contentEquals(expectedValue)) {
				ExtentReportUtil.pass("Text matched");
				ExtentReportUtil.logger.log(LogStatus.PASS, ExtentReportUtil.logger.addScreenCapture(passedGetScreenshot()));
				
				
			}
			
			else {
				ExtentReportUtil.fail("Text not matched");
				ExtentReportUtil.logger.log(LogStatus.FAIL, ExtentReportUtil.logger.addScreenCapture(failedGetScreenshot()));
			}
						
				
			}

}
