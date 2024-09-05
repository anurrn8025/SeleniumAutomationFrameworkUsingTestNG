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

public class SalesForceLeads extends BaseTest  {
	
	@Test
	public void leadsTab() throws InterruptedException {

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
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement LeadTabEle = driver.findElement(By.id("Lead_Tab"));
		clickElement(LeadTabEle,"LeadTabEle");
		System.out.println("Title = "+ driver.getTitle());
		displaySelectDrownDownList();
		
		System.out.println("leadsTab Drop Down displayed");
	}
	
	
	@Test
	public void TodaysLeadswork() throws InterruptedException {

		myLog.info("******TodaysLeadswork automation script started***********");
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
		WebElement LeadTabEle = driver.findElement(By.id("Lead_Tab"));
		clickElement(LeadTabEle,"LeadTabEle");
		System.out.println("Title = "+ driver.getTitle());
		displaySelectDrownDownList();
		
		System.out.println("leadsTab Drop Down displayed");
		
		WebElement GoBtnEle=driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		clickElement(GoBtnEle,"Go button");
		
		WebElement CreatedDateEle=driver.findElement(By.id("00QHr00002UJhSQ_LEAD_CREATED_DATE"));
		String CreDate = CreatedDateEle.getText();
		String Expdate = "11/11/2023";
		Assert.assertEquals(Expdate,CreDate);
		System.out.println("Todays Lead work is displayed");
		
	}
	

	
	

	@Test
	public void CheckNewbuttoonLeadsHome() throws InterruptedException {

		myLog.info("******CheckNewbuttoonLeadsHome automation script started***********");
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
		WebElement LeadTabEle = driver.findElement(By.id("Lead_Tab"));
		clickElement(LeadTabEle,"LeadTabEle");
		System.out.println("Title = "+ driver.getTitle());
		
		WebElement createNewBtnEle=driver.findElement(By.id("createNewButton"));
		clickElement(createNewBtnEle,"createNewBtnEle");
		
		
	}
}
