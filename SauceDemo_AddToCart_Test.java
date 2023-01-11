package com.gusb.testweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import com.project.pom.CartPage;
import com.project.pom.LogInPage;
import com.project.pom.ProductsPage;
import com.project.pom.WebDriverHelper;

@Test
public class SauceDemo_AddToCart_Test {
	static final Duration loadingWaitTime = Duration.ofSeconds(10);
	
	private static WebDriver driver;
	static CartPage cartPage;
	static ProductsPage productsPage;
	static LogInPage logInPage;
	
	@BeforeMethod
	@BeforeAll
	public static void setUp() throws Exception {
		driver = WebDriverHelper.chromeDriverConnection();
		cartPage = new CartPage(driver);
		productsPage = new ProductsPage(driver);
		logInPage = new LogInPage(driver);
	}

	@AfterMethod
	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}

	public void testAddToCart() {
		logInPage.visitUrl(LogInPage.logInUrl);
		logInPage.implicitlyWait(loadingWaitTime);
		logInPage.logIn();
		logInPage.implicitlyWait(loadingWaitTime);
		
		AssertJUnit.assertTrue(productsPage.isProductsPageDisplayed());
		
		productsPage.addProductToCart(ProductsPage.onesieProductName);
		productsPage.goToCart();
		productsPage.implicitlyWait(loadingWaitTime);
		
		AssertJUnit.assertTrue(cartPage.isCartPageDisplayed());
		AssertJUnit.assertTrue(cartPage.isProductInCart(ProductsPage.onesieProductName));
	}
}
