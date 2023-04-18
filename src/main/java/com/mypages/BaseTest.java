/**
 * 
 */
package com.mypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Utility.Utility;
import com.config.configProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author thilina.karunarathna
 *
 */
public class BaseTest {

	protected WebDriver driver;
	public Page page;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	@BeforeClass
	public static void beforeClass() {
		configProperties.initializeConfigProperty();
	}
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public WebDriver setUpTest() {
		if(configProperties.property.getProperty("BrowserType").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(configProperties.property.getProperty("BrowserType").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("no browser is defined in xml file...");
		}
		
		driver.get(configProperties.property.getProperty("URL"));
		driver.manage().window().maximize();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page = new BasePage(driver);
		tdriver.set(driver);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}


	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			Utility.getScreenshot(driver);
		}
		driver.quit();
	}
	
	@AfterClass
	public void afterClass() {	}	
}
