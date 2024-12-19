package testng;




import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

import io.netty.handler.timeout.TimeoutException;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

import org.testng.annotations.BeforeClass;


public class P1_Allannotation {
  @Test(priority = 2)
  public void testcase1() {
	  System.out.println("Testcase1");
  }
  
  @Test (priority =3,enabled = false,invocationCount = 3,timeOut = 2000)
  public void testcase2() {
	  System.out.println("tetscase2");
  }
  @Test(priority = 1,expectedExceptions = {ThreadTimeoutException.class,TimeoutException.class})
  public void testcase3() {
	  System.out.println("tetscase4");
  }
  @BeforeMethod
  public void beforemethod() {
	  System.out.println("beforemethod will be getting	 executed before each testcase");
  }
  @AfterMethod
  public void aftermethod() {
	  System.out.println("aftermethod will be getting exectued after each test case");
  }
@BeforeClass
  public void beforeclass() {
	  System.out.println("beforeclass will be getting executed only once before all testcase");
  }
@AfterClass
  public void afterclass() {
	  System.out.println("Afterclass will be getting executed only once after all testcase");
  }
@BeforeTest
public void beforetest() {
	System.out.println("beforetest  will be getting executed only once before all testcase as well as before 'Before class' for all the classes in the project");
}
@AfterTest
public void aftertest() {
	System.out.println("aftertest  will be getting executed only once after all testcase as well as after 'After class' for all the classes in the project");
	}
@BeforeSuite
public void beforesuite() {
	System.out.println("beforesuite  will be getting executed only once before all testcase as well as before 'Before class' and 'before test'for all the classes in the project");
	}
@AfterSuite
public void aftersuite() {

	System.out.println("aftersuite  will be getting executed only once before all testcase as well as before 'Before class' and 'before test'for all the classes in the project");

}

}

