package com.automation.tests.Scripts;

import java.util.Properties;
import com.automation.tests.Scripts.BaseTest;
import org.testng.annotations.Test;

import com.automation.tests.utilities.PropertiesUtility;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
// design pattern --- page object model
//import com.automation.tests.Base.BaseTest;
import com.automation.tests.utilities.PropertiesUtility;
import com.automation.tests.Scripts.BaseTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomScenarios extends BaseTest {
	
	public void Login() throws InterruptedException{
		myLog.info("******leadsTab automation script started***********");
		String expected="";
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		String password=pro.getPropertyValue("login.valid.password",p);
		
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,username,"username textbox");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle,password,"password textbox");
		WebElement buttonEle=driver.findElement(By.id("Login"));
		clickElement(buttonEle,"login button");
		myLog.info("UserName & Password entered");
		
		Thread.sleep(2000);	
	}

	@Test
	public void Verifyfirstnameandlastname() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement UName = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		clickElement(UName,"User Name");
		System.out.println("Title = "+ driver.getTitle());
		System.out.println("In my profile page");
	}
	
	@Test
	public void Verifyeditedlastname() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement UName = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		clickElement(UName,"User Name");
		System.out.println("Title = "+ driver.getTitle());
		System.out.println("In my profile page");
	
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
	public void Verifytabcustomization() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement PlusEle = driver.findElement(By.id("AllTab_Tab"));
		clickElement(PlusEle,"Plus");
		
		WebElement CustomizeEle = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/table/tbody/tr/td[2]/input"));
		clickElement(CustomizeEle,"CustomizeEle");
		
		WebElement SubsEle = driver.findElement(By.xpath("//*[@id=\"duel_select_1\"]/option[8]"));
		clickElement(SubsEle,"SubsEle");
		
		WebElement RemoveEle = driver.findElement(By.id("duel_select_0_left"));
		clickElement(RemoveEle,"RemoveEle");
		
		WebElement SaveEle = driver.findElement(By.id("bottomButtonRow"));
		clickElement(SaveEle,"SaveEle");
		
		System.out.println(" The subscription tab is removed");
		
	}
	
	@Test
	public void Blockinganeventincalender() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement DateEle = driver.findElement(By.id("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		clickElement(DateEle,"DateEle");
		System.out.println("Title = "+ driver.getTitle());
		
		WebElement EightPMEle = driver.findElement(By.cssSelector("#p\\:f\\:j_id25\\:j_id61\\:28\\:j_id64 > a"));
		clickElement(EightPMEle,"EightPMEle");
		System.out.println("New  event Page is displayed");
		
		String MainWindow = driver.getWindowHandle();
		
		WebElement ComboEle = driver.findElement(By.id("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		clickElement(ComboEle,"ComboEle");
		
		Thread.sleep(5000);	
					Set<String> s=driver.getWindowHandles();		
			        Iterator<String> i1=s.iterator();	
					
			        while(i1.hasNext())			
			        {		
			            String ChildWindow=i1.next();
			            driver.switchTo().window(ChildWindow);
	
			        }
			      
			        WebElement OtherEle = driver.findElement(By.xpath(" //*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/script/text()"));
					clickElement(OtherEle,"OtherEle");
					
					WebElement NinePMEle = driver.findElement(By.id("timePickerItem_42"));
					clickElement(NinePMEle,"NinePMEle");
					
					WebElement SaveEle = driver.findElement(By.id("bottomButtonRow"));
					clickElement(SaveEle,"SaveEle");

		System.out.println("New Event saved");
		
	}
	
	@Test
	public void CreateEventWithWeeklyrecurrance() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement DateEle = driver.findElement(By.id("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		clickElement(DateEle,"DateEle");
		System.out.println("Title = "+ driver.getTitle());
		
		WebElement CreateRecEle = driver.findElement(By.id("IsRecurrence"));
		clickElement(CreateRecEle,"CreateRecEle");
		
		WebElement WeeklyEle = driver.findElement(By.xpath("//*[@id=\"recpat\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/div/div[2]/label"));
		clickElement(WeeklyEle,"WeeklyEle");
					
					WebElement SaveEle = driver.findElement(By.id("bottomButtonRow"));
					clickElement(SaveEle,"SaveEle");

		System.out.println("weekly recurrance element saved");
		
	}
	
}
