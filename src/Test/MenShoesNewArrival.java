package Test;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.Util;
import Base.BaseClass;

public class MenShoesNewArrival extends BaseClass {

	@Rule
	public ErrorCollector errcol = new ErrorCollector();

	@Before
	public void SystemInitialize() throws IOException {
		System.out.println("Initializing the system");
		Initialize();
		if(Util.isSkip("MenShoesNewArrival")){
		Assume.assumeTrue(false);
		}
		

	}

	@Test
	public void ShoesNewArrivalTest() throws IOException, InterruptedException {
		System.out.println("Launching ShoesNewArrival test");
		log.info("Starting Log---Launching ShoesNewArrival test");
		driver.get(OR.getProperty("MenShoesNewArrivalsURL"));
		// Loading the URL
		// driver.findElement(By.xpath(OR.getProperty("MenShoeLink"))).click();
		String URLfired = driver.getCurrentUrl();

		// Checking server response code
		if (Util.serverresponse(URLfired)) {

			String PageLink = driver.getTitle();
			System.out.println("Printing visited page title " + PageLink);
			Util.ClosePopup();
			String TotalShoes = driver.findElement(
					By.xpath((OR.getProperty("shoequantitydisplayedonpage"))))
					.getText();
			System.out.println("Total present " + TotalShoes);
			// code to scroll down the page

			int a = 0;
			while (a < 30) {
				Actions actions = new Actions(driver);
				actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				Thread.sleep(5000l);
				a++;
			}

			Util.screenshot("ShoesLinkTest");

			WebElement box = driver.findElement(By.xpath(OR
					.getProperty("ShoeList")));
			List<WebElement> ShoeList = box.findElements(By.tagName("li"));

			System.out.println("=================*=====================");
			System.out.println("Number of shoes available  " + ShoeList.size());
			System.out.println("=================*=====================");

			for (int i = 0; i < ShoeList.size(); i++) {
				System.out.println(ShoeList.get(i).getText());
			}
			/*((JavascriptExecutor) driver)
			.executeScript("alert('List displayed [ShoesNewArrivalTest] Test')");*/
			String FinalText = driver.findElement(
					By.xpath(OR.getProperty("Nomoreresult"))).getText();
			System.out.println("Page end text " + FinalText);
			Assert.assertNotNull(FinalText);
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
