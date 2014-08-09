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

public class Shoes extends BaseClass {

	@Rule
	public ErrorCollector errcol = new ErrorCollector();

	@Before
	public void SystemInitialize() throws IOException {
		System.out.println("Initializing the system");
		Initialize();
		if(Util.isSkip("Shoes")){
		Assume.assumeTrue(false);
		}
		

	}

	@Test
	public void ShoesLinkTest() throws IOException {
		System.out.println("Launching ShoesLinkTest test");
		log.info("Starting Log---Launching ShoesLinkTest test");
		driver.get(OR.getProperty("URL"));

/*		String Part1 = "//*[@id='qa-navigation0']/div/div/div[1]/a[";
		String Part2 = "]";

		int i = 1;
		// while (Util.isElemenpresent(Part1 + i + Part2)) {
		if (Util.isElemenpresent(Part1 + i + Part2)) {
			Actions act1 = new Actions(driver);
			WebElement element1 = driver
					.findElement(By
							.xpath("//a[@href='http://www.jabong.com/new-arrivals/?source=topnav']"));
			act1.moveToElement(element1).build().perform();

			WebDriverWait wait1 = new WebDriverWait(driver, 50);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//li[@id='qa-navigation0']/div/div")));

			driver.findElement(By.xpath(Part1 + i + Part2)).click();

			System.out.println("Url visited  "
					+ driver.findElement(By.xpath(Part1 + i + Part2))
							.getAttribute("href"));

			String URLfired = driver.findElement(By.xpath(Part1 + i + Part2))
					.getAttribute("href");

			Util.serverresponse(URLfired);
			String PageLink = driver.getTitle();
			System.out.println("Printing visited page title " + PageLink);
			Util.ClosePopup();
			Util.screenshot("ShoesLinkTest");
			// i++;

		} else {
			System.out.println("Something went wrong.Link not found");
			Assert.fail("Something went wrong.Link not found");
		}*/
		WebElement element1 = GetObject("NewIN");
		Actions act1 = new Actions(driver);
		act1.moveToElement(element1).build().perform();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("LinkContainer"))));
		
		GetObject("MenShoeLink").click();
		String openurl=driver.getCurrentUrl();
		Util.serverresponse(openurl);
	/*	((JavascriptExecutor) driver)
		.executeScript("alert('Shoe Link test')");*/
		Util.screenshot("ShoesLinkTest");
		String text= GetObject("Menshoesnewarrival").getText();
		System.out.println("Total shoe product "+text);
		Assert.assertNotNull("Showe page content present ", text);
		
	}

	@After
	public void CloseAfterLaunch() {
		System.out.println("System exiting test");

	}
}
