import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


//clicking on run all ,it executes all test methods in a class
public class practiseTestng {
	@Test  //clicking on run executes particular test methods only
	public void TestGoogle() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Google",Keys.ENTER);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(5000);
		driver.quit();
		
	}
	@Test
	public void TestaMAZON() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Google",Keys.ENTER);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(5000);
		driver.quit();
	//TestNg executes test method alphabatically if we dont mention test execution sequence
}
}
