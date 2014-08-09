package Test;

import java.io.IOException;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
//import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import Utility.Util;
import Base.BaseClass;

public class LaunchUrl extends BaseClass {
	
	@Rule
	public ErrorCollector errcol = new ErrorCollector();

	@Before
	public void SystemInitialize() throws IOException {
		System.out.println("Initializing the system");
		Initialize();
		if(Util.isSkip("LaunchUrl")){
		Assume.assumeTrue(false);
		}
		

	}

	@Test
	public void LaunchUrlTest() throws IOException {
		System.out.println("Launching url test");
		log.info("Starting Log---Launching url test");
		driver.get(OR.getProperty("URL"));
		//Util.serverresponse(OR.getProperty("URL"));
		System.out.println(driver.getTitle());
		//Util.ClosePopup();
		/*((JavascriptExecutor) driver)
		.executeScript("alert('URL launch test')");*/
		Util.screenshot("LaunchUrlTest");
		Assert.assertTrue(Util.serverresponse(OR.getProperty("URL")), "URL launched ");
	}

	@After
	public void CloseAfterLaunch() {
		System.out.println("System exiting test");

	}
}
