package com.htc.shopping;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Screen{
	
	WebDriver driver = null;
	FileInputStream fis;
	Properties prop = new Properties();
	
	
	@BeforeMethod
	public void setup() throws IOException {
		fis = new FileInputStream("C:\\Users\\HARSHA\\eclipse-Selenium\\browserAutomation\\src\\test\\resources\\connection.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo-store.seleniumacademy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void simulateFREInSearchBar_takeScreenshot_storeItInFile() throws IOException, InterruptedException{
		WebElement searchBar = driver.findElement(By.xpath("//input[@name = \"q\"]"));
		searchBar.sendKeys("fre");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\HARSHA\\eclipse-Selenium\\browserAutomation\\src\\test\\resources\\Image\\harsha.jpg");
		FileUtils.copyFile(srcFile, destFile);	
	}
	@AfterMethod
	public void tearDown() {
//		driver.close();
	}
}
