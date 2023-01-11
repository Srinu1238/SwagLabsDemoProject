package com.project.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper {
	public static WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "D:\\Dowmloads data\\chromedriver_win32\\chromedriver.exe");
		return new ChromeDriver();
		
	}
}
