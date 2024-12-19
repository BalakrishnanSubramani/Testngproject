package testng2;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ISuitelistenerclass implements ISuiteListener {

	long starttime;
	long executiontime;
	//ISuiteListener is having below method ,we override this method
	/**
	   * This method is invoked before the SuiteRunner starts.
	   *
	   * @param suite The suite
	   */
	 public void onStart(ISuite suite) {
		 System.out.println("onstart suite name is"+suite.getName());
		 starttime = System.currentTimeMillis();
		 System.out.println("strat time in ms is"+starttime);
		  }
	 /**
	   * This method is invoked after the SuiteRunner has run all the tests in the suite.
	   *
	   * @param suite The suite
	   */
	 public void onFinish(ISuite suite) {
		 System.out.println("onfinishsuite is"+suite.getName());
		 executiontime = System.currentTimeMillis()-starttime ;
		 System.out.println("Execution time in ms is"+executiontime);
		  }
}
