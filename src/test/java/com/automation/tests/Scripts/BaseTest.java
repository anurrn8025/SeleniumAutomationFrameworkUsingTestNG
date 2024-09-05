package com.automation.tests.Scripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.tests.utilities.Constants;
import com.automation.tests.utilities.ExtentReportsUtility;
import com.automation.tests.utilities.Log4JUtility;
import com.automation.tests.utilities.PropertiesUtility;
import com.google.common.io.Files;

public class BaseTest {
	
	protected static WebDriver driver = null;
	protected static  WebDriverWait wait = null;
	protected Log4JUtility logObject=Log4JUtility.getInstance();
	protected static Logger myLog;
	protected ExtentReportsUtility report=ExtentReportsUtility.getInstance();

	@BeforeTest
	public void setupBeforeTest() {
		myLog=logObject.getLogger();
	}
	
	@BeforeMethod
	@Parameters("browsername")
	public void setUpBeforeTestMethod(@Optional("chrome") String browser_name) {
		PropertiesUtility pro1 = new PropertiesUtility();
		Properties p = pro1.createPropertyObject();
		pro1.loadFile("applicationDataProperties", p);
		String url = pro1.getPropertyValue("url", p);
		launchBrowser(browser_name);
		maximiseBrowser();
		goToUrl(url);
		
	}
	@AfterMethod
	public void tearDownAfterTestMethod() {
		//closeBrowser();
		System.out.println("******login_to_firebase automation script ended***********");
	}

