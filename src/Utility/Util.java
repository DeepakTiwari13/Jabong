package Utility;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Base.BaseClass;


public class Util extends BaseClass {
	@Rule
	public static ErrorCollector errcol = new ErrorCollector();

	public static void Utility() {

	}

	public static void Login1() {
		
		driver.findElement(By.xpath(OR.getProperty("LoginLink"))).click();

		try{
			driver.findElement(By.xpath("//a[@class='overlay-close vouchers-sprite pos-abs fr']")).click();
		
		}catch(Throwable t){
			System.out.println("Link not found "+"//a[@class='overlay-close vouchers-sprite pos-abs fr']");
			errcol.addError(t);
		}
		
		driver.findElement(By.xpath(OR.getProperty("LoginMail"))).sendKeys(
				OR.getProperty("LoginMail1"));
		driver.findElement(By.xpath(OR.getProperty("Loginpwd"))).sendKeys(
				OR.getProperty("Actualpwd"));
		driver.findElement(By.xpath(OR.getProperty("LoginButton"))).click();
		isloggedin = true;

	}

	public static void Login2(){
		
		driver.findElement(By.xpath(OR.getProperty("LoginLink"))).click();
		driver.findElement(By.xpath(OR.getProperty("LoginEmailID"))).sendKeys("kumar.deepaktiwari@gmail.com");
		driver.findElement(By.xpath(OR.getProperty("LoginPassword"))).sendKeys("deepak");
		driver.findElement(By.xpath(OR.getProperty("Button"))).click();
	}
	public static void SignUp2(){
		driver.findElement(By.xpath(OR.getProperty("FirstName"))).sendKeys(OR.getProperty("Name"));
		driver.findElement(By.xpath(OR.getProperty("LastName"))).sendKeys(OR.getProperty("LastN"));
		driver.findElement(By.xpath(OR.getProperty("EmailID"))).sendKeys(OR.getProperty("Email"));
		driver.findElement(By.xpath(OR.getProperty("Mobile"))).sendKeys(OR.getProperty("No."));
		driver.findElement(By.xpath(OR.getProperty("Password"))).sendKeys(OR.getProperty("pwd"));
		driver.findElement(By.xpath(OR.getProperty("ConfirmPassword"))).sendKeys(OR.getProperty("Cpwd"));
		driver.findElement(By.xpath(OR.getProperty("Gender"))).click();
		driver.findElement(By.xpath(OR.getProperty("Checkbox"))).click();
		driver.findElement(By.xpath(OR.getProperty("SignUpWithJabong"))).click();
		driver.findElement(By.xpath(OR.getProperty("ClosePopUp"))).click();
	}
	
	public static void Logout() {

		driver.findElement(By.xpath("//a[@id='login-lnk']")).click();
		isloggedin = false;

	}
	public static boolean screenshot(String Name) {
	try{
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File((System.getProperty("user.dir")
				+ "\\src\\Screenshot\\" + Name + ".jpg")));
		System.out.println("Screenshot has been taken successfully at "+(System.getProperty("user.dir")
				+ "\\src\\Screenshot\\" + Name + ".jpg"));
		return true;
	}catch(Throwable t){
		errcol.addError(t);
		return false;
	}
	}

	public static boolean serverresponse(String paige) throws IOException {

		URL url = new URL(paige);
		HttpURLConnection openConnection = (HttpURLConnection) url
				.openConnection();
		openConnection.connect();
		int rCode = openConnection.getResponseCode();
		System.out.println("Printing server response code for URL---" + paige
				+ " " + rCode);
		if (rCode == 200) {
			System.out.println("Function [serverresponse] returning true");
			return true;
		} else
			System.out.println("Function [serverresponse] returning false");
		return false;
	}

	public static boolean isElementexist(String Elementkey) {

		int Size = driver.findElements(By.xpath((OR.getProperty(Elementkey))))
				.size();

		if (Size == 0) {
			System.out.println("Function [isElementexist] returning false "
					+ Size);
			System.out.println("Element not present "+Elementkey);
			return false;
		} else
			System.out.println("Function [isElementexist] returning true  "
					+ Size);
		System.out.println("Element present "+Elementkey);
		return true;
	}

	public static boolean isElemenpresent(String xpathkey) {

		int Size = driver.findElements(By.xpath(xpathkey)).size();

		if (Size == 0) {
			System.out.println("Function [isElementexist] returning false "
					+ Size);
			System.out.println("Element not present "+xpathkey);
			return false;
		} else
			System.out.println("Function [isElementexist] returning true  "
					+ Size);
		System.out.println("Element present "+xpathkey);
		return true;
	}
	public static void ClosePopup(){
		try {
			driver.findElement(By.xpath(OR.getProperty("FirstPopup"))).click();
			System.out.println("Popup closed");
		} catch (Throwable t) {
			errcol.addError(t);
		}
	}
	// false - Y
		public static boolean isSkip(String testCase){
	//		Xls_Reader datatable = new Xls_Reader(System.getProperty("user.dir")+"\\src\\Config\\SuiteOne.xlsx");
			for(int rowNum=2 ; rowNum<=datatable.getRowCount("Test Cases");rowNum++){
				if(testCase.equals(datatable.getCellData("Test Cases", "TCID", rowNum))){
					if(datatable.getCellData("Test Cases", "Runmode", rowNum).equals("Y"))
						return false;
					else
						return true;
				}
			}
			
			return false;
		}
	
}
