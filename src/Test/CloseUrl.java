package Test;

import java.io.IOException;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
//import org.openqa.selenium.JavascriptExecutor;


import Utility.Util;
import Base.BaseClass;

public class CloseUrl extends BaseClass {

	@Rule
	public ErrorCollector errcol = new ErrorCollector();

	@Before
	public void SystemInitialize() throws IOException {
		
		System.out.println("Initializing the system");
		Initialize();
		if(Util.isSkip("CloseUrl")){
		Assume.assumeTrue(false);
		}
		

	}

	@Test(expected = org.openqa.selenium.remote.SessionNotFoundException.class)
	//Assume.assumeTrue(false);
	public void Closetest() throws IOException {
		System.out.println("Launching Close url test");
		log.info("Starting Log---Launching Close url test");
		driver.get(OR.getProperty("URL"));
		Util.serverresponse(OR.getProperty("URL"));
		// Util.ClosePopup();
		Util.screenshot("Closetest");
		/*((JavascriptExecutor) driver)
		.executeScript("alert('Launching Close url test')");*/
		String URL = driver.getCurrentUrl();
		System.out.println("Fetching current url " + URL);
		driver.quit();
	}

	@After
	public void CloseAfterLaunch() {
		System.out.println("System exiting test");

	}

}
