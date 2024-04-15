package appiumBasics;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import utils.AndroidElementActions;


public class ScrollDemoTest extends DemoBaseClass{
	
	@Test
	public void scrollDemoTest() throws MalformedURLException, InterruptedException {
				
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//one way to scroll using androi ui automator 
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Layouts\"))"));
		
		
	
		
		new AndroidElementActions(driver).scrollToEndAction();
	
		
		
	}	
	
	
}
