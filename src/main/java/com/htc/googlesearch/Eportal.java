package com.htc.googlesearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Eportal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");//Where our Driver Binary located
		WebDriver driver = new ChromeDriver();

		// Interface Reference Object=new Implementation() implementation DownCasting

			//Navigating to a particular website use driverobject.get(URL)
		driver.get("https://eportal.htcindia.com");
		WebElement username=driver.findElement(By.name("user_name"));
		username.sendKeys("25486");
		
		List<WebElement> forminputs=driver.findElements(By.className("form-control"));
		
		forminputs.get(0).sendKeys(" ");
		forminputs.get(1).sendKeys("Wrong");
		
	}

}