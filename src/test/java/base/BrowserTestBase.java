package base;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

//making abstract in case future tests need to modify the start and teardown methods
public abstract class BrowserTestBase {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static String pathToAPKfile;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		//code to start the Appium server so we don't have to bring up terminal first
		 service = new AppiumServiceBuilder()
				.withAppiumJS(new File("\\Users\\shana\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.0.10")
				.usingPort(4723)
				.build();		
		service.start();
		
		
		//appium code -> appium server -> mobile device	
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("RahulPhone");
		options.setChromedriverExecutable("\\Users\\shana\\eclipse\\drivers\\chromedriver.exe");
		
		//ONLYTHING NEW FOR BROWSER TESTING
		options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver (new URI( "http://192.168.0.10:4723").toURL(), options);
		
		//set default timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
	}
		
			
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

	
}
