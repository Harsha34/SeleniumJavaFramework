package com.htc.googlesearch;

import org.openqa.selenium.By; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");

         WebDriver driver = new ChromeDriver(); 
         driver.get("http://www.google.com"); 
         WebElement element = driver.findElement(By.name("q"));
         element.sendKeys("email");
         element.submit();

         //driver.close();
    }



}