package appiumBasics;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import utils.AndroidElementActions;


public class SwipeDemo extends DemoBaseClass{
	
	@Test
	public void longPressGesture() throws MalformedURLException, InterruptedException {
				
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		By firstImage = By.xpath("(//android.widget.ImageView)[1]");
		//check if first image is focusable.		
		Assert.assertEquals((driver.findElement(firstImage)).getAttribute("focusable"),"true");
		
		new AndroidElementActions(driver).swipeAction(firstImage, "left");
		
		//now first image focusable attribute should be false
		Assert.assertEquals((driver.findElement(firstImage)).getAttribute("focusable"),"false");
	}	
	
	
}
