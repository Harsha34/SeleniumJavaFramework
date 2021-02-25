package com.htc.Registration;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.http.WebSocketHandshakeException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterLogin {
	
	WebDriver driver = null;
	FileInputStream fis;
	Properties prop = new Properties();
	
	@BeforeClass
	public void setup() throws IOException {
		fis = new FileInputStream("C:\\Users\\HARSHA\\eclipse-Selenium\\browserAutomation\\src\\test\\java\\com\\htc\\Registration\\connection.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	@Test(enabled=false)
	public void testCreateAccount_fillMandatoryDetails_successfullyShouldCreateNewAcc() {
		
		
		
		WebElement accountDropDown = driver.findElement(By.xpath("(//span[text() = \"Account\"])[1]"));
		accountDropDown.click();
		WebElement registerButton = driver.findElement(By.xpath("//a[text() = \"Register\"]"));
		registerButton.click();
		
		
		WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@id = \"firstname\"]"));
		firstNameTextBox.sendKeys(prop.getProperty("firstName"));
		WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@id = \"lastname\"]"));
		lastNameTextBox.sendKeys(prop.getProperty("lastName"));
		WebElement emailTextBox = driver.findElement(By.xpath("//input[@id = \"email_address\"]"));
		emailTextBox.sendKeys(prop.getProperty("email"));
		WebElement passcodeTextBox = driver.findElement(By.xpath("//input[@id = \"password\"]"));
		passcodeTextBox.sendKeys(prop.getProperty("passcode"));
		WebElement confirmPasscodeTextBox = driver.findElement(By.xpath("//input[@id = \"confirmation\"]"));
		confirmPasscodeTextBox.sendKeys(prop.getProperty("confirmPasscode"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement confirmButton = driver.findElement(By.xpath("//span[text() = \"Register\"]"));
		confirmButton.click();
		
		Assert.assertEquals("Welcome, "+ prop.getProperty("firstName") + " " + prop.getProperty("lastName") + "!", "Welcome, Harsha A!");
		
		
		
		WebElement accountButton = driver.findElement(By.xpath("(//span[text() = \"Account\"])[1]"));
		accountButton.click();
		
	}
	
	
	@Test
	public void testLoginPage_enterCredantials_shouldLoginSuccessful() {
		

		WebElement accountDropDown = driver.findElement(By.xpath("(//span[text() = \"Account\"])[1]"));
		accountDropDown.click();
		WebElement loginButton = driver.findElement(By.xpath("//a[text() = \"Log In\"]"));
		loginButton.click();
		

		WebElement emailTextBox = driver.findElement(By.xpath("//input[@title = \"Email Address\"]"));
		emailTextBox.sendKeys(prop.getProperty("email"));
		WebElement passcodeTextBox = driver.findElement(By.xpath("//input[@title = \"Password\"]"));
		passcodeTextBox.sendKeys(prop.getProperty("passcode"));
		WebElement loginBtn = driver.findElement(By.xpath("//span[text() = \"Login\"]"));
		loginBtn.click();
		
		Assert.assertEquals("Welcome, "+ prop.getProperty("firstName") + " " + prop.getProperty("lastName") + "!", "Welcome, Harsha A!");	
	}
	
	@Test
	public void testProceedCheckout_selectProductAndEnterDeliveryAddress_orderPlacedSuccessfully() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement menuButton = driver.findElement(By.xpath("(//a[text() =\"Men\"])[1]"));
		Actions mouseAction = new Actions(driver);
		mouseAction.moveToElement(menuButton).perform();
		WebElement shirtOption = driver.findElement(By.xpath("(//a[text() =\"Shirts\"])"));
		shirtOption.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement plainShirtButton = driver.findElement(By.xpath("//a[text() = \"Plaid Cotton Shirt\"]"));
		js.executeScript("arguments[0].scrollIntoView();", plainShirtButton);
		plainShirtButton.click();
		
		
		WebElement colourSelectionButton = driver.findElement(By.xpath("//a[@title = \"Charcoal\"]"));
		colourSelectionButton.click();
		
		
		WebElement sizeSelectionButton = driver.findElement(By.xpath("//a[@title = \"M\"]"));
		sizeSelectionButton.click();
		
		
		WebElement quantityTextBox = driver.findElement(By.xpath("//input[@title = \"Qty\"]"));
		quantityTextBox.clear();
		quantityTextBox.sendKeys(prop.getProperty("Quantity"));
		
		
		WebElement addToCartButton = driver.findElement(By.xpath("(//Span[text() = \"Add to Cart\"])[2]"));
		addToCartButton.click();
		
		
		WebElement checkoutButton = driver.findElement(By.xpath("(//Span[text() = \"Proceed to Checkout\"])[1]"));
		checkoutButton.click();
		
		
		
		
		WebElement addressTextBox = driver.findElement(By.xpath("(//input[@title = \"Street Address\"])[1]"));
		addressTextBox.sendKeys(prop.getProperty("address"));
		
		
		WebElement cityTextBox = driver.findElement(By.xpath("(//input[@title =\"City\"])[1]"));
		cityTextBox.sendKeys(prop.getProperty("city"));
		
		
		Select dropDownCountry = new Select(driver.findElement(By.xpath("(//select[@title =\"Country\"])[1]")));
		dropDownCountry.selectByVisibleText("India");
		
		
		WebElement zipCodeTextBox = driver.findElement(By.xpath("(//input[@title =\"Zip/Postal Code\"])[1]"));
		zipCodeTextBox.sendKeys(prop.getProperty("zipcode"));
		
		
		WebElement phoneNumberTextBox = driver.findElement(By.xpath("(//input[@title =\"Telephone\"])[1]"));
		phoneNumberTextBox.sendKeys(prop.getProperty("phoneNumber"));
		
		
		WebElement continueButton = driver.findElement(By.xpath("(//Span[text() = \"Continue\"])[1]"));
		continueButton.click();
		
		
		WebElement shippingMethodRadioButton = driver.findElement(By.xpath("(//input[@name = \"shipping_method\"])[1]"));
		shippingMethodRadioButton.click();
		
		
		WebElement continueButton1 = driver.findElement(By.xpath("(//span[text() = \"Continue\"])[3]"));
		continueButton1.click();
		
		
		WebElement paymentContinueButton = driver.findElement(By.xpath("(//span[text() = \"Continue\"])[4]"));
		paymentContinueButton.click();
		
		
		WebElement placeOrderButton = driver.findElement(By.xpath("//span[text() = \"Place Order\"]"));
		placeOrderButton.click();
		
		//Asserting
		WebElement orderStatusMessage = driver.findElement(By.xpath("//h1[text() = \"Your order has been received.\"]"));
		Assert.assertEquals(orderStatusMessage.getText(), "YOUR ORDER HAS BEEN RECEIVED.");
	}
	
	
	
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}

}
