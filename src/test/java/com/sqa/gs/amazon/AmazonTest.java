package com.sqa.gs.amazon;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class AmazonTest {

	// WebDriver that drives the test
	private WebDriver driver;

	// Base url of domain of testing web app
	private String baseUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		// Sets up the WebDriver to use Firefox
		this.driver = new FirefoxDriver();
		// Sets the baseURL to amazon.com
		this.baseUrl = "https://www.amazon.com";
		// Sets up default implicit wait to wait for 30 seconds
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Set up other window options such as fullscreen
		// this.driver.manage().window().fullscreen();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// Closes the WebDriver and quits the browser.
		this.driver.quit();
	}

	@Test
	public void testAmazon() throws Exception {
		// Get the base URL
		this.driver.get(this.baseUrl + "/");
		// Locate the searchbox and set it to a WebElement object and operated
		// against
		WebElement searchField = this.driver.findElement(By.id("twotabsearchtextbox"));
		searchField.click();
		searchField.clear();
		searchField.sendKeys("Newdora Windproof Travel Umbrella");
		// Locate the search button and click on it
		this.driver.findElement(By.cssSelector("input.nav-input")).click();
		// Locate the item in the result list and select it
		this.driver.findElement(By.xpath("(//li[@id='result_0']/div/div[3]/div/a/h2)[2]")).click();
		// Locate the quantity field and select it
		// this.driver.findElement(By.id("quantity")).click();
		// Converting to a Select object, use the selectByVisibleText to change
		// quantity to 3
		Select quantityField = new Select(this.driver.findElement(By.id("quantity")));
		quantityField.selectByVisibleText("3");
		// Select the add to cart button
		this.driver.findElement(By.id("add-to-cart-button")).click();
		// Select the view cart button
		this.driver.findElement(By.id("hlb-view-cart-announce")).click();
		// Assert that the actual total is the expected total
		WebElement totalCostField = this.driver.findElement(By.xpath(".//*[@id='sc-subtotal-amount-activecart']/span"));
		String actualCost = totalCostField.getText();
		Assert.assertTrue(actualCost.equals("$65.85"));
		// Locate the delete all items button and clear the cart
		this.driver.findElement(By.xpath("//div[2]/div/span/span/input")).click();
	}
}
