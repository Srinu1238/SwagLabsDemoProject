package com.project.pom;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends Base{
	public static final String productsUrl = "https://www.saucedemo.com/inventory.html";
	
	public static final String onesieProductName = "Sauce Labs Onesie";
	Duration loadingWaitTime = Duration.ofSeconds(1000);
	
	By pageTitleLocator = By.xpath("//span[@class=\"title\"]");
	By addOnesieBtnLocator = By.id("add-to-cart-sauce-labs-onesie");
	//By logOutLinkLocator = By.xpath("//a[contains(., \"Logout\")]");
	By logOutLinkLocator = By.id("logout_sidebar_link");
	By menuBtnLocator = By.id("react-burger-menu-btn");
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public void goToCart() {
		visitUrl(CartPage.cartUrl);
	}
	
	public boolean isProductsPageDisplayed() {
		if(productsUrl.equals(getCurrentUrl()) && "PRODUCTS".equals(getText(pageTitleLocator))) return true;
		else return false;
	}
	
	public void addProductToCart(String productName) {
		if(productName.equals(onesieProductName)) {
			click(addOnesieBtnLocator);
		}
		else System.out.println("Something went wrong :(\nThe product you want doesn't exist.");
	}

	public void logOut() {
		click(logOutLinkLocator);
	 }
	
	public void openSideMenu() {
		click(menuBtnLocator);
	}
}
