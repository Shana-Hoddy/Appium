package appiumBasics;
import base.TestBase;
import org.testng.annotations.BeforeTest;

public class DemoBaseClass extends TestBase{
	
	@BeforeTest
	public void configureDemoBaseClass() {		
		TestBase.pathToAPKfile = "\\Users\\shana\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk";
	}
}
