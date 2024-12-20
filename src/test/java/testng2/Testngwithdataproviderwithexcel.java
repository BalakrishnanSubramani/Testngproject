package testng2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import wrapper.Dataproviderobject;

public class Testngwithdataproviderwithexcel extends P4_Baseclasswithaparametersinxml {

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
	
	@DataProvider(name ="Multiprod")
	public Object[][] setpdornameandprodcategory() throws IOException
	{
		Object[][] prodName =  Dataproviderobject.getvalue("Book1");
		return prodName;
	}

	@Test(priority =3,dataProvider = "Multiprod")
	public  void searchproductandcat( String prodname,String prodcat ) {
WebElement oText,oDrop,oBtn;
		
		oText = driver.findElement(By.id("gh-ac"));
		oText.clear();
		oText.sendKeys(prodname);
		
		oDrop = driver.findElement(By.id("gh-cat"));
		Select select = new Select(oDrop);
		select.selectByVisibleText(prodcat);
		
		oBtn = driver.findElement(By.id("gh-btn"));
		oBtn.click();
	
	}
}
