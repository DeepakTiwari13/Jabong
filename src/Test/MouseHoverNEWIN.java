package Test;

import java.io.IOException;
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

public class MouseHoverNEWIN extends BaseClass {
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
	public void MouseHoverNewInTest() throws IOException, InterruptedException {
		System.out.println("Launching MouseHoverNewInTest test");
		log.info("Starting Log---Mouse Hover New in test");
		driver.get(OR.getProperty("URL"));
		
		
		//String NEWIN = driver
				//.findElement(
						//By.xpath("//a[@href='http://www.jabong.com/new-arrivals/?source=topnav']"))
				//.getAttribute("href");
		String NEWIN = driver.getCurrentUrl();
		Util.serverresponse(NEWIN);
		//Util.ClosePopup();
		
		Actions act = new Actions(driver);
		WebElement element = driver
				.findElement(By
						.xpath(OR.getProperty("NewIn")));
		act.moveToElement(element).build().perform();
		

		/*
		 * WebElement element = driver.findElement(By.xpath(
		 * "//a[@href='http://www.jabong.com/new-arrivals/?source=topnav']"));
		 * Locatable hoverItem = (Locatable) element; Mouse mouse =
		 * ((HasInputDevices) driver).getMouse();
		 * mouse.mouseMove(hoverItem.getCoordinates()); //Thread.sleep(5000);
		 * ====Working code of mouse hover=====
		 */
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(OR.getProperty("NewInList"))));
		Util.screenshot("MouseHoverNewInTest");

		WebElement NewIN = driver.findElement(By
				.xpath(OR.getProperty("CustomizedXpath")));
		List<WebElement> AllData = NewIN.findElements(By.tagName("a"));
		System.out.println("Total links available under NEW IN popup "
				+ AllData.size());
		
		Assert.assertFalse(AllData.isEmpty(), "No item found in list" );

		for (int i = 0; i < AllData.size(); i++) {
			System.out.println("Printing links available under NEW IN popup "
					+ AllData.get(i).getText());
		}
		/*((JavascriptExecutor) driver)
		.executeScript("alert('List displayed [MouseHoverNewInTest]')");*/
	}

	@After
	public void CloseAfterLaunch() {
		System.out.println("System exiting test");

	}

}
