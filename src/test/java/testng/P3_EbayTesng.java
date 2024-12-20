package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class P3_EbayTesng {

	public  WebDriver driver;
	public  String surl ="https://www.ebay.com/";
	public  String browser="Chrome";
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
	@Test(priority = 1)
	public  void navigateurl() {
		driver.get(surl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	@Test(priority = 2)
	public  void pageinfo() {
		System.out.println("Page title is : "+driver.getTitle());
		
		System.out.println("Page URL is : "+driver.getCurrentUrl());
		
	}
	@Test(priority = 3)
	public  void searchproduct() {
WebElement oText,oDrop,oBtn;
		
		oText = driver.findElement(By.id("gh-ac"));
		oText.sendKeys("iphone");
		
		oDrop = driver.findElement(By.id("gh-cat"));
		Select select = new Select(oDrop);
		select.selectByVisibleText("Cell Phones & Accessories");
		
		oBtn = driver.findElement(By.id("gh-btn"));
		oBtn.click();
	
	}
	@AfterClass
	public  void closebrowser() {
		driver.quit();
	}
	
}
