package testng2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Iannotationtransformer implements IAnnotationTransformer {
	/**
	   * This method will be invoked by TestNG to give you a chance to modify a TestNG annotation read
	   * from your test classes. You can change the values you need by calling any of the setters on the
	   * ITest interface.
	   *
	   * <p>Note that only one of the three parameters testClass, testConstructor and testMethod will be
	   * non-null.
	   *
	   * @param annotation The annotation that was read from your test class.
	   * @param testClass If the annotation was found on a class, this parameter represents this class
	   *     (null otherwise).
	   * @param testConstructor If the annotation was found on a constructor, this parameter represents
	   *     this constructor (null otherwise).
	   * @param testMethod If the annotation was found on a method, this parameter represents this
	   *     method (null otherwise).
	   */
	public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		String testcasename = testMethod.getName();
		if(testcasename.equals("navigateurl")) {
			annotation.setEnabled(true);
			annotation.setPriority(1);	
		}
		else if(testcasename.equals("pageinfo")){
			annotation.setEnabled(true);
			annotation.setPriority(1);	
		} 
		else if(testcasename.equals("searchproduct")){
			annotation.setEnabled(true);
			annotation.setPriority(1);	
		} 
		
		  }
	
}
