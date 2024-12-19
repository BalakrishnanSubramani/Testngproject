package testng2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testngwithdataprovider extends P4_Baseclasswithaparametersinxml {

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
	@DataProvider(name ="Singleparam" )//to define no of paramters
	public String [] passprodname() {
		String [] prodname = {"iphone","Samsung","Lenovo"};
		//pass the value into an array
		return prodname;
	}
	@DataProvider(name ="Multiprod")
	public String[][] setpdornameandprodcategory()
	{
		String[][] prodName =  new String[2][3]; //[2] represent no of parameter to be passe
		prodName[0][0] = "Apple";
				prodName[0][1]= "Cell Phones & Accessories";	                  //[3] represents no of values to be passed
		prodName[1][0]= "Samsung";	
		prodName[1][1]= "Cell Phones & Accessories";
		prodName[2][0] = "LG";
		prodName[2][1]= "Cell Phones & Accessories";
		return prodName;

	}
	
//	@Test(priority = 3,dataProvider = "Singleparam")
	public  void searchproduct( String prodname) {
WebElement oText,oDrop,oBtn;
		//optional annotaion means values for parameters
		oText = driver.findElement(By.id("gh-ac"));
		oText.clear();
		oText.sendKeys(prodname);
		
		oDrop = driver.findElement(By.id("gh-cat"));
		Select select = new Select(oDrop);
		select.selectByVisibleText("Cell Phones & Accessories");
		
		oBtn = driver.findElement(By.id("gh-btn"));
		oBtn.click();
	
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
