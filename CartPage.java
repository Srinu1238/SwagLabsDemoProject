package com.project.pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends Base{
	public static final String cartUrl = "https://www.saucedemo.com/cart.html";
	Duration loadingWaitTime = Duration.ofSeconds(10);
	
	By pageTitleLocator = By.xpath("//span[@class=\"title\"]");
	By productsTitleLocator = By.xpath("//div[@class=\"inventory_item_name\"]");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
 public boolean isProductInCart(String productName) {
		if(isDisplayed(productsTitleLocator)) {
			if(productName.equals(ProductsPage.onesieProductName)) {
				List<WebElement> productNames = findElements(productsTitleLocator);
				
				for(WebElement product : productNames) {
					if(ProductsPage.onesieProductName.equals(getText(product))) return true;
				}
			}
			else System.out.println("Something went wrong :(\nThe product you want doesn't exist.");
		}
		else System.out.println("Something went wrong :(\nNo products were present.");
		
		return false;
	}
	
	public boolean isCartPageDisplayed() {
		if(cartUrl.equals(getCurrentUrl()) && "YOUR CART".equals(getText(pageTitleLocator))) return true;
		else return false;
	}
}
