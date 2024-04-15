package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidElementActions implements ElementActions{
	
	AndroidDriver driver;
	public AndroidElementActions(AndroidDriver driver){
		this.driver = driver;
	}

	public void longPressAction(By by) {
		/*https://github.com/rakjha/appium/blob/master/docs/en/writing-running-appium/android/android-mobile-gestures.md
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) element).getId()
		));
		*/
		WebElement ele =  driver.findElement(by);
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of
				("elementId", ((RemoteWebElement)ele).getId(),
						"duation", 2000));
	}
	
	
	public void scrollToText(String textToScrollTo) {
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(" + textToScrollTo + "))"));	
	}
	
	/* another way: using appium
	 * for when we don't know what element to scroll to, so scroll somewhere and then look for element.
	 *  https://github.com/rakjha/appium/blob/master/docs/en/writing-running-appium/android/android-mobile-gestures.md
	*/	
	public  void scrollToEndAction() {
		boolean canScrollMore = false;
		
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
    		"left", 100, "top", 100, "width", 200, "height", 200,
    		"direction", "down",
    		"percent", 3.0
			));
		} while(canScrollMore);
	}
	
	public  void swipeAction(By by, String direction) {
		//now swipe: https://github.com/rakjha/appium/blob/master/docs/en/writing-running-appium/android/android-mobile-gestures.md
				((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement)driver.findElement(by)).getId(),
				    "direction", direction,
				    "percent", 0.75
				));
	}
	
	public  void dragAndDropAction(By by, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) driver.findElement(by)).getId(),
			    "endX", x,
			    "endY", y
			));		
	}

	
}
