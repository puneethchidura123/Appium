package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class Assignment extends BaseTest{
	
	@Test
	public void endToEndTest()
	{
		// app -> alert dailogues -> text entry dailouge -> enter name, password and click "ok".
		//clicking on "app" in first screen
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
		//clicking on "Alert Dialogs" in second screen
		androidDriver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		//clicking on "TEXT ENTRY DIALOG" in third screen
		androidDriver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		//identifying name text box in Text Entry dialog
		WebElement Name = androidDriver.findElement(By.id("io.appium.android.apis:id/username_edit"));
		//entering Name
		Name.sendKeys("Test Name");
		//identifying password text box in Text Entry dialog
		WebElement Password = androidDriver.findElement(By.id("io.appium.android.apis:id/password_edit"));
		//entering password
		Password.sendKeys("Test Password");
		//clicking on "OK" in Text Entry dialog
		androidDriver.findElement(By.id("android:id/button1")).click();
	}
}
