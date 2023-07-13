package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellenaousAppiumActions extends BaseTest{

	
	@Test
	public void deviceRotationTest()
	{
		// identifying preference on app home screen and clicking on it   
		androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//identifying 'Preference dependencies' on next screen and clicking on it 
		androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		//identifying wifi checkbox on next screen and enabling it
		androidDriver.findElement(By.id("android:id/checkbox")).click();
		
		
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		androidDriver.rotate(landscape);
		
		
		//identifying WiFi Settings on the same screen and clicking on it
		androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//identifying the alert title label and printing it
		String AlertTitle = androidDriver.findElement(By.id("android:id/alertTitle")).getText().trim();
		System.out.println("AlertTitle :: "+AlertTitle);
		Assert.assertTrue(AlertTitle.equals("WiFi settings"));
		//identifying the wifi settings checkbox and sending text into it
		androidDriver.findElement(By.id("android:id/edit")).sendKeys("Rahul wifi");
		//identifying ok and clicking on it
		androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
	
	
	@Test
	public void clipBoardTest()
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
		
		
		//setting clipboard text
		androidDriver.setClipboardText("Rahul wifi");
		
		
		
		//identifying the wifi settings check text box and sending text into it by taking text rom clip board
		androidDriver.findElement(By.id("android:id/edit")).sendKeys(androidDriver.getClipboardText());
		//identifying ok and clicking on it
		androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
	
	
	@Test
	public void keyboardEvents() throws InterruptedException
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
		//identifying the wifi settings  text box and sending text into 
		androidDriver.findElement(By.id("android:id/edit")).sendKeys("rahul wifi");
		
		
		//hitting enter key from the mobile keyboard
		androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
		androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(7000);
		//identifying ok and clicking on it
		androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		
		//pressing android home key on device
		androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

    
	@Test
	public void demoOnAppPackage()
	{
		//   command :: adb shell dumpsys window | grep -E 'mCurrentFocus' - for mac
		//   command :: adb shell dumpsys window | find 'mCurrentFocus' - for windows
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		androidDriver.startActivity(activity);
		//identifying wifi checkbox on next screen and enabling it
		androidDriver.findElement(By.id("android:id/checkbox")).click();
		//identifying WiFi Settings on the same screen and clicking on it
		androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//identifying the alert title label and printing it
		String AlertTitle = androidDriver.findElement(By.id("android:id/alertTitle")).getText().trim();
		System.out.println("AlertTitle :: "+AlertTitle);
		Assert.assertTrue(AlertTitle.equals("WiFi settings"));
		//identifying the wifi settings  text box and sending text into 
		androidDriver.findElement(By.id("android:id/edit")).sendKeys("rahul wifi");
		//identifying ok and clicking on it
		androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
}
