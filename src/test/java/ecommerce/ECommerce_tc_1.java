package ecommerce;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.SupportsContextSwitching;
import utils.AndroidElementActions;
import utils.HelperMethods;

public class ECommerce_tc_1 extends EcommerceBaseClass {
	
	@Test
	public void fillForm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.androidsample.generalstore:id/nameField")));
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("shana lara");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		
		//dropdown boxes
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		new AndroidElementActions(driver).scrollToText("\"Argentina\"");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);		
	}
	
	@Test
	public void toast() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//android toast messages must have tag of: android.widget.Toast
		//toast messages have a mandatory "name" attribute which is the text value of the toast
		//we can use index to grab toast message
		String toastName = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastName,  "Please enter your name");
		Thread.sleep(2000);
	}
	
	@Test
	public void lesson46() {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("shana lara");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//add first item to cart
		driver.findElement(By.xpath
				("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]"))
				.click();
		//get price of item 1
		String cost1 = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[1]")).getText();
		
		
		//add second item to cart
		driver.findElement(By.xpath
				("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]"))
				.click();
		//get price of item 2
		String cost2 = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[2]")).getText();
		
		//click on Cart icon
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//wait for cart page to load
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains
				( driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" ,"Cart"));	
		
		//get items in cart
		String productName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(productName, "Air Jordan 4 Retro");
		
		//get prices in cart
		List<WebElement> items = driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productPrice']"));
		double price = 0.0;
		for (WebElement i : items) {
			//remove $ add $160.97 + $120.0
			price += HelperMethods.getFormattedAmount(i.getText());			
		}
		
		String total = driver.findElement(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/totalAmountLbl']")).getText();
		double displayedTotal = HelperMethods.getFormattedAmount(total); 
		
		System.out.println(price + " " + displayedTotal);
		Assert.assertEquals(price, displayedTotal, 0.001);
		
	}
	
	
	@Test
	public void findProductLesson50() {
		AndroidElementActions actions = new AndroidElementActions(driver);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("shana lara");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		//scroll to "Jordan 6 Rings"
		actions.scrollToText("\"Jordan 6 Rings\"");
		// now add to cart
		List<WebElement> products = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
	
		for (int i = 0; i < products.size(); i++) {
			String productName =  (products.get(i)).getText();
			if (productName.equals("Jordan 6 Rings")) {				
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}				
		}
		
		//click on Cart icon
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//wait for cart page to load
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains
				( driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" ,"Cart"));	
				
		//open the terms of conditions
		actions.longPressAction(By.id("com.androidsample.generalstore:id/termsButton"));
		//close it
		driver.findElement(By.id("android:id/button1")).click();
		
		//click checkbox
		driver.findElement(By.className("android.widget.CheckBox")).click();
		
		//visit website to complete purchase
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();	
				
	}	
	
	@Test
	public void hybridLesson52() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("shana lara");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//add first item to cart
		driver.findElement(By.xpath
				("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]"))
				.click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//wait for cart page to load
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains
				( driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" ,"Cart"));	
		
		//click check box
		driver.findElement(By.className("android.widget.CheckBox")).click();
		
		//visit web site to complete purchase
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(Duration.ofSeconds(3));
		
		Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
		System.out.println(contextNames);	
		for (String handle: contextNames) {
			if (handle.contains("WEBVIEW")) {
				driver.context(handle);
				break;
			}			
		}
		
		driver.findElement(By.name("q")).sendKeys("cat", Keys.ENTER);
		
		//now go back to the native app
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
				
	}

}
