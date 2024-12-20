package Uibanktestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Uibank_loginvalidation extends UIbank_Baseclass{
	@Test
public void launchurl() {
	driver.navigate().to("https://uibank.uipath.com/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
}
	@Test
	public  void pageinfovalidation() {
		WebElement username = driver.findElement(By.id("username"));
	
		WebElement password = driver.findElement(By.id("password"));
		
		
		
		}
	}
