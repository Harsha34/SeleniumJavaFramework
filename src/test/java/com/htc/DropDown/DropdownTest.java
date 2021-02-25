package com.htc.DropDown;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {
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
	public void test_Dropdown() throws IOException {
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		chromeDriver.get("http://demo-store.seleniumacademy.com/");
		WebElement dropdown = chromeDriver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[5]/a"));
		dropdown.click();

		dropdown = chromeDriver.findElement(By.xpath("(//select[@title=\"Sort By\"])[1]"));
		Select salesDropdown = new Select(dropdown);
		salesDropdown.selectByVisibleText("Name");
		dropdown = chromeDriver.findElement(By.xpath("(//select[@title=\"Sort By\"])[1]"));
		Select saleDropdown1 = new Select(dropdown);
		WebElement selectedOption = saleDropdown1.getFirstSelectedOption();
		System.out.println(selectedOption);
		Assert.assertEquals(selectedOption.getText().trim(), "Name");
		
		Select tools=new Select(chromeDriver.findElement(By.xpath("//select[@title='Sort By']")));
		List beforesort=new ArrayList();
		List<WebElement> elementslist=tools.getOptions();
		for (WebElement webElement : elementslist) {
			String we=webElement.getText().trim();
			beforesort.add(we);
		}
		List temp=new ArrayList();
		temp.addAll(beforesort);
		Collections.sort(temp);
		System.out.println("beforesort:-" +beforesort);
		System.out.println("aftersort:-"+temp);
		
		Assert.assertFalse(beforesort.equals(temp));
		

	}

}
