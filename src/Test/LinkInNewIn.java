package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
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
import org.testng.Assert;

import Utility.Util;
import Base.BaseClass;

public class LinkInNewIn extends BaseClass {
	
	static ArrayList<String> Titles =null;
	@Rule
	public ErrorCollector errcol = new ErrorCollector();

	@Before
	public void SystemInitialize() throws IOException {
		System.out.println("Initializing the system");
		Initialize();
		if(Util.isSkip("LinkInNewIn")){
		Assume.assumeTrue(false);
		}
		

	}

	@Test
	public void NewInMENSectionTest() throws IOException, InterruptedException {
		System.out.println("Launching NewInMENSectionTest test");
		log.info("Starting Log---Mouse Hover NewInMENSectionTest test");
		driver.get(OR.getProperty("URL"));
		
		
		/*String NEWIN = driver
				.findElement(
						By.xpath("//a[@href='http://www.jabong.com/new-arrivals/?source=topnav']"))
				.getAttribute("href");
		Util.serverresponse(NEWIN);
		Util.ClosePopup();
		
		Actions act = new Actions(driver);
		WebElement element = driver
				.findElement(By
						.xpath("//a[@href='http://www.jabong.com/new-arrivals/?source=topnav']"));
		act.moveToElement(element).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//li[@id='qa-navigation0']/div/div")));
		Util.screenshot("MouseHoverNewInTest");

		WebElement NewIN = driver.findElement(By
				.xpath("//li[@id='qa-navigation0']/div/div"));
		List<WebElement> AllData = NewIN.findElements(By.tagName("a"));
		System.out.println("Total links available under NEW IN popup "
				+ AllData.size());

		String Part1 = "//*[@id='qa-navigation0']/div/div/div[1]/a[";
		String Part2 = "]";

		int i = 1;
		while (Util.isElemenpresent(Part1 + i + Part2)) {
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
			String URLfired= driver.getCurrentUrl();
			Util.serverresponse(URLfired);
			String PageLink = driver.getTitle();
			Util.screenshot("MouseHoverNewInTest "+i);
			
			final ArrayList<String> Titles = new ArrayList<String>();
			Titles.add(PageLink);
			

			try {
				Assert.assertNotNull("Page title not available", PageLink);
			} catch (Throwable t) {
				System.out.println("Page title not availabe  ");
				errcol.addError(t);
			}

			System.out.println("Opened page title  " + PageLink);
			driver.get(OR.getProperty("URL"));
			i++;
		}*/
		WebElement element1 = GetObject("NewIN");
		Actions act1 = new Actions(driver);
		act1.moveToElement(element1).build().perform();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("LinkContainer"))));
		
		WebElement NewIN = GetObject("LinkContainer");
		List<WebElement> AllData = NewIN.findElements(By.tagName("a"));
		System.out.println("Total links available under NEW IN popup "
				+ AllData.size());
		
		for(int i=0;i<AllData.size();i++){
			
			WebElement element2 = GetObject("NewIN");
			Actions act2 = new Actions(driver);
			act2.moveToElement(element2).build().perform();
			
			WebDriverWait wait2 = new WebDriverWait(driver, 50);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("LinkContainer"))));
			
			WebElement NewIN2 = GetObject("LinkContainer");
			List<WebElement> AllData3 = NewIN2.findElements(By.tagName("a"));
			Util.serverresponse(AllData3.get(i).getAttribute("href"));
			
			System.out.println(AllData3.get(i).getText());
			System.out.println("**************Printing Product Category**************");
			AllData3.get(i).click();
			String PageLink = driver.getTitle();
			//Util.serverresponse(AllData3.get(i).getAttribute("href"));
			final ArrayList<String> Titles = new ArrayList<String>();
			Titles.add(PageLink);
			Util.screenshot("NewInMENSectionTest "+i);
			driver.get(OR.getProperty("URL"));
		}
		/*((JavascriptExecutor) driver)
		.executeScript("alert('All links clicked [NewInMENSectionTest]')");*/	
		Assert.assertNotNull(Titles.isEmpty());
	}

	@After
	public void CloseAfterLaunch() {
		System.out.println("System exiting test");

	}

}
