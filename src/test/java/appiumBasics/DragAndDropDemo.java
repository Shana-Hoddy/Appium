package appiumBasics;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import utils.AndroidElementActions;


public class DragAndDropDemo extends DemoBaseClass{
	
	@Test
	public void dragAndDrop() throws MalformedURLException, InterruptedException {
				
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		By itemToDrag = By.id("io.appium.android.apis:id/drag_dot_1");		
		new AndroidElementActions(driver).dragAndDropAction(itemToDrag, 800, 700);
	
		Thread.sleep(2000);
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
	}	
	
	
}
