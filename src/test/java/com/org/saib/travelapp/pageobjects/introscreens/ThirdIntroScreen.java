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

public class ThirdIntroScreen extends GenericIntroScreen{
	
	WebDriver driver;
	PropertiesFileManager thirdIntroScreenPropertiesManager,metaPropertiesManager;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Additional cards']")
	WebElement FeatureInFirstLine;
	
	@FindBy(xpath = "//android.widget.TextView[@text='for family']")
	WebElement FeatureInSecondLine;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Login']")
	public
	WebElement LoginButton;

	public ThirdIntroScreen(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		metaPropertiesManager = getMetaPropertiesManager();
		thirdIntroScreenPropertiesManager = new PropertiesFileManager(System.getProperty("user.dir")+metaPropertiesManager.getProperty("ThirdIntroScreen"));  
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean isFeatureInFirstLineCorrectInEnglish()
	{
		return FeatureInFirstLine.getText().equals(thirdIntroScreenPropertiesManager.getProperty("Feature_In_Firstline_In_English"));
	}
	
	public boolean isFeatureInFirstLineCorrectInArabic()
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='بطاقات إضافية']")).getText().equals(thirdIntroScreenPropertiesManager.getProperty("Feature_In_Firstline_In_Arabic"));
	}
	
	public boolean isFeatureInSecondLineCorrectInEnglish()
	{
		return FeatureInSecondLine.getText().equals(thirdIntroScreenPropertiesManager.getProperty("Feature_In_Secondline_In_English"));
	}
	
	public boolean isFeatureInSecondLineCorrectInArabic()
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='للعائلة']")).getText().equals(thirdIntroScreenPropertiesManager.getProperty("Feature_In_Secondline_In_Arabic"));
	}
	
	public boolean isLoginButtonTextCorrectInEnglish()
	{
		return LoginButton.getText().equals(genericIntroScreenPropertiesManager.getProperty("Login_Button_Text_In_English"));
	}
	
	public boolean isLoginButtonTextCorrectInArabic()
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='تسجيل الدخول']")).getText().equals(genericIntroScreenPropertiesManager.getProperty("Login_Button_Text_In_Arabic"));
	}
	
	
}
