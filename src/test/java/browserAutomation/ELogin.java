package browserAutomation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




import org.testng.Assert;
import org.testng.annotations.*;

public class ELogin {

	  WebDriver driver=null;
	  
	  @BeforeMethod(alwaysRun=true)
		public void setUp() throws Exception {
			System.out.println("Setting up for test");
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		    
		}

		@AfterMethod(alwaysRun=true)
		public void tearDown() throws Exception {
			System.out.println("Cleaning up object");
			driver=null;
		}
	 
	
	
	 
	 @Test
	  public void testportal_InvalidId() throws FileNotFoundException, IOException
	  {
		  Properties con=new Properties();
			con.load(new FileReader("C:\\Users\\HARSHA\\eclipse-Selenium\\browserAutomation\\src\\test\\resources\\connection.properties"));
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		     WebDriver driver=new ChromeDriver();
	        driver.get("https://eportal.htcindia.com/_index.php");
	        
	        WebElement username=driver.findElement(By.xpath("//input[@name=\"user_name\"]"));
			username.sendKeys(con.getProperty("username1"));
			WebElement password=driver.findElement(By.xpath("//input[@name=\"user_pass\"]"));
			password.sendKeys(con.getProperty("password1"));
			WebElement button=driver.findElement(By.xpath("//button[@name=\"subBtn\"]"));
			button.submit();
			WebElement errormsg=driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]\r\n"+ ""));
			assertEquals(errormsg.getText(),"Invalid input data from Login.");
			System.out.println(errormsg.getText());
			
	  }
	  
	  @Test
	  public void testportal_ValidId() throws FileNotFoundException, IOException
	  {
		  Properties con=new Properties();
			con.load(new FileReader("C:\\Users\\HARSHA\\eclipse-Selenium\\browserAutomation\\src\\test\\resources\\connection.properties"));
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		     WebDriver driver=new ChromeDriver();
	        driver.get("https://eportal.htcindia.com/_index.php");
	        
	        WebElement username=driver.findElement(By.xpath("//input[@name=\"user_name\"]"));
			username.sendKeys(con.getProperty("username"));
			WebElement password=driver.findElement(By.xpath("//input[@name=\"user_pass\"]"));
			password.sendKeys(con.getProperty("password"));
			WebElement button=driver.findElement(By.xpath("//button[@name=\"subBtn\"]"));
			button.submit();
			
			
			WebElement msg=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div[1]/h4"));
			
			Assert.assertEquals(msg.getText(),"Employee ID - 25486");
			System.out.println(msg.getText());
			
	  }
	 
	
}