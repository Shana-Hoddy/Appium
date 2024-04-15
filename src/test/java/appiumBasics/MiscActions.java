package appiumBasics;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class MiscActions extends DemoBaseClass{
	
	@Test
	public void miscStuff() throws MalformedURLException, InterruptedException {
				
	
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Preferences from XML")).click();
		//checkbox
		driver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"])[1]")).click();	
			
		//textbox
		driver.findElement(By.xpath
				("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();	
		//copy paste
		driver.setClipboardText("I like cats");	
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());				
		driver.findElement(By.id("android:id/button1")).click();

		//list preferences
		driver.findElement(By.xpath
				("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[3]/android.widget.RelativeLayout")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Alpha Option 01\"]")).click();
						
		//rotate to landscape
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		
		//back button
		//driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[4]/android.widget.RelativeLayout")).click();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		
		//press key
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		
		
	}	
	
	
}
