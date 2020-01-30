package ZoomWorkers;

import org.testng.annotations.*;

public class AnnotationDemo {

	@BeforeMethod
	public void testOne() {
		System.out.println("Login functionality");
	}
	
	@Test	//(enabled=false)
	public void testTwo() {
		System.out.println("Search Functinality");
	}
	
	@Test
	public void testThree() {
		System.out.println("Test-3");
	}
}