	public static void launchBrowser(String browserName) {
		switch (browserName) {
		case "firefox":
			driver = new FirefoxDriver();
			System.out.println("firefox browser launched");
			break;
		case "chrome":
			driver = new ChromeDriver();
			System.out.println("chrome browser launched");
			break;
		default:
			System.out.println("you have not entrered the correct browser");

		}
	}

	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
		 File src=screenCapture.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
			myLog.info("captured the screen");
			report.logTestInfo("captured the screen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			myLog.error("captured the screen");
			report.logTestFailedWithException(e);
		}
	}
	
	public void takescreenshot(WebElement element,String filepath) {
		 File src=element.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			myLog.error("captured the screen");
			report.logTestFailedWithException(e);
		}
	}
	
	public static Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		System.out.println("switched to alert");
		return alert;
	}
	
	public static void acceptAlert(Alert alert) {
	
		System.out.println("alert accepted");
		alert.accept();
	}
	
	
	
	public static String getAlertText (Alert alert,String objectName ) {
		String text = alert.getText();
		System.out.println("text extracted");
		return text;
	}
	
	public static void dismissAlert(Alert alert) {
		
		System.out.println("alert dismissed");
		alert.dismiss();;
	}
	
	public static void goToUrl(String url) {
		driver.get(url);
		System.out.println(url + "is entered");
	}
	
	public static void selectByIndexData(WebElement ele,int index,String objectName) {
		waitForVisibility(ele,5,objectName);
		Select selectCity = new Select(ele);
		selectCity.selectByIndex(index);
		System.out.println(objectName + "selected with index"+index);
	}
	
	public static void waitForAlertPresent(int time) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void selectDropDown(WebElement ele, String objectName, Integer menuItem, String xpath) {

		if (ele.isEnabled()) {
			ele.click();
			System.out.println(objectName + "is clicked");
		} else {
			System.out.println(objectName + "is not enabled");
		}
		switch (menuItem) {

		case 1: {
			WebElement myProfileEle = driver.findElement(
					By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[1]"));
			myProfileEle.click();
			System.out.println(myProfileEle.getText() + "is entered");
			break;
		}

		case 2: {
			WebElement mySettingsEle = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
			mySettingsEle.click();
			System.out.println(mySettingsEle.getText() + "is entered");
			break;
		}
		case 3: {
			WebElement DevConsoleEle = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
			DevConsoleEle.click();
			System.out.println(DevConsoleEle.getText() + "is entered");
			break;
		}
		case 4: {
			WebElement LightningExpEle = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[4]"));
			LightningExpEle.click();
			System.out.println(LightningExpEle.getText() + "is entered");
			break;
		}
		case 5: {
			WebElement LogoutEle = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
			LogoutEle.click();
			System.out.println(LogoutEle.getText() + "is entered");
			break;
		}
		default:
			System.out.println("Invalid menuitem option selected" + "\n");
			break;

		}
	}

	public static void displayDrownDownItems() {

		List<WebElement> myElements = driver.findElements(By.cssSelector("#userNav-menuItems"));
		System.out.println("Size= " + myElements.size());
		for (WebElement e : myElements) {
			System.out.println(e.getText());
		}
	}	
	
	
	public static void displaySelectDrownDownList() {

		Select objSelect = new Select(driver.findElement(By.cssSelector("#fcf")));
		List <WebElement> elementCount = objSelect.getOptions();
		System.out.println(elementCount.size());
		for (WebElement e : elementCount) {
			System.out.println(e.getText());
		}
		
	}
	
	

	public static void maximiseBrowser() {
		driver.manage().window().maximize();
		System.out.println("browser window has maximized");
	}

	public static String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		System.out.println("extracted the text from" + objectName);
		return data;
	}

	/*
	 * public static boolean isFileDownloaded(String downloadPath, String fileName)
	 * { File dir = new File(downloadPath); File[] dirContents = dir.listFiles();
	 * 
	 * for (int i = 0; i < dirContents.length; i++) { if
	 * (dirContents[i].getName().equals(fileName)) { // File has been found, it
	 * cannow be deleted: dirContents[i].delete(); return true; } } return false; }
	 */

	public static boolean isFileDownloaded(String folderName) {
		// String folderName = "."; // Give your folderName
		File[] listFiles = new File(folderName).listFiles();
		System.out.println("listFiles.length = "+listFiles.length);
		boolean found = false;
		for (int i = 0; i < listFiles.length; i++) {
				String fileName = listFiles[i].getName();
				//System.out.println("fileName = "+ fileName);
				//if (fileName.startsWith("LoginHistory") && fileName.endsWith(".csv")) {
				if (fileName.startsWith("LoginHistory16")) {
					found = true;
				} 
			
		}
		return found;

	}
	
	public static boolean isFileDownloaded1(String folderName) {
		// String folderName = "."; // Give your folderName
		File[] listFiles = new File(folderName).listFiles();
		System.out.println("listFiles.length = "+listFiles.length);
		boolean found = false;
		for (int i = 0; i < listFiles.length; i++) {

			if (listFiles[i].isFile()) {
				String fileName = listFiles[i].getName();
				if (fileName.startsWith("LoginHistory") && fileName.endsWith(".csv")) {
					found = true;
				} else {
					found = false;
				}
			}
		}
		return found;

	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void enterText(WebElement ele, String data, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("data is entered in the " + ObjectName);
		} else {
			System.out.println(ObjectName + " element is not displayed");
		}
	}

	public static String GetValueFromAttribute(WebElement ele) {
		String value = ele.getAttribute("value");
		return value;
	}

	public static boolean compareActualExpectedStrings(String actual, String expected) {
		if (actual.equals(expected))
			return true;
		else {
			return false;
		}
	}

	public static void clickElement(WebElement ele, String ObjectName) {
		if (ele.isEnabled()) {
			ele.click();
			System.out.println(ObjectName + "button is clicked");
		} else {
			System.out.println("button element is not enabled");
		}
	}
	
	public static void clickRadioButton(String xpath,Integer value,String ObjectName) {
		List<WebElement> radio_button  = driver.findElements(By.xpath(xpath));
			radio_button.get(value).click();
	}

	public static void waitForVisibility(WebElement ele, int time, int pollingtime, String objectName) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time)).pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOf(ele));
		System.out.println(objectName + " is waited for visibility using fluent wait");
	}

	public static void waitForVisibility(WebElement ele, int time, String objectNam) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			System.out.println(ObjectName + " is cleared");
		} else {
			System.out.println(ObjectName + " element is not displayed");
		}
	}

	public static void switchToFrame(WebElement ele, String objectNam) {
		driver.switchTo().frame(ele);
		System.out.println(objectNam + " Frame entered");
	}

	public static void waitForClickable(WebElement ele, int time, int pollingtime, String objectName) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time)).pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.elementToBeClickable(ele));
		System.out.println(objectName + " is waited for elementToBeClickable using fluent wait");
	}

	public String getPageTitle() {
		myLog.info("page tittle is returned");
		return driver.getTitle();
	}
}
