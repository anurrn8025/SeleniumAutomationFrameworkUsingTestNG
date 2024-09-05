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
import com.automation.tests.Scripts.BaseTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesForceCreateOpty extends BaseTest {
	
	@Test
	public void OpportunitiesDropdown () throws InterruptedException {

		myLog.info("******OpportunitiesDropdown automation script started***********");
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
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement OpportunityEle = driver.findElement(By.id("Opportunity_Tab"));
		clickElement(OpportunityEle,"Opportunity_Tab");
		System.out.println("Title = "+ driver.getTitle());
		displaySelectDrownDownList();
		
		System.out.println("Opportunities Drop Down displayed");
	}
	
	@Test
	public void CreateanewOpty () throws InterruptedException {

		myLog.info("******CreateanewOpty automation script started***********");
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
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement OpportunityEle = driver.findElement(By.id("Opportunity_Tab"));
		clickElement(OpportunityEle,"Opportunity_Tab");
		System.out.println("Title = "+ driver.getTitle());
		
		WebElement NewBtn = driver.findElement(By.id("createNewButton"));
		clickElement(NewBtn,"Create New Btn"); 
		
		WebElement NewOpty = driver.findElement(By.id("//*[@id=\"createNewMenu\"]/a[4]"));
		clickElement(NewOpty,"Create NewOpty Btn"); 
		
		String PageName = driver.findElement(By.cssSelector("#bodyCell > div.bPageTitle > div.ptBody > div.content > h2")).getText();
		System.out.println("In New Opty Page with name as :" + PageName);
		
		
		WebElement OptyNameEle = driver.findElement(By.id("opp3"));
		enterText(OptyNameEle," New Opty1 ","New Opty");
		
		WebElement AcctNameEle = driver.findElement(By.id("opp4"));
		enterText(AcctNameEle," Acct1 ","AcctName");
		
		WebElement CloseDtEle = driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a"));
		clickElement(CloseDtEle,"CloseDtEle"); 
		
		WebElement StageEle = driver.findElement(By.xpath("//*[@id=\"opp11\"]/option[5]"));
		clickElement(StageEle,"StageEle"); 
		
		WebElement ProbEle = driver.findElement(By.id("opp12"));
		enterText(ProbEle," 5 "," ProbEle");
		
		WebElement LSourceEle = driver.findElement(By.xpath("//*[@id=\"opp6\"]/option[3]"));
		clickElement(LSourceEle,"LSourceEle"); 
		
		WebElement PCampEle = driver.findElement(By.xpath("//*[@id=\"opp6\"]/option[3]"));
		enterText(PCampEle," 500 "," PCampEle");
		
		
		WebElement SaveBtnEle = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		clickElement(SaveBtnEle,"SaveBtnEle"); 
		System.out.println("New Opty Created Successfully");
		
	}
	
	@Test
	public void TestOpportunityPipelineReport () throws InterruptedException {

		myLog.info("******TestOpportunityPipelineReport automation script started***********");
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
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement OpportunityEle = driver.findElement(By.id("Opportunity_Tab"));
		clickElement(OpportunityEle,"Opportunity_Tab");
		System.out.println("Title = "+ driver.getTitle());
		
		WebElement optPlineEle = driver.findElement(By.cssSelector("#toolsContent > tbody > tr > td:nth-child(1) > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(1) > a"));
		clickElement(optPlineEle,"optPlineEle"); 
		
		System.out.println("Opportunity  pipeline report is displayed");
		
	}
	
	@Test
	public void TestStuckOpportunitiesReport () throws InterruptedException {

		myLog.info("******TestStuckOpportunitiesReport automation script started***********");
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
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement OpportunityEle = driver.findElement(By.id("Opportunity_Tab"));
		clickElement(OpportunityEle,"Opportunity_Tab");
		System.out.println("Title = "+ driver.getTitle());
		
		WebElement StuckOptRepo = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
		clickElement(StuckOptRepo,"StuckOptRepo"); 
		
	
		String StuckOptReptpageName = driver.findElement(By.xpath("	//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")).getText();
		System.out.println("In Stuck Oprt Report Page with Pagename = "+ StuckOptReptpageName);
	}
	
	@Test
	public void TestQuarterlySummaryReport () throws InterruptedException {

		myLog.info("******TestQuarterlySummaryReport automation script started***********");
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
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement OpportunityEle = driver.findElement(By.id("Opportunity_Tab"));
		clickElement(OpportunityEle,"Opportunity_Tab");
		System.out.println("Title = "+ driver.getTitle());
		
		Select se = new Select(driver.findElement(By.id("quarter_q")));
		se.selectByVisibleText("Current FQ");
		
		Select sec = new Select(driver.findElement(By.id("open")));
		sec.selectByVisibleText("Open Opportunities");
	
		WebElement RunRptBtn = driver.findElement(By.xpath("	//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
		clickElement(RunRptBtn,"RunRptBtn");
		
		System.out.println("QuarterlySummaryReport displayed");
	}
}
