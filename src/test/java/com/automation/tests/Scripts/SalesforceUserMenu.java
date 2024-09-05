package com.automation.tests.Scripts;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
// design pattern --- page object model
import com.automation.tests.Base.BaseTest;
import com.automation.tests.utilities.PropertiesUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.tests.utilities.PropertiesUtility;

public class SalesforceUserMenu extends BaseTest{
	

	

	@Test
	public void UserMenuDropDown () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******salesforce - UserMenuDropDown automation script started***********");
		System.out.println("******salesforce - UserMenuDropDown automation script started**********");
		String expected="Home Page ~ Salesforce - Developer Edition";
		launchBrowser("firefox");
		maximiseBrowser();
		goToUrl("https://login.salesforce.com/");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,"anusha@cognizant.com","username textbox");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle,"Shundu1234","password textbox");
		WebElement buttonEle=driver.findElement(By.id("Login"));
		clickElement(buttonEle,"login button");
		
		Thread.sleep(2000);
		String actual=driver.getTitle();
		
		WebElement userMenuDropDown=driver.findElement(By.id("userNav-arrow"));
		clickElement(userMenuDropDown,"userMenuDropDown button");
		
		List<WebElement> allOptions = driver.findElements(By.cssSelector("#userNav-menuItems"));
		
		String option = "My Profile";
		for (int i = 0; i < allOptions.size(); i++) {
			//PRINT ALL OPTION ON USER MENU
			System.out.println("OPTION :"+ allOptions.get(i).getText());
			if (allOptions.get(i).getText().contains(option)) {
				System.out.println("User Menu Option Present . TC Passed");
				break;
				}
		}

		if(actual.equals(expected))
			System.out.println("salesforce - UserMenuDropDown testcase passed");
		else {
			System.out.println("salesforce - UserMenuDropDown testcase failed");
		}
		
		//closeBrowser();
		System.out.println("******salesforce - UserMenuDropDown automation script ended***********");
		myLog.info("******salesforce - UserMenuDropDown automation script completed***********");
		
	}
	
	
	@Test
	public void login () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******salesforce - login automation script started***********");
		String expected="Home Page ~ Salesforce - Developer Edition";
		launchBrowser("chrome");
		maximiseBrowser();
		goToUrl("https://login.salesforce.com/");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,"anusha@cognizant.com","username textbox");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle,"Shundu1234","password textbox");
		WebElement buttonEle=driver.findElement(By.id("Login"));
		clickElement(buttonEle,"login button");
		
		Thread.sleep(2000);
		String actual=driver.getTitle();
		if(actual.equals(expected))
			System.out.println("login_to_SalesForce testcase passed");
		else {
			System.out.println("login_to_SalesForce testcase failed");
		}
		
		
		WebElement userMenuDropDown=driver.findElement(By.id("userNav-arrow"));
		clickElement(userMenuDropDown,"userMenuDropDown button");
		
		System.out.println("******salesforce - login automation script ended***********");
		myLog.info("******salesforce - login automation script completed***********");
		}
		
	@Test
	public void editMyProfile() throws InterruptedException {
		//log4j: log
		//extent report
		login();
		myLog.info("******salesforce - editMyProfile automation script started***********");
		WebElement userMenuDropDown=driver.findElement(By.id("userNav-arrow"));
		clickElement(userMenuDropDown,"userMenuDropDown button");
		
	   List<WebElement> myElements = driver.findElements(By.cssSelector("#userNav-menuItems"));
	   System.out.println("Size= "+ myElements.size());
       for(WebElement e : myElements) {
    	   System.out.println(e.getText());
        // if(e.getText().equals("My Profile")) {
    	   if( e.getText().contains("My Profile")) {
        	 System.out.println("found");
         }
       }
       
       WebElement myProfileEle=driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[1]"));
		clickElement(myProfileEle,"my Profile");
	
		Thread.sleep(5000);
		
		WebElement EditEle=driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[2]/div[1]/h3/div/div/a"));
		EditEle.click();
		
		WebElement frameEle=driver.findElement(By.xpath("//*[@id=\"contactInfoContentId\"]"));
		driver.switchTo().frame(frameEle);
		System.out.println("Inside Edit profile frame");
		
		Thread.sleep(2000);
		
		WebElement AboutEle=driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		clickElement(AboutEle,"About");
		
		WebElement lastNameEle=driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
		enterText(lastNameEle,"Aravinnakshan","lastName textbox");
		String expLastName = "Aravinnakshan";
		
		
		WebElement saveAllEle=driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		clickElement(saveAllEle,"Save All button");
		
		driver.navigate().to("https://cts492-dev-ed.develop.my.salesforce.com/_ui/core/userprofile/UserProfilePage?tab=sfdc.ProfilePlatformFeed");
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
	
		WebElement lastNameEle1=driver.findElement(By.id("tailBreadcrumbNode"));
		System.out.println("lastNameEle1 = " + lastNameEle1.getText());
		
		//get last name
		String actLastName = lastNameEle1.getText();
		String[] words = actLastName.split("\\s+");
		actLastName = words[1];
	    System.out.println("actLastName = " + actLastName);
		
		if(actLastName.equals(expLastName))
			System.out.println("Last name modified : testcase passed");
		else {
			System.out.println("Last name not modified : testcase failed");
		}
	
		
		System.out.println("******salesforce - editMyProfile automation script ended***********");
		myLog.info("******salesforce - editMyProfile automation script completed***********");
		}
	
	
	@Test
	public void postLink() throws InterruptedException {
		//log4j: log
		//extent report
		login();
		myLog.info("******salesforce - postLink automation script started***********");
		
		WebElement myProfileEle=driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[1]"));
		clickElement(myProfileEle,"my Profile");
		
		WebElement postLinkEle=driver.findElement(By.id("publisherAttachTextPost"));
		clickElement(postLinkEle,"Post Link");
		
		Thread.sleep(2000);
		//WebElement postLinkFrameEle=driver.findElement(By.xpath("//*[@id=\"cke_43_contents\"]/iframe"));
		WebElement postLinkFrameEle=driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/div/iframe"));
		waitForVisibility(postLinkFrameEle, 5, 2, "postLink Frame ");
		
		switchToFrame(postLinkFrameEle,"Post Link Frame" );
		WebElement postLinkTextEle=driver.findElement(By.cssSelector("body"));
		
		
		waitForVisibility(postLinkTextEle, 5, 2, "postLink Textbox ");
		clickElement(postLinkTextEle,"postLink Text");
		//enterText(postLinkTextEle,"Today is a new day","postLink textbox");
		postLinkTextEle.sendKeys("All is good");
		
		driver.switchTo().defaultContent();
		
		WebElement shareButtonEle=driver.findElement(By.name("publishersharebutton"));
		clickElement(shareButtonEle,"Share Button");
		
		String expDataPosted = "Today is a new day";
		WebElement dataPostedEle=driver.findElement(By.xpath("//*[@id=\"0D5Hr00006vNkYL\"]/div/div[1]/div[1]/div[2]/div[1]/span/p"));
		
		String actDataPosted = dataPostedEle.getText();
		System.out.println("actDataPosted =" + actDataPosted);
				
		if(actDataPosted.equals(expDataPosted))
			System.out.println("link Posted : testcase passed");
		else {
			System.out.println("link not Posted : testcase failed");
		}
	
		
		System.out.println("******salesforce - postLink automation script ended***********");
		myLog.info("******salesforce - postLink automation script completed***********");
		}
	
	@Test
	public void uploadFile() throws InterruptedException {
		//log4j: log
		//extent report
		login();
		myLog.info("******salesforce - uploadFile automation script started***********");
		
		WebElement myProfileEle=driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[1]"));
		clickElement(myProfileEle,"my Profile");
		
		WebElement uploadFileEle=driver.findElement(By.id("publisherAttachContentPost"));
		Thread.sleep(2000);
		//clickElement(uploadFileEle,"upload File");
		uploadFileEle.click();
		Thread.sleep(2000);
		
		
		WebElement fileFromCompEle=driver.findElement(By.xpath(" /html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div/table/tbody/tr/td[2]/a"));
		clickElement(fileFromCompEle,"Upload File From Computer");
		
		WebElement chooseFileEle=driver.findElement(By.id("chatterFile"));
		//clickElement(chooseFileEle,"Choose File From Computer");
		chooseFileEle.sendKeys("D:\\Anusha\\Flower.png");
		
		//WebElement browseButton= driver.findElement(By.id("logo"));
		//clickElement(browseButton, "clear button");
		
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", browseButton);
		//js.executeScript("window.scrollBy(0,600);");
		 StringSelection stringSelection = new StringSelection("D:\\untitled.png");
		    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		    clpbrd.setContents(stringSelection, null);
		    Thread.sleep(10000);
		Robot robot=new Robot();  
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);*/
		
		WebElement shareButtonEle=driver.findElement(By.name("publishersharebutton"));
		clickElement(shareButtonEle,"Share");
		
		System.out.println("Picture Uploaded");
	
		System.out.println("******salesforce - uploadFile automation script ended***********");
		myLog.info("******salesforce - uploadFile automation script completed***********");
		}
	
	@Test
	public void updateProfilePicture() throws InterruptedException {
		//log4j: log
		//extent report
		login();
		myLog.info("******salesforce - updateProfilePicture automation script started***********");
		
		WebElement myProfileEle=driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[1]"));
		clickElement(myProfileEle,"my Profile");
		
		WebElement uploadPicEle=driver.findElement(By.id("photoSection"));
		Actions action = new Actions(driver);
		action.moveToElement(uploadPicEle).build().perform();
		
		WebElement updatePicEle=driver.findElement(By.id("uploadLink"));
		clickElement(updatePicEle,"update pic");
		
		
		
		Thread.sleep(2000);
		WebElement uploadProfilePhotoFrameEle=driver.findElement(By.xpath("//*[@id=\"uploadPhotoContentId\"]"));
		driver.switchTo().frame(uploadProfilePhotoFrameEle);
		
		//browing the file from the computer and passing the value to the web element
		Thread.sleep(2000);
		WebElement uploadPicLinkEle=driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		uploadPicLinkEle.sendKeys("D:\\Anusha\\Flower.png");
		System.out.println("Profile Picture uploaded");
		
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
		((JavascriptExecutor) driver).executeScript("document.getElementById('j_id0:uploadFileForm:save').style.display='block';");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("document.getElementById('j_id0:uploadFileForm:uploadBtn').style.display='block';");
		WebElement updateButtonEle=driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		clickElement(updateButtonEle,"Updated Profile pic");
		
		Thread.sleep(5000);
		//((JavascriptExecutor) driver).executeScript("document.getElementById('j_id0:j_id7:save').style.display='block';");
		WebElement SaveButton1=driver.findElement(By.cssSelector("#j_id0\\:j_id7\\:save"));
		SaveButton1.click();
		System.out.println("Profile Picture Successfully Updated");
	
		System.out.println("******salesforce - updateProfilePicture automation script ended***********");
		myLog.info("******salesforce - updateProfilePicture automation script completed***********");
		}
	
	@Test 
	public void mySettings() throws InterruptedException {
		//log4j: log
		//extent report
		login();
		myLog.info("******salesforce - mySettings automation script started***********");
		
		displayDrownDownItems();
		WebElement userMenuDropDown=driver.findElement(By.id("userNav-arrow"));
		//selectDropDown(userMenuDropDown,"USER MENU DropDown",2,"/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[2]");
		
		WebElement mySettingEle=driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[2]"));
		clickElement(mySettingEle,"mySettingEle");
		
		String expected = "My Settings";
		WebElement mySettingspageEle=driver.findElement(By.name("PersonalSetup"));
		
		String actual=mySettingspageEle.getText();
		if(actual.equals(expected))
			System.out.println("In My Settings ");
		else {
			System.out.println(" Not in My Settings");
		}
		
		Thread.sleep(2000);
		//PERSONAL TAB 
		WebElement personalEle=driver.findElement(By.id("PersonalInfo_font"));
		clickElement(personalEle, "personal tab");
		
		WebElement loginHistoryEle=driver.findElement(By.id("LoginHistory_font"));
		clickElement(loginHistoryEle, "login History tab");
		
		WebElement downloadHistoryEle=driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a"));
		clickElement(downloadHistoryEle, "login History tab");
		
		/*
		 * File folder = new File(System.getProperty("user.dir")); //List the files on
		 * that folder File[] listOfFiles = folder.listFiles(); boolean found = false;
		 * File f = null; //Look for the file in the files // You should write smart
		 * REGEX according to the filename for (File listOfFile : listOfFiles) { if
		 * (listOfFile.isFile()) { String fileName = listOfFile.getName();
		 * System.out.println("File " + listOfFile.getName()); if
		 * (fileName.matches("*.csv")) { f = new File(fileName); found = true; } } } if
		 * (found) { System.out.println(" file downloaded"); } else {
		 * System.out.println(" file not downloaded"); }
		 */
		
		boolean fileexists = isFileDownloaded("C:\\Users\\anush\\Desktop") ;
		//boolean fileexists=isFileDownloaded("C:\\Users\\anush\\Desktop", "LoginHistory1698267822312") ;
		System.out.println("Does file exist = "+ fileexists);
		     
		WebElement LoginTimeEle=driver.findElement(By.cssSelector("th.zen-deemphasize:nth-child(1)"));
		System.out.println( "value=" +LoginTimeEle.getText());
		String s1 = getTextFromElement(LoginTimeEle, "Login time");
		String s2 = "Login Time";
		boolean result = compareActualExpectedStrings(s1,s2);
		
		if (result){
			System.out.println("Login History displayed");
		}
		else {
			System.out.println("Login History not displayed");
		}
		
		//EMAIL SETTINGS:
		WebElement emailEle=driver.findElement(By.id("EmailSetup_font"));
		clickElement(emailEle, "EmailSetup tab");
		
		WebElement emailSettingsEle=driver.findElement(By.id("EmailSettings_font"));
		clickElement(emailSettingsEle, "EmailSetting tab");
		
		WebElement emailNameEle=driver.findElement(By.id("sender_name"));
		enterText(emailNameEle, "abc", "email Name") ;
		
		
		WebElement emailIDEle=driver.findElement(By.id("sender_email"));
		enterText(emailIDEle, "abc@gmail.com", "email ID") ;
		
		//String xpath ="//*[@id=\"auto_bcc1\"]";
		//clickRadioButton( xpath,1,"auto_bcc radio button");
		
		List<WebElement> radio_button  = driver.findElements(By.xpath("//*[@id=\"auto_bcc1\"]"));
		radio_button.get(0).click();
		System.out.println("Radio button clicked");

		
		 WebElement saveEle=driver.findElement(By.name("save"));
		clickElement(saveEle, "save button");
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//IN CALENDERS and REMINDERS:
		WebElement CalandRemindEle=driver.findElement(By.id("CalendarAndReminders_font"));
		clickElement(CalandRemindEle, "CalendarAndReminders tab");
		
		Thread.sleep(5000);	
		
		WebElement activityEle=driver.findElement(By.id("Reminders_font"));
		clickElement(activityEle, "Activity Reminders tab") ;
		
		String MainWindow = driver.getWindowHandle();
		
		WebElement openRemindEle=driver.findElement(By.id("testbtn"));
		clickElement(openRemindEle, "Open Reminders button") ;
		
		Thread.sleep(5000);	
		Set<String> s=driver.getWindowHandles();		
        Iterator<String> i1=s.iterator();	
		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();
            driver.switchTo().window(ChildWindow);
			
        }
		
		
		System.out.println(driver.getTitle());
		//driver.switchTo().window(getWindow);
		Thread.sleep(2000);		
		//WebElement dismissAll= driver.findElement(By.id("dismiss_all"));
		//Actions action=new Actions(driver);
		//action.moveToElement(switchto).build().perform();

		WebElement dismissAll=driver.findElement(By.id("dismiss_all"));
		clickElement(dismissAll, "dismissAll button ");
		
		System.out.println("******salesforce - mySettings automation script ended***********");
		myLog.info("******salesforce - mySettings automation script completed***********");
		}

	@Test
	public void DevelopersConsole() throws InterruptedException {
		//log4j: log
		//extent report
		login();
		myLog.info("******salesforce - DevelopersConsole automation script started***********");
		
		displayDrownDownItems();
		WebElement userMenuDropDown=driver.findElement(By.id("userNav-arrow"));
		//selectDropDown(userMenuDropDown,"USER MENU DropDown",2,"/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[2]");
		
		WebElement developersConsoleEle=driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[3]"));
		clickElement(developersConsoleEle,"developers Console");
		
		String expected = "Developer Console";
		Thread.sleep(5000);	
		
		Set<String> s=driver.getWindowHandles();	
		
        Iterator<String> i1=s.iterator();	
		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();
            driver.switchTo().window(ChildWindow);
			
        }
        
        System.out.println(driver.getTitle());
		
		String actual=driver.getTitle();
		if(actual.equals(expected))
			System.out.println("In Developers Console");
		else {
			System.out.println("Not in Developers Console");
		}
	
		System.out.println("******salesforce - DevelopersConsole automation script ended***********");
		myLog.info("******salesforce - DevelopersConsole automation script completed***********");
		}
	
	@Test
	public void Logout() throws InterruptedException {
		//log4j: log
		//extent report
		login();
		myLog.info("******salesforce - Logout automation script started***********");
		
		displayDrownDownItems();
		WebElement userMenuDropDown=driver.findElement(By.id("userNav-arrow"));
		//selectDropDown(userMenuDropDown,"USER MENU DropDown",2,"/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[2]");
		
		String MainWindow = driver.getWindowHandle();
		
		WebElement logoutEle=driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
		clickElement(logoutEle,"Logout");
		
		Thread.sleep(5000);
		
		
		//String oldWindow = driver.getWindowHandle();
		//driver.switchTo().window(oldWindow)
		
		String actual=driver.getTitle();
		System.out.println(actual);
		driver.close();
		
		System.out.println("******salesforce - Logout automation script ended***********");
		myLog.info("******salesforce - Logout automation script completed***********");
		}
	
	
		
}
