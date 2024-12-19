package testng2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class P4_Baseclasswithaparametersinxml {

	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass()
	public  void launcbrowserdriver(@Optional ("chrome")String browser) {
		
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
