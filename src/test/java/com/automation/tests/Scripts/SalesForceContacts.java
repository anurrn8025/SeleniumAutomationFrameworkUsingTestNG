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

public class SalesForceContacts extends BaseTest {
	
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
	public void Createnewcontact() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement ContactTabEle = driver.findElement(By.id("Contact_Tab"));
		clickElement(ContactTabEle,"ContactTab");
		System.out.println("Title = "+ driver.getTitle());
		displaySelectDrownDownList();
		System.out.println("ContactTab Drop Down displayed");
		WebElement createNewButtonEle=driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		clickElement(createNewButtonEle,"createNew Button");
		WebElement LNameEle = driver.findElement(By.id("name_lastcon2"));
		enterText(LNameEle,"Abcd","Last Name textbox");
		WebElement AcctNameEle = driver.findElement(By.id("con4"));
		enterText(AcctNameEle,"Akbar","Acct Name textbox");
		WebElement SaveEle=driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		clickElement(SaveEle,"Save button");

	}
	
	@Test
	public void Createnewview() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement ContactTabEle = driver.findElement(By.id("Contact_Tab"));
		clickElement(ContactTabEle,"ContactTab");
		System.out.println("Title = "+ driver.getTitle());
		WebElement createNewViewButtonEle=driver.findElement(By.cssSelector("#filter_element > div > span > span.fFooter > a:nth-child(2)"));
		clickElement(createNewViewButtonEle,"createNewView Button");
		WebElement VNameEle = driver.findElement(By.id("fname"));
		enterText(VNameEle,"View1","View Name textbox");
		WebElement VUniqNameEle = driver.findElement(By.id("devname"));
		enterText(VUniqNameEle,"ViewUniq1","ViewUniq Name textbox");
		WebElement SaveEle=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		clickElement(SaveEle,"Save button");
	
		
		
	}
	
	@Test
	public void RecentlycreatedContacts() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement ContactTabEle = driver.findElement(By.id("Contact_Tab"));
		clickElement(ContactTabEle,"ContactTab");
		System.out.println("Title = "+ driver.getTitle());
		
		Select se = new Select(driver.findElement(By.id("hotlist_mode")));
		se.selectByVisibleText("Recently created");
		System.out.println("the recently created contacts are displayed");
		
	}
	
	@Test
	public void MyContactsView() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement ContactTabEle = driver.findElement(By.id("Contact_Tab"));
		clickElement(ContactTabEle,"ContactTab");
		System.out.println("Title = "+ driver.getTitle());
		
		Select se = new Select(driver.findElement(By.id("fcf")));
		se.selectByVisibleText("My Contacts");
		System.out.println(" My Contacts are displayed");
		
	}
	
	@Test
	public void ViewAContact() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement ContactTabEle = driver.findElement(By.id("Contact_Tab"));
		clickElement(ContactTabEle,"ContactTab");
		System.out.println("Title = "+ driver.getTitle());
		
		WebElement ContactEle = driver.findElement(By.xpath("//*[@id=\\\"bodyCell\\\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[5]/th/a"));
		clickElement(ContactEle,"ContactEle");
		WebElement ContactNEle = driver.findElement(By.xpath("//*[@id=\"contactHeaderRow\"]/div[2]/h2"));
		System.out.println("The contact name is = "+ ContactNEle.getText());
		
	}
	
	@Test
	public void ErrorinCreatenewview() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement ContactTabEle = driver.findElement(By.id("Contact_Tab"));
		clickElement(ContactTabEle,"ContactTab");
		System.out.println("Title = "+ driver.getTitle());
		WebElement createNewViewButtonEle=driver.findElement(By.cssSelector("#filter_element > div > span > span.fFooter > a:nth-child(2)"));
		clickElement(createNewViewButtonEle,"createNewView Button");
		
		WebElement VUniqNameEle = driver.findElement(By.id("devname"));
		enterText(VUniqNameEle,"ViewUniq1","ViewUniq Name textbox");
		WebElement SaveEle=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		clickElement(SaveEle,"Save button");
		WebElement ErrorEle = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]/text()"));
		System.out.println("The contact name is = "+ ErrorEle.getText());
		
	
		
		
	}
	
	@Test
	public void  Cancelbutton() throws InterruptedException {
		Login();
		//In home page
		System.out.println("Title = "+ driver.getTitle());
		WebElement ContactTabEle = driver.findElement(By.id("Contact_Tab"));
		clickElement(ContactTabEle,"ContactTab");
		System.out.println("Title = "+ driver.getTitle());
		WebElement createNewViewButtonEle=driver.findElement(By.cssSelector("#filter_element > div > span > span.fFooter > a:nth-child(2)"));
		clickElement(createNewViewButtonEle,"createNewView Button");
		
		WebElement VNameEle = driver.findElement(By.id("fname"));
		enterText(VNameEle,"View1","View Name textbox");
		WebElement VUniqNameEle = driver.findElement(By.id("devname"));
		enterText(VUniqNameEle,"ViewUniq1","ViewUniq Name textbox");
		
		WebElement CancelEle=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[2]"));
		clickElement(CancelEle,"Cancel button");
		Thread.sleep(2000);
		
		System.out.println("Title of contacts page = "+ driver.getTitle());
		

	}
}
