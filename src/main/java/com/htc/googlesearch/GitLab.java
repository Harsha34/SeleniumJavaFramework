package com.htc.googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitLab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://gitlab.com/users/sign_up");
		driver.findElement(By.id("new_user_first_name")).sendKeys("anuma");
		driver.findElement(By.id("new_user_last_name")).sendKeys("harsha");
		driver.findElement(By.name("new_user[username]")).sendKeys("qwqr123");
		driver.findElement(By.name("new_user[email]")).sendKeys("harsha@gmail.com");
		driver.findElement(By.name("new_user[password]")).sendKeys("vbnm7890");
		//driver.findElement(By.name("commit")).click();
	}

}
