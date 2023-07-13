package com.org.saib.travelapp.pageobjects.introscreens;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.org.saib.genericjavautilites.GenericJava;
import com.org.saib.genericjavautilites.PropertiesFileManager;

public class GenericIntroScreen extends GenericJava {

	WebDriver driver;
	PropertiesFileManager genericIntroScreenPropertiesManager,metaPropertiesManager;
	
	@FindBy(xpath = "//android.widget.TextView[@text='العربية']")
	WebElement AlArabia;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup")
	List<WebElement> ThreeDots;
	
	
	public GenericIntroScreen(WebDriver driver)
	{
		this.driver = driver;
		metaPropertiesManager = getMetaPropertiesManager();
		genericIntroScreenPropertiesManager = new PropertiesFileManager(System.getProperty("user.dir")+metaPropertiesManager.getProperty("GenericIntroScreen"));  
		PageFactory.initElements(driver, this);
	}
	
	public void switchToArabic()
	{
		AlArabia.click();
	}
	
	public void switchToEnglish()
	{
		WebElement SwitchToEnglish = driver.findElement(By.xpath("//android.widget.TextView[@text='English']"));
		SwitchToEnglish.click();
	}
	
	public boolean isSwitchToArabicCorrect()
	{
		return AlArabia.getText().equals(genericIntroScreenPropertiesManager.getProperty("AlArabia"));
	}
	
	public boolean isSwitchToEnglishCorrect()
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='English']")).getText().equals(genericIntroScreenPropertiesManager.getProperty("English"));
	}
	
	public int whichDotIsEnabled()
	{
		boolean isfirstdotenabled,isseconddotenabled,isthirddotenabled = false;
		int firstdotlength = getXCoordinatesDifference(ThreeDots.get(0).getAttribute("bounds"));
		int seconddotlength = getXCoordinatesDifference(ThreeDots.get(1).getAttribute("bounds"));
		int thirddotlength = getXCoordinatesDifference(ThreeDots.get(2).getAttribute("bounds"));
		int enableddot=0;
		if((firstdotlength>seconddotlength) && (firstdotlength>thirddotlength) && (seconddotlength == thirddotlength))
		{
			enableddot=1;
		}
		if((seconddotlength>firstdotlength) && (seconddotlength>thirddotlength) && (firstdotlength == thirddotlength))
		{
			enableddot=2;
		}
		if((thirddotlength>seconddotlength) && (thirddotlength>firstdotlength) && (firstdotlength == seconddotlength))
		{
			enableddot=3;
		}
		return enableddot;
	}
	
	
	
	public int getXCoordinatesDifference(String bounds)
	{
		int difference = 0;
		int x1 = Integer.parseInt(bounds.substring(1, bounds.indexOf(',')));
		int x2 = Integer.parseInt(bounds.substring(bounds.indexOf(']')+2, bounds.lastIndexOf(',')));
		difference = x2-x1;
		return difference;
	}
	
	public boolean isCurrentScreenInEnglish()
	{
		boolean iscurrentscreeninenglish = false;
		try
		{
			iscurrentscreeninenglish = driver.findElement(By.xpath("//android.widget.TextView[@text='العربية']")).isDisplayed();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
		}
		return iscurrentscreeninenglish;	
	}
	
}
