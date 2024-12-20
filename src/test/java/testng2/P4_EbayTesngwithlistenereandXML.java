package testng2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;





public class P4_EbayTesngwithlistenereandXML extends P4_Baseclass {

	public String surl = "https://www.ebay.com/";
	
	@Test(priority = 1)
	public  void navigateurl() {
		driver.get(surl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	@Test(priority = 2)
	public  void pageinfo() {
		String title = driver.getTitle();
	//	Assert.assertEquals(title, "ebay");
		if(title.equals("ebay")) {
			Assert.assertTrue(true);
			//it checks condition
		}
		else {
			SoftAssert softassert = new SoftAssert();
			softassert.assertAll();
		}
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
	
	
}
