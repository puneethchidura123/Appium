package com.org.saib.travelapp.uitests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	UiAutomator2Options uiAutomator2Options;
	public static AndroidDriver androidDriver;
	
	
	//PropertyConfig
	
	@BeforeClass
	public void setUpWithLamdaTest() throws MalformedURLException
	{
		System.out.println("Before Class ");
		
		uiAutomator2Options = new UiAutomator2Options();
		uiAutomator2Options.setDeviceName("Pixel XL API 30");// setting name of the emulator
		//uiAutomator2Options.setChromedriverExecutable("");
		//uiAutomator2Options.setApp("F:\\Learning\\AppiumPractice\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk"); // setting the location of app OR .apk file 
		uiAutomator2Options.setApp("E:\\Learning\\AppiumPractice\\Appium\\src\\test\\java\\resources\\31may3.43.apk"); // setting the location of app OR .apk file
		//uiAutomator2Options.setCapability("no-reset", false);
	
		
		androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723"),uiAutomator2Options);
		androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//@BeforeClass
	public void SetUp() throws MalformedURLException
	{
// starting appium server programatically
		
//		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\puneeth chidura\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		
		uiAutomator2Options = new UiAutomator2Options();
		uiAutomator2Options.setDeviceName("Android_Emulator");// setting name of the emulator
		//uiAutomator2Options.setApp("F:\\Learning\\AppiumPractice\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk"); // setting the location of app OR .apk file 
		uiAutomator2Options.setApp("F:\\Learning\\AppiumPractice\\Appium\\src\\test\\java\\resources\\General-Store.apk"); // setting the location of app OR .apk file
		
		androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723"),uiAutomator2Options);
		androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void TearDown()
	{
		androidDriver.quit();
		//service.stop();
	}
	
	
	// below are some reusable methods
	
	public void longClick(WebElement element,long duration)
	{
		((JavascriptExecutor)androidDriver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) element).getId(),
				"duration",duration
				));	
	}
	
	public void swipe(WebElement element,String direction,double percentage)
	{
		((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) element).getId(),
			    "direction", direction,
			    "percent", percentage
			));
	}
	
	public void scrollToText(String Text)
	{
		androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Text+"\"))"));
	}
	
	public void resetApp()
	{
		androidDriver.resetApp();
	}
}
