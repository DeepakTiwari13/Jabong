package Test;

import java.io.IOException;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import Utility.Util;
import Base.BaseClass;

public class LoginTest extends BaseClass {
	@Rule
	public ErrorCollector errcol = new ErrorCollector();
	@Before
	public void SystemInitialize() throws IOException{
		System.out.println("Initializing the system");
		Initialize();
		if(Util.isSkip("LoginTest")){
		Assume.assumeTrue(false);
		}
		
		
			
	}
	@Test
	public void Logintest() throws IOException{
		System.out.println("Launching Login test");
		log.info("Starting Log---Launching Login test");
		driver.get(OR.getProperty("URL"));
		Util.serverresponse(OR.getProperty("URL"));
		Util.Login2();
		String AccountLink=driver.findElement(By.xpath(OR.getProperty("MyaccountLink"))).getText();
		Assert.assertEquals(AccountLink, "My Account");
		/*((JavascriptExecutor) driver)
		.executeScript("alert('Login Test')");*/
		Util.screenshot("Logintest");
		Util.Logout();
			
	
	}	
		
	@After
	public void CloseAfterLaunch(){
		System.out.println("System exiting test");
				
	}

}
