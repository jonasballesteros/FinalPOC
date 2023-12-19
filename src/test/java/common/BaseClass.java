package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.PageLocators.AppObjects;
import com.Utilities.ExtentReportUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class BaseClass {
	
	public static AndroidDriver driver;
	public static AppObjects appObjects;
	public static BaseMethods bm;
	public static Utils utils;
	public static ITestResult result;
		
	public static String userName = System.getenv("BROWSERSTACK_USERNAME"); 
	public static String accessKey = System.getenv("BROWSERSTACK_ACCESSKEY"); 
	public static String buildName_PocketBank = System.getenv("BROWSERSTACK_BUILD_NAME"); 
	
//	public static String userName = "jonasballesteros_i5wYOf"; 
//	public static String accessKey = "gBtapnNFu3CLsyHZB8wr"; 
//	public static String buildName_PocketBank = "Jonas POC";
	
	
	public static String app_PocketBank ="bs://f7c9b6de7ab21b94085a649a501359b0ff17370e"; 
	
    public static String URL = "http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
    
    @BeforeSuite
   	public void setupReport() {
   		ExtentReportUtil.startExtentReport("\\Reports\\Test.html");
   	}  
	
	
	
		
    @BeforeTest(alwaysRun = true)
    public void setUp() throws IOException {
    	MutableCapabilities capabilities = new UiAutomator2Options();
    	
    	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
    	     	
    	browserstackOptions.put("appiumVersion", "2.0.1");
    	capabilities.setCapability("bstack:options", browserstackOptions);  	
		capabilities.setCapability("deviceName", "Samsung Galaxy S21");
		capabilities.setCapability("os_Version", "12.0");
		capabilities.setCapability("Project","Jonas POC"); 
		capabilities.setCapability("build", buildName_PocketBank); 
		capabilities.setCapability("name", buildName_PocketBank);
		capabilities.setCapability("app", app_PocketBank); 
 
		driver = new AndroidDriver(new URL(URL), capabilities);
            
    }
    
    	
    @AfterMethod(alwaysRun=true)
    public void afterMethod(ITestResult result) throws Exception {		    	
    	ExtentReportUtil.getExtentResult(result);
		
    }
    
	 @AfterTest(alwaysRun = true)
    public void tearDown() {
    	System.out.print(" ");
    	driver.quit();   	
    	    	
    	
    }
	 
	 @AfterSuite
		public void endTest() {
			ExtentReportUtil.flushExtentReport();
			ExtentReportUtil.closeExtentReport();
			
		}
}