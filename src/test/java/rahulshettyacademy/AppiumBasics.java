package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest{

	@Test
	public void AppiumTest() throws MalformedURLException
	{
		// identifying preference on app home screen and clicking on it   
		androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//identifying 'Preference dependencies' on next screen and clicking on it 
		androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		//identifying wifi checkbox on next screen and enabling it
		androidDriver.findElement(By.id("android:id/checkbox")).click();
		//identifying WiFi Settings on the same screen and clicking on it
		androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//identifying the alert title label and printing it
		String AlertTitle = androidDriver.findElement(By.id("android:id/alertTitle")).getText().trim();
		System.out.println("AlertTitle :: "+AlertTitle);
		Assert.assertTrue(AlertTitle.equals("WiFi settings"));
		//identifying the wifi settings textbox and sending text into it
		androidDriver.findElement(By.id("android:id/edit")).sendKeys("Rahul wifi");
		//identifying ok and clicking on it
		androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
	}
	
	@Test
	public void longPressGestureTest()
	{
		//identifying views on app home screen and clicking on it  
		androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//identifying views on API Demos screen and clicking on it  
		androidDriver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		
		//identifying Custom Adapter on next screen and clicking on it  
		androidDriver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//identifying People Names on next screen and clicking on it  
		WebElement PeopleNames =  androidDriver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		System.out.println("id is :: "+((RemoteWebElement) PeopleNames).getId());
		
//		((JavascriptExecutor)androidDriver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//				"elementId",((RemoteWebElement) PeopleNames).getId(),
//				"duration",2000
//				));	
		
		longClick(PeopleNames, 2000);
		
		String FirstOptionAfterLongPress = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
		Assert.assertTrue(FirstOptionAfterLongPress.equals("Sample menu"));
		Assert.assertTrue(androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
	}

	@Test
    public void scrollDemoTest()
	{
		//identifying views on app home screen and clicking on it  
		androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 50, "top", 50, "width", 100, "height", 100,
			    "direction", "down",
			    "percent", 1.5
			));
		
		
	}

	@Test
	public void swipeDemoTest()
	{
		//identifying views on app home screen and clicking on it  
		androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//identifying Gallery on next screen and clicking on it  
		androidDriver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		//identifying Photos on next screen and clicking on it  
		androidDriver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		//creating webelement for first photo
		WebElement FirstPhoto = androidDriver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		String isFirstPhotoFocusable = FirstPhoto.getAttribute("focusable");
		System.out.println("isFirstPhotoFocusable before swipe :: "+isFirstPhotoFocusable);
		//Assert.assertTrue((boolean)isFirstPhotoFocusable);
		
		//performing swipe
		((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) FirstPhoto).getId(),
			    "direction", "left",
			    "percent", 0.75
			));
		swipe(FirstPhoto, "left", 0.75);
		
		isFirstPhotoFocusable = FirstPhoto.getAttribute("focusable");
		System.out.println("isFirstPhotoFocusable after swipe :: "+isFirstPhotoFocusable);
		
	}

	@Test
	public void dragDropTest()
	{
		//identifying views on app home screen and clicking on it  
		androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//identifying drag and drop on next screen and clicking on it  
		androidDriver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		//creating webelement for source element
		WebElement SourceElement = androidDriver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		
		((JavascriptExecutor) androidDriver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) SourceElement).getId(),
			    "endX", 830,
			    "endY", 740
			));
		
		String Text = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Dropped!']")).getText().trim();
		Assert.assertTrue(Text.contains("Dropped!"));
		
	}
}
