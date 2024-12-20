package testng2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testngwithitestlistenere extends P4_Baseclasswithaparametersinxml {

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
		System.out.println("Page title is : "+driver.getTitle());
		if(title.equals("ebay")) {
			Assert.assertTrue(true);
		}
		else {
			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(true);
		}
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
	@Test(priority = 4)
	public void user_should_see_the_result() {
		System.out.println("Hi");
		WebElement oResult;
		oResult = driver.findElement(By.xpath("(//h1[@class='srp-controls__count-heading']/span)[1]"));
		String sResult = oResult.getText();
		sResult = sResult.replaceAll("[^0-9]", "");
		System.out.println("Search Result is : "+sResult);
		
		int iResult = Integer.parseInt(sResult);
		if(iResult > 0) {
			System.out.println("Search results are available....");
			List<WebElement> resultLists = driver.findElements(By.
					xpath("(//ul[@class='srp-results srp-list clearfix']/li[contains(@class,'s-item s-item')])"));
			for (WebElement resultList : resultLists) {
				WebElement product = resultList.findElement(By.xpath(".//a[@class='s-item__link']"));
				String productName = product.getText();
				System.out.println(productName);
							}
		}else {
			System.out.println("Search results are not available....");
			
		}
	}

}
