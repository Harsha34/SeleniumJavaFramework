package browserAutomation;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Eportal {

WebDriver driver = null;
	
	
	@BeforeMethod
	public void setup() {
	

	
		// TODO Auto-generated method stub
		//accessing website through chrome.
		
	   System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");//Where our Driver Binary located
		 driver = new ChromeDriver();
		
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Cleaning Up the resources");
		
	}
	
	@Test
	public void logintest_Loadpage() throws IOException
	{
		
		Properties prop=new Properties();
		InputStream in=getClass().getClassLoader().getResourceAsStream("connection.properties");
		prop.load(in);
		driver.get("https://eportal.htcindia.com/index.php");
		WebElement username=driver.findElement(By.name("user_name"));
		WebElement password=driver.findElement(By.name("user_pass"));
		WebElement login=driver.findElement(By.xpath("//button[@name='subBtn']"));
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
	  
        login.click();
		String source="https://eportal.htcindia.com/_index.php";
		String destination=driver.getCurrentUrl();

        /*Assert.assertEquals(expectedUrl,actualUrl);*/
		
		 if(source.equalsIgnoreCase(destination))
	        {
	            System.out.println("Valid Login details");
	        }
	        else
	        {
	            System.out.println("Invalid Login details");
	        }
		
		
}

}		
		