package com.automation.tests.Scripts;

import java.util.Properties;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
// design pattern --- page object model
import com.automation.tests.Base.BaseTest;
import com.automation.tests.utilities.PropertiesUtility;

public class FirebaseAutomationScript extends BaseTest {

	@Test
	public void login_to_firebase() throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******login_to_firebase automation script started***********");
		String expected="Student Registration Form";
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		String password=pro.getPropertyValue("login.valid.password",p);
		
		WebElement usernameEle = driver.findElement(By.id("email_field"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,username,"username textbox");
		WebElement passwordEle = driver.findElement(By.id("password_field"));
		enterText(passwordEle,password,"password textbox");
		WebElement buttonEle=driver.findElement(By.tagName("button1"));
		clickElement(buttonEle,"login button");
		WebElement studentTextEle= driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1"));
		waitForVisibility(studentTextEle, 5, "student header text");
		String actual=getTextFromElement(studentTextEle,"student header text");	
		
	}
	
	@Test
	public void invalid_login_to_firebase1() throws InterruptedException {
		myLog.info("******invalid_login_to_firebase1 automation script started***********");
		String expected="Error : The email address is badly formatted.";
		System.out.println("expected data to be validates is=="+expected);
	
		WebElement usernameEle = driver.findElement(By.id("email_field"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		clearElement(usernameEle, "username textbox");
		WebElement passwordEle = driver.findElement(By.id("password_field"));
		clearElement(passwordEle, "password textbox");
		WebElement buttonEle=driver.findElement(By.tagName("button"));
		clickElement(buttonEle,"login button");
		waitForAlertPresent(5);
		Alert loginerrorAlert= switchToAlert();
		String actual= getAlertText(loginerrorAlert,"login error alert box");
		acceptAlert(loginerrorAlert);
		Assert.assertEquals(actual, expected,"Fail: testcase failed");
		
		
	}
	@Test
	public void invalid_login_to_firebase2() throws InterruptedException {

		
		System.out.println("******invalid_login_to_firebase2 automation script started***********");
		String expected="Error : The password is invalid or the user does not have a password.";
		System.out.println("expected data to be validates is=="+expected);
		
		
		WebElement usernameEle = driver.findElement(By.id("email_field"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,"admin123@gmail.com","username textbox");
		WebElement passwordEle = driver.findElement(By.id("password_field"));
		clearElement(passwordEle,"password textbox");
		WebElement buttonEle=driver.findElement(By.tagName("button"));
		clickElement(buttonEle,"login button");
		waitForAlertPresent(5);
		Alert loginerrorAlert= switchToAlert();
		String actual= getAlertText(loginerrorAlert,"login error alert box");
		acceptAlert(loginerrorAlert);
		Assert.assertEquals(actual, expected,"Fail: testcase failed");
		
	}

	
	@Test
	public void firebase_Select_DropDown() throws InterruptedException {
		System.out.println("******firebase_Select_DropDown automation script started***********");
		
		WebElement usernameEle = driver.findElement(By.id("email_field"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,"admin123@gmail.com","username textbox");
		WebElement passwordEle = driver.findElement(By.id("password_field"));
		enterText(passwordEle,"admin123","password textbox");
		WebElement buttonEle=driver.findElement(By.tagName("button"));
		clickElement(buttonEle,"login button");
		WebElement cityDropDownEle= driver.findElement(By.xpath("//*[@id=\"city\"]"));
		selectByIndexData(cityDropDownEle,3,"city drop down");		
		
		
	}
	
	


	


}