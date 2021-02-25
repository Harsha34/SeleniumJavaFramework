package browserAutomation;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageLoading {
	    public static void main(String[] args) {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
	        
	        WebDriver driver = new ChromeDriver();	        
	        driver.get("https://eportal.htcindia.com/_index.php");
	        System.out.println("Loaded");
	        
	    }
	
}
