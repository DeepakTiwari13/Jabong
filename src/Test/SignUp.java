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

public class SignUp extends BaseClass{
	@Rule
	public ErrorCollector errcol = new ErrorCollector();
	
	@Before
	public void SystemInitialize() throws IOException{
		System.out.println("Initializing the system");
		Initialize();
		if(Util.isSkip("SignUp")){
		Assume.assumeTrue(false);
		}
		
			
	}
	@Test(expected = org.openqa.selenium.NoSuchElementException.class)  
	public void SignUPTest() throws IOException{
		System.out.println("Launching SignUp test");
		log.info("Starting Log---Launching SignUp test");
		driver.get(OR.getProperty("URL"));
		Util.serverresponse(OR.getProperty("URL"));
		//Util.ClosePopup();
		driver.findElement(By.xpath(OR.getProperty("SignUpLink"))).click();
		Util.SignUp2();
		/*((JavascriptExecutor) driver)
		.executeScript("alert('Sign Uptest')");*/
		Util.screenshot("SignUPTest");
		String AccountLink=driver.findElement(By.xpath(OR.getProperty("MyaccountLink"))).getText();
		Assert.assertEquals(AccountLink, "My Account");
		Util.Logout();
		
	/*	
		====================Sign up link old working code================================
	*/
	}	
		
	@After
	public void CloseAfterLaunch(){
		System.out.println("System exiting test");
				
	}

}
