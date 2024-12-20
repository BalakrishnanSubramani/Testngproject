package testng2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngwithparametersincomaptiableXML extends P4_Baseclasswithaparametersinxml {

public String surl = "https://www.ebay.com/";
	
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
	@Parameters({"Searchproduct","SearchCategory"})//howmany parameters we pass
	@Test(priority = 3,dependsOnMethods = {"navigateurl","pageinfo"})
	public  void searchproduct(@Optional("iphone") String prodname,@Optional("Cell Phones & Accessories") String prodcat) {
WebElement oText,oDrop,oBtn;
		//optional annotaion means values for parameters
		oText = driver.findElement(By.id("gh-ac"));
		oText.sendKeys(prodname);
		
		oDrop = driver.findElement(By.id("gh-cat"));
		Select select = new Select(oDrop);
		select.selectByVisibleText(prodcat);
		
		oBtn = driver.findElement(By.id("gh-btn"));
		oBtn.click();
	
	}
}
