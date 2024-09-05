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
import org.testng.annotations.Test;
// design pattern --- page object model
//import com.automation.tests.Base.BaseTest;
import com.automation.tests.utilities.PropertiesUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesforceAccountReport extends BaseTest {

	@Test
	public void CreatenewviewofAccount () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******CreatenewviewofAccount automation script started***********");
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
		System.out.println("Title = "+ driver.getTitle());
		WebElement AccountsEle = driver.findElement(By.id("Account_Tab"));
		clickElement(AccountsEle,"Accounts button");
		myLog.info("In Accounts Page");
		displaySelectDrownDownList();
	
		
		String oldWindow = driver.getWindowHandle();
		System.out.println("oldWindow = "+oldWindow);
				
		Thread.sleep(2000);
		System.out.println("Account Title = "+ driver.getTitle());
		WebElement newViewEle = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"));
		clickElement(newViewEle,"new View");
		WebElement viewNameEle = driver.findElement(By.id("fname"));
		enterText(viewNameEle,"View138","view Name textbox");
		
		WebElement viewUNameEle = driver.findElement(By.id("devname"));
		enterText(viewUNameEle,"View138Latest","view Unique Name textbox");

		WebElement saveEle = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[3]/table/tbody/tr/td[2]/input[1]"));
		clickElement(saveEle,"save Ele");
		
		//String newWindow = driver.getWindowHandle();
		//System.out.println("newWindow = "+newWindow);
		//driver.switchTo().window(oldWindow);
		
		driver.navigate().to("https://cts492-dev-ed.develop.my.salesforce.com/001/o");
		
		Thread.sleep(5000);
		displaySelectDrownDownList();

		myLog.info("******CreatenewviewofAccount automation script ended***********");
		
		
	}
	
	@Test
	public void EditviewofAccount () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******CreatenewviewofAccount automation script started***********");
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
		System.out.println("Title = "+ driver.getTitle());
		WebElement AccountsEle = driver.findElement(By.id("Account_Tab"));
		clickElement(AccountsEle,"Accounts button");
		myLog.info("In Accounts Page");
		displaySelectDrownDownList();
	
		
		String oldWindow = driver.getWindowHandle();
		System.out.println("oldWindow = "+oldWindow);
				
		Thread.sleep(2000);
		System.out.println("Account Title = "+ driver.getTitle());
		
		WebElement editViewEle = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		clickElement(editViewEle,"edit View");
		String actual = getPageTitle();
		System.out.println("actual = " + actual);
		String expected = "Accounts: Edit View ~ Salesforce Developer Edition";
		Assert.assertEquals(actual, expected);
		
		WebElement viewNameEle = driver.findElement(By.id("fname"));
		enterText(viewNameEle,"LatestView138"," Edited view Name textbox");
		
		WebElement viewUNameEle = driver.findElement(By.id("devname"));
		enterText(viewUNameEle,"View138Latest","view Unique Name textbox");
		
		WebElement acctNameEle = driver.findElement(By.xpath("//*[@id=\"fcol1\"]/option[2]"));
		clickElement(acctNameEle, "acct Name") ;
		
		WebElement acctNameValueEle = driver.findElement(By.xpath("//*[@id=\"fval1\"]"));
		enterText(acctNameValueEle,"abc","acctNameValueEle");
		
		
		WebElement saveEle = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		clickElement(saveEle,"save Ele");
		
		//String newWindow = driver.getWindowHandle();
		//System.out.println("newWindow = "+newWindow);
		//driver.switchTo().window(oldWindow);
		
		driver.navigate().to("https://cts492-dev-ed.develop.my.salesforce.com/001/o");
		
		Thread.sleep(5000);
		displaySelectDrownDownList();

		myLog.info("******EditviewofAccount automation script ended***********");
		
		
	}
	
	@Test
	public void MergeAccounts () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******CreatenewviewofAccount automation script started***********");
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
		System.out.println("Title = "+ driver.getTitle());
		WebElement AccountsEle = driver.findElement(By.id("Account_Tab"));
		clickElement(AccountsEle,"Accounts button");
		myLog.info("In Accounts Page");
		displaySelectDrownDownList();
	
		
		String oldWindow = driver.getWindowHandle();
		System.out.println("oldWindow = "+oldWindow);
				
		Thread.sleep(2000);
		System.out.println("Account Title = "+ driver.getTitle());
		
		WebElement MergeAcctEle = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		clickElement(MergeAcctEle,"Accounts button");
		
		WebElement FindAcctEle = driver.findElement(By.id("srch"));
		enterText(FindAcctEle,"1122","acctNameValueEle");
		
		WebElement FindAcctBtn = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
		clickElement(FindAcctBtn,"FindAcct button");
		
		WebElement NextBtn = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]"));
		clickElement(NextBtn,"Next button");
		
		WebElement MergeBtn = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[2]"));
		clickElement(MergeBtn,"Merge button");
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		myLog.info(" Accounts Merged");
		System.out.println("Accounts Merged");
		
		}
	
	@Test
	public void CreateAccountReport () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******CreatenewviewofAccount automation script started***********");
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
		System.out.println("Title = "+ driver.getTitle());
		WebElement AccountsEle = driver.findElement(By.id("Account_Tab"));
		clickElement(AccountsEle,"Accounts button");
		myLog.info("In Accounts Page");
		
		WebElement AcctGtThan30Ele = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
		clickElement(AcctGtThan30Ele,"Acct with last activity > 30 days link");
		
		WebElement UnsavedRepo = driver.findElement(By.cssSelector("#thePage\\:sectionHeader > div > div > div.content > h2"));
		System.out.println("Report displayed as" + UnsavedRepo.getText());
		
		WebElement DateFieldEle = driver.findElement(By.id("ext-gen148"));
		clickElement(DateFieldEle,"DateFieldEle");
		
		WebElement CreateDateEle = driver.findElement(By.cssSelector("#thePage\\:sectionHeader > div > div > div.content > h2"));
		clickElement(CreateDateEle,"CreateDateEle Selected");
		System.out.println("Created date selected");
		
		WebElement FromDateEle = driver.findElement(By.id("ext-gen152"));
		clickElement(FromDateEle,"FromDateEle");
		
		WebElement TodaysDateEle = driver.findElement(By.xpath("//*[@id=\"ext-gen277\"]/tbody/tr[2]/td/table/tbody/tr[2]/td[6]"));
		clickElement(TodaysDateEle,"TodaysDateEle Selected");
		
		WebElement ToDateEle = driver.findElement(By.id("ext-gen154"));
		clickElement(ToDateEle,"ToDateEle");
		
		WebElement TodaysDateToEle = driver.findElement(By.cssSelector("#ext-gen280 > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td.x-date-active.x-date-selected"));
		clickElement(TodaysDateToEle,"TodaysDateToEle Selected"); 
		
		WebElement SaveBtn = driver.findElement(By.id("ext-gen49"));
		clickElement(SaveBtn,"SaveBtn");  
		
		WebElement RepoNameEle = driver.findElement(By.id("ext-gen337"));
		enterText(RepoNameEle," New Report ","New Report Created");
		
		WebElement NewRepoNameEle = driver.findElement(By.id("ext-gen337"));
		enterText(NewRepoNameEle," New Report ","New Report Created");
		
		WebElement UniqRepoNameEle = driver.findElement(By.id("ext-gen338"));
		enterText(UniqRepoNameEle," Unique Report ","Unique Report Created"); 
		
		WebElement SaveBtninWin = driver.findElement(By.id("ext-gen321"));
		clickElement(SaveBtninWin,"Save Btn in Window");  
		
		System.out.println("New Report Created");
		
		
	}
	
}
