package com.org.saib.travelapp.pageobjects.introscreens;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.org.saib.genericjavautilites.GenericJava;
import com.org.saib.genericjavautilites.JavaProperties;
import com.org.saib.genericjavautilites.PropertiesFileManager;

public class FirstIntroScreen extends GenericIntroScreen{
	
	WebDriver driver;
	//JavaProperties javaProperties;
	PropertiesFileManager firstIntroScreenPropertiesManager,metaPropertiesManager;
	
	@FindBy(xpath = "//android.widget.TextView[@text='The future of']")
	WebElement FeatureInFirstLine;
	
	@FindBy(xpath = "//android.widget.TextView[@text='travel card']")
	WebElement FeatureInSecondLine;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Skip']")
	public
	WebElement SkipButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	public
	WebElement NextButton;

	public FirstIntroScreen(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		metaPropertiesManager = getMetaPropertiesManager();
		firstIntroScreenPropertiesManager = new PropertiesFileManager(System.getProperty("user.dir")+metaPropertiesManager.getProperty("FirstIntroScreen"));  
		PageFactory.initElements(driver, this);
		System.out.println("initialized all webelements");
	}
	
	
	
	public boolean isFeatureInFirstLineCorrectInEnglish()
	{
		return FeatureInFirstLine.getText().equals(firstIntroScreenPropertiesManager.getProperty("Feature_In_Firstline_In_English"));
	}
	
	public boolean isFeatureInFirstLineCorrectInArabic()
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='المستقبل من']")).getText().equals(firstIntroScreenPropertiesManager.getProperty("Feature_In_Firstline_In_Arabic"));
	}
	
	public boolean isFeatureInSecondLineCorrectInEnglish()
	{
		return FeatureInSecondLine.getText().equals(firstIntroScreenPropertiesManager.getProperty("Feature_In_Secondline_In_English"));
	}
	
	public boolean isFeatureInSecondLineCorrectInArabic()
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='بطاقة سفر']")).getText().equals(firstIntroScreenPropertiesManager.getProperty("Feature_In_Secondline_In_Arabic"));
	}
	
	public boolean isSkipButtonTextCorrectInEnglish()
	{
		return SkipButton.getText().equals(genericIntroScreenPropertiesManager.getProperty("Skip_Button_Text_In_English"));
	}
	
	public boolean isSkipButtonTextCorrectInArabic()
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='تخطى']")).getText().equals(genericIntroScreenPropertiesManager.getProperty("Skip_Button_Text_In_Arabic"));
	}
	
	public boolean isNextButtonTextCorrectInEnglish()
	{
		return NextButton.getText().equals(genericIntroScreenPropertiesManager.getProperty("Next_Button_Text_In_English"));
	}
	
	public boolean isNextButtonTextCorrectInArabic()
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='تالي']")).getText().equals(genericIntroScreenPropertiesManager.getProperty("Next_Button_Text_In_Arabic"));
	}
}
