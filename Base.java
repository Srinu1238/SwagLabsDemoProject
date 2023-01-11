package com.project.pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base 

{
	WebDriver driver;
	
	public Base(WebDriver driver) 
	
	{
		this.driver = driver;
	}
	
 public WebElement findElement(By locator)
	
	{
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator) 
	
	{
		return driver.findElements(locator);
	}
	
	public String getText(By locator) 
	
	{
		return driver.findElement(locator).getText();
	}
	
	public String getText(WebElement element) 
	
	{
		return element.getText();
	}
	
	public void type(String inputText, By locator)
	
	{
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void sendKey(Keys key, By locator) 
	
	{
		driver.findElement(locator).sendKeys(key);
	}
	
	public void click(By locator)
	
	{
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) 
	
	{
		try {
			return driver.findElement(locator).isDisplayed();
		} 
		
		catch (org.openqa.selenium.NoSuchElementException e)
		
		{
			return false;
		}
	}
	
	public void visitUrl(String url) 
	
	{
		driver.get(url);
	}
	
	public void implicitlyWait(Duration loadingWaitTime)
	
	{
		driver.manage().timeouts().implicitlyWait(loadingWaitTime);
	}
	
	public String getCurrentUrl()
	
	{
		return driver.getCurrentUrl();
	}
}
