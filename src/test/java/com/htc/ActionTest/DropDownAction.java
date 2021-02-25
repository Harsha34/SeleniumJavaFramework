package com.htc.ActionTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownAction {
	WebDriver chromedriver = null;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
	}

	
	@AfterMethod
	public void teardown() {
		System.out.println("Cleaning up the object");
	}

	@Test
	public void test_DropdownAction() throws IOException {
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		chromeDriver.get("http://demo-store.seleniumacademy.com/");
		Actions action = new Actions(chromeDriver);
	
		WebElement dropdown = chromeDriver.findElement(By.xpath("//ol[@class='nav-primary']//li[@class='level0 nav-5 parent']//a[text()='Sale']"));
		action.moveToElement(dropdown).build().perform();
		
		chromeDriver.findElement(By.xpath("//ul[@class='level0']//li[@class='level1 view-all']//a[text()='View All Sale']")).click();
		
		
		chromeDriver.findElement(By.xpath("//select[@title='Sort By']")).click();
		
		chromeDriver.findElement(By.xpath("(//option[@value='http://demo-store.seleniumacademy.com/sale.html?dir=asc&order=name'])[1]")).click();
		Select tools=new Select(chromeDriver.findElement(By.xpath("//select[@title='Sort By']")));
		List beforesort=new ArrayList();
		List<WebElement> elementslist=tools.getOptions();
		for (WebElement webElement : elementslist) {
			String we=webElement.getText().trim();
			beforesort.add(we);
		}
		List aftersort=new ArrayList();
		aftersort.addAll(beforesort);
		Collections.sort(aftersort);
		System.out.println("beforesort:-" +beforesort);
		System.out.println("aftersort:-"+aftersort);
		Assert.assertFalse(beforesort.equals(aftersort));
		WebElement na=chromeDriver.findElement(By.xpath("(//option[@value='http://demo-store.seleniumacademy.com/sale.html?dir=asc&order=name'])[1]"));
		Assert.assertEquals(na.getText().trim(), "Name");
	}

	
}