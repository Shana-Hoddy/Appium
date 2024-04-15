package appiumBasics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import utils.AndroidElementActions;


public class LongPressDemo extends DemoBaseClass{
	
	@Test
	public void longPressGesture() throws MalformedURLException, InterruptedException {
				
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();	
		
		new AndroidElementActions(driver).longPressAction(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		WebElement menuToLongPress =  driver.findElement(By.id("android:id/title"));	
		String menuText = menuToLongPress.getText();
		Assert.assertEquals(menuText, "Sample menu");
		Assert.assertTrue(menuToLongPress.isDisplayed());	
		
	}	
	
	
}
