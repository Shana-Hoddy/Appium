package ecommerce;
import base.TestBase;
import org.testng.annotations.BeforeTest;


public class EcommerceBaseClass extends TestBase{
	
	@BeforeTest
	public static void configureDemoBaseClass() {		
		TestBase.pathToAPKfile = "\\Users\\shana\\Documents\\rahulAppiumPackages\\General-Store.apk";
	}
}
