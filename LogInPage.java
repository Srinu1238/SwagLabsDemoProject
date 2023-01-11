package com.project.pom;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends Base{
	public static final String logInUrl = "https://www.saucedemo.com/";
	String validUser = "standard_user";
	String validPasswd = "secret_sauce";
	String invalidUser = "invalid_user";
	String invalidPasswd = "not_secret_just_ketchup";
	Duration loadingWaitTime = Duration.ofSeconds(10);
	
	
	By userLocator = By.id("user-name");
	By passwdLocator = By.id("password");
	By logInBtnLocator = By.id("login-button");
	By errorBtnLocator = By.xpath("//button[@class=\"error-button\"]");
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
 public void logIn() {
		if(isDisplayed(logInBtnLocator)) {
			type(validUser, userLocator);
			type(validPasswd, passwdLocator);
			click(logInBtnLocator);
		}
		else System.out.println("Something went wrong :(\nLog in button was not present.");
	}

	public void invalidLogIn() {
	   if(isDisplayed(logInBtnLocator)) {
			type(invalidUser, userLocator);
			type(invalidPasswd, passwdLocator);
			click(logInBtnLocator);
	}
		else System.out.println("Something went wrong :(\nLog in button was not present.");
	}
	
	public boolean isErrorMsgDispayed() {
		if(isDisplayed(errorBtnLocator)) 
			return true;
		else {
			return false;
	  }
	}
	public boolean isLogInPageDisplayed() {
		if(logInUrl.equals(getCurrentUrl()) && isDisplayed(logInBtnLocator)) 
			return true;
		       else {
			return false;
	}
 }
}