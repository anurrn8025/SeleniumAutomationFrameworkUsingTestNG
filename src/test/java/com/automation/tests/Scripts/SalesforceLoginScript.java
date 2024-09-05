package com.automation.tests.Scripts;

import java.util.Properties;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
public class SalesforceLoginScript extends BaseTest{
	@Test
	public void login_to_salesforce_failed () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******login_to_salesforce - password empty automation script started***********");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		WebElement usernameEle =driver.findElement(By.id("username"));
		
		String expected="Please enter your password";
		
		if (usernameEle.isDisplayed()) {
		usernameEle.clear();
		usernameEle.sendKeys("anusha@cognizant.com");
		System.out.println("url is entered");
		}
		else {
			System.out.println("username element is not displayed");
		}
		
		WebElement passwordEle=driver.findElement(By.id("password"));
		System.out.println("in passwd");
		if(passwordEle.isDisplayed()) {
		passwordEle.clear();
		}
		else {
			System.out.println("password element is not displayed");
		}
		
	
		WebElement buttonEle =driver.findElement(By.id("Login"));
		if(buttonEle.isEnabled()) {
			buttonEle.click();
			System.out.println("login button clicked");
		}
		else {
			System.out.println("Button not enabled");
		}
		
	//	Thread.sleep(2000);
		//WebElement loginError =driver.findElement(By.className("loginError"));
		WebElement loginError =driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[1]"));
		String actual = loginError.getText();
		System.out.println("actual = "+actual);
		
		if(actual.equals(expected))
			System.out.println("testcase passed");
		else {
			System.out.println("testcase failed");
			
		}
		
		
		myLog.info("******login_to_salesforce - password empty automation script completed***********");
		driver.close();
	}
	
	@Test
	public void login_to_salesforce_CheckRemeberMe () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******login_to_salesforce_CheckRemeberMe automation script started***********");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		WebElement usernameEle =driver.findElement(By.id("username"));
		
		String expected="Home Page ~ Salesforce - Developer Edition";
		
		if (usernameEle.isDisplayed()) {
		usernameEle.clear();
		usernameEle.sendKeys("anusha@cognizant.com");
		System.out.println("url is entered");
		}
		else {
			System.out.println("username element is not displayed");
		}
		
		WebElement passwordEle=driver.findElement(By.id("password"));
		System.out.println("in passwd");
		if(passwordEle.isDisplayed()) {
		passwordEle.clear();
		passwordEle.sendKeys("Shundu1234");
		}
		else {
			System.out.println("password element is not displayed");
		}
		
		WebElement chkBoxEle =driver.findElement(By.name("rememberUn"));
		if(chkBoxEle.isSelected()) {
			System.out.println("Check Box already selected");
		}
		else {
			chkBoxEle.click();
			System.out.println("Check box selected");
			
		}
		
		WebElement buttonEle =driver.findElement(By.id("Login"));
		if(buttonEle.isEnabled()) {
			buttonEle.click();
			System.out.println("login button clicked");
		}
		else {
			System.out.println("Button not enabled");
		}
		
		Thread.sleep(5000);
		
		String actual=driver.getTitle();
		System.out.println("actual : " + actual);
		

		if(actual.equals(expected))
			System.out.println("testcase passed. Login Successful");
		else {
			System.out.println("testcase failed");
			
		}
		
		
		WebElement arrowEle =driver.findElement(By.id("userNav-arrow"));
		arrowEle.click();
		System.out.println("Arrow clicked");
		
		displayDrownDownItems();
		WebElement menuItemsEle =driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
		menuItemsEle.click();
		System.out.println("Logout selected");
		
		Thread.sleep(5000);
		
		String actual1=driver.getTitle();
		System.out.println("actual1 : " + actual1);

		String expected1="Login | Salesforce";
		if(actual1.equals(expected1))
			System.out.println("in login page");
		else {
			System.out.println("Not in login page");
			
		}
		
		WebElement rememberedNameEle =driver.findElement(By.id("idcard-identity"));
		String remUserNameEle = rememberedNameEle.getText();
		System.out.println("remUserNameEle" + remUserNameEle);
		if (rememberedNameEle.isDisplayed()) {
			String ExpectedUName = "anusha@cognizant.com";
			if (ExpectedUName.equals(remUserNameEle))
			{
			System.out.println("TC passed . url is entered");
			}
			else {
				System.out.println("TC Failed. Username element is not displayed");
			}
		}
		driver.close();
		myLog.info("******login_to_salesforce_CheckRemeberMe automation script completed***********");
		


	}

	@Test
	public void login_to_salesforce_ForgotPassword() throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******login_to_salesforce - ForgotPassword automation script started***********");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);

		
		WebElement forgotPasswdEle =driver.findElement(By.id("forgot_password_link"));
		if (forgotPasswdEle.isEnabled()){
		forgotPasswdEle.click();
		}
		else {
			System.out.println("Forgot Password Link not enabled");
		}
		
		Thread.sleep(5000);
		String expected = "Forgot Your Password | Salesforce";
		String actual=driver.getTitle();
		System.out.println("actual : " + actual);
		if(actual.equals(expected))
			System.out.println("In forgot passwd Page");
		else {
			System.out.println("Not in forgot passwd Page");
		
		}
		
		WebElement usernameEle =driver.findElement(By.id("un"));
		if (usernameEle.isDisplayed()) {
			usernameEle.clear();
			usernameEle.sendKeys("anusha@cognizant.com");
			System.out.println("url is entered");
			}
			else {
				System.out.println("username element is not displayed");
			}
		
		WebElement buttonEle =driver.findElement(By.id("continue"));
		if(buttonEle.isEnabled()) {
			buttonEle.click();
			System.out.println("continue button clicked");
		}
		else {
			System.out.println("  Continue Button not enabled");
		}
		
		WebElement messageEle =driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/p[1]"));
		String Act=messageEle.getText();
		String Exp = "We’ve sent you an email with a link to finish resetting your password.";
		if(Exp.equals(Act)) {
			System.out.println("TC passed. Email Sent");
		}
		else {
			System.out.println("TC Failed. Email not Sent");
		
		}
		
		myLog.info("******login_to_salesforce_ForgotPassword script completed***********");
		driver.close();
}

	
	@Test
	public void login_to_salesforce_successfully () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******login_to_salesforce - successfully automation script started***********");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		WebElement usernameEle =driver.findElement(By.id("username"));
		
		String expected="Home Page ~ Salesforce - Developer Edition";
		
		if (usernameEle.isDisplayed()) {
		usernameEle.clear();
		usernameEle.sendKeys("anusha@cognizant.com");
		System.out.println("url is entered");
		}
		else {
			System.out.println("username element is not displayed");
		}
		
		WebElement passwordEle=driver.findElement(By.id("password"));
		System.out.println("in passwd");
		if(passwordEle.isDisplayed()) {
		passwordEle.clear();
		passwordEle.sendKeys("Shundu1234");
		}
		else {
			System.out.println("password element is not displayed");
		}
		
	
		WebElement buttonEle =driver.findElement(By.id("Login"));
		if(buttonEle.isEnabled()) {
			buttonEle.click();
			System.out.println("login button clicked");
		}
		else {
			System.out.println("Button not enabled");
		}
		
		Thread.sleep(5000);
		
		String actual=driver.getTitle();
		System.out.println("actual : " + actual);

		if(actual.equals(expected))
			System.out.println("testcase passed");
		else {
			System.out.println("testcase failed");
			
		}
		myLog.info("******login_to_salesforce - successfully script completed***********");
		driver.close();

	}
		
	@Test
	public void login_to_salesforce_IncorrectCredentials () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******login_to_salesforce_IncorrectCredentials automation script started***********");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		WebElement usernameEle =driver.findElement(By.id("username"));
		
		String expected="Home Page ~ Salesforce - Developer Edition";
		
		if (usernameEle.isDisplayed()) {
		usernameEle.clear();
		usernameEle.sendKeys("123");
		System.out.println("url is entered");
		}
		else {
			System.out.println("username element is not displayed");
		}
		
		WebElement passwordEle=driver.findElement(By.id("password"));
		System.out.println("in passwd");
		if(passwordEle.isDisplayed()) {
		passwordEle.clear();
		passwordEle.sendKeys("22131");
		}
		else {
			System.out.println("password element is not displayed");
		}
		
		WebElement buttonEle =driver.findElement(By.id("Login"));
		if(buttonEle.isEnabled()) {
			buttonEle.click();
			System.out.println("login button clicked");
		}
		else {
			System.out.println("Button not enabled");
		}
		
		Thread.sleep(5000);
		
		WebElement errorMessageEle =driver.findElement(By.id("error"));
		String Act=errorMessageEle.getText();
		String Exp = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if(Exp.equals(Act)) {
			System.out.println("TC passed. Error Message Displayed");
		}
		else {
			System.out.println("TC Failed. Error Message Not Displayed");
		
		}
		myLog.info("******login_to_salesforce_IncorrectCredentials script completed***********");
		driver.close();

	}

		

	}
		
	
		
		

