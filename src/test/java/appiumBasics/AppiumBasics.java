package appiumBasics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumBy;


public class AppiumBasics extends DemoBaseClass{
	
	@Test
	public void WifiSettingsName() throws MalformedURLException, URISyntaxException {
				
		//xpath, id, accessibilityID, className, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		WebElement wifiSetting = driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]"));
		wifiSetting.click();		
		
		String text = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(text, "WiFi settings", "title not as expected");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Rahul Wifi");
		driver.findElement(By.id("android:id/button1")).click();
				
		
		
		
		
		
		//set wifi name		
		
		
	}
	
	
}
