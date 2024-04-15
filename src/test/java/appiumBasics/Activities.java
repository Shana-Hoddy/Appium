package appiumBasics;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import java.net.MalformedURLException;


public class Activities extends DemoBaseClass{
	
	@Test
	public void miscStuff() throws MalformedURLException, InterruptedException {
				
		//how to go direct to a mobile page.
		//send activity package & app activity
		//> adb shell dumpsys window | findstr "mCurrentFocus"
		//Window{68dea62 u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
		//package name is: io.appium.android.apis
		//activity name is:  io.appium.android.apis.preference.PreferenceDependencies
		String activity = "io.appium.android.apis/io.appium.android.apis.preference.PreferencesFromXml";		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				"intent", activity));		
		Thread.sleep(2000);				
		
	}	
	
	
}
