package Test;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Util;
import Base.BaseClass;

public class Clothings extends BaseClass {

	@Rule
	public ErrorCollector errcol = new ErrorCollector();

	@Before
	public void SystemInitialize() throws IOException {
		System.out.println("Initializing the system");
		Initialize();
		if(Util.isSkip("Clothings")){
		Assume.assumeTrue(false);
		}
		
	}

	@Test
	public void ClothLinkTest() throws IOException, InterruptedException {
		System.out.println("Launching ClothLinkTest test");
		log.info("Starting Log---Launching ClothLinkTest test");
		driver.get(OR.getProperty("URL"));
		
		Actions act1 = new Actions(driver);
		WebElement element1 = driver
				.findElement(By
						.xpath("//a[@href='http://www.jabong.com/new-arrivals/?source=topnav']"));
		act1.moveToElement(element1).build().perform();
		//Thread.sleep(2000L);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 25);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(OR.getProperty("HoverList"))));
		//Checking whether link is present or not		
		if (Util.isElemenpresent(OR.getProperty("SecondLinkCloth"))) {
	
			driver.findElement(By.xpath(OR.getProperty("SecondLinkCloth"))).click();

			System.out.println("Url visited  "
					+ driver.getTitle());

			String URLfired = driver.getCurrentUrl();
			/*((JavascriptExecutor) driver)
			.executeScript("alert('ClothLinkTest')");*/
			//Checking server response code
			Util.serverresponse(URLfired);
			//String PageLink = driver.getTitle();
			//System.out.println("Printing visited page title " + PageLink);
			//Util.ClosePopup();
			//Util.screenshot("ClothLinkTest");
			Assert.assertTrue(Util.screenshot("ClothLinkTest"));

		} else {
			System.out.println("Something went wrong.Link not found");
			Assert.fail("Something went wrong.Link not found");
		}

	}

	@After
	public void CloseAfterLaunch() {
		System.out.println("System exiting test");

	}
}
