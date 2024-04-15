package ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BrowserTestBase;


public class MobileBrowserTest extends BrowserTestBase{
	
	@Test
	public void browserTest() throws InterruptedException {			
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon")).click();
		
		//click on Products menu
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		
		//scroll to element
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(Duration.ofSeconds(5));
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		Thread.sleep(Duration.ofSeconds(5));
		Assert.assertEquals(text, "Devops");
		
		Thread.sleep(Duration.ofSeconds(5));
				
	}

}
