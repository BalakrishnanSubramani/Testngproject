package Uibanktestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class UIbank_Baseclass {

	public WebDriver driver;
	public String browser="chrome";
	@BeforeClass
	public  void launcbrowserdriver() {
		
		switch (browser.toLowerCase()) {
		case "chrome":
			System.out.println("Launching chrome driver");
			driver = new ChromeDriver();
			break;
		case   "edge":
	    	   System.out.println("Launching "+browser+"");
	    	   driver = new EdgeDriver();
				break;	
	       case   "firefox":
	    	   System.out.println("Launching "+browser+"");
	    	   driver = new FirefoxDriver();
				break;	
			default:
				System.out.println("None of mentioned browser exist in dirver,we are launching chromedriver");
				driver = new ChromeDriver();
				break;
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
}
	@AfterClass
	public  void closebrowser() {
		driver.quit();
	}
	
}
