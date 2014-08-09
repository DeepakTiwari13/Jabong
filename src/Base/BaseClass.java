package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import datatable.Xls_Reader;

public class BaseClass {
	// Base class for initialization
	// intitializing or.properties file
	public static Properties OR = null;
	// intitializing config.properties file
	public static Properties CON = null;
	// initializing webdriver
	public static WebDriver dr = null;
	// initializing eventfiringwebdriver
	public static EventFiringWebDriver driver = null;
	// initializing isloggedin variable
	public static boolean isloggedin = false;
	// initializing datatable
	public static Xls_Reader datatable= null;

	public static Logger log = Logger.getLogger("BaseClass");

	public static void Initialize() throws IOException {
		
		

		if (driver == null) {

			// defining OR properties file
			OR = new Properties();
			FileInputStream reader = new FileInputStream(
					System.getProperty("user.dir")
							+ "//src//Config//or.properties");
			OR.load(reader);
			// defining CON properties file
			CON = new Properties();
			FileInputStream conreader = new FileInputStream(
					System.getProperty("user.dir")
							+ "//src//Config//config.properties");
			CON.load(conreader);

			// Checking browser from config.properties file
			if (CON.getProperty("Browser").equals("Chrome")) {
				System.out.println("Launching ChromeDriver");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")
								+ "//src//Drivers//chromedriver.exe");
				dr = new ChromeDriver();
			}
			// Checking browser from config.properties file
			else if (CON.getProperty("Browser").equals("IE")) {
				System.out.println("Launching InternetExplorerDriver");
				File file = new File(System.getProperty("user.dir")
						+ "//src//Drivers//IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver",
						file.getAbsolutePath());
				dr = new InternetExplorerDriver();
			}
			
			
			else if (CON.getProperty("Browser").equals("Firefox")) {
				System.out.println("Launching FirefoxDriver");
				File file = new File(System.getProperty("user.dir")
						+ "//src//Drivers//firefox.exe.exe");
				System.setProperty("webdriver.Firefox.driver",
						file.getAbsolutePath());
				dr = new FirefoxDriver();
			}
			
			datatable = new Xls_Reader(System.getProperty("user.dir")+"\\src\\Config\\SuiteOne.xlsx");
			
			driver = new EventFiringWebDriver(dr);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
		}
	}

	public static WebElement GetObject(String xpathkey) {
		try {
			return driver.findElement(By.xpath(OR.getProperty(xpathkey)));
		} catch (Exception e) {
			Assert.fail("Element not found "+OR.getProperty(xpathkey));
			System.out.println("Element not found "+OR.getProperty(xpathkey)+e.fillInStackTrace());
		}
		return null;
	}
}
