package com.org.saib.travelapp.uitests;

import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.org.saib.travelapp.pageobjects.introscreens.FirstIntroScreen;
import com.org.saib.travelapp.pageobjects.introscreens.GenericUIUtilites;
import com.org.saib.travelapp.pageobjects.introscreens.LoginScreen;
import com.org.saib.travelapp.pageobjects.introscreens.SecondIntroScreen;
import com.org.saib.travelapp.pageobjects.introscreens.ThirdIntroScreen;

import com.org.saib.travelapp.uitests.BaseTest;

public class TravelAppSplashScreenUITests extends BaseTest{

	FirstIntroScreen firstIntroScreen;
	SecondIntroScreen secondIntroScreen;
	ThirdIntroScreen thirdIntroScreen;
	LoginScreen loginScreen;
	SoftAssert softAssert = new SoftAssert();
	GenericUIUtilites genericUIUtilites = new GenericUIUtilites();
	
	private static Logger logger = LogManager.getLogger("BaseTest.class");
	
	
	
	@Test(priority = 1)
	public void firstIntroScreenUiElementsPopulationCheck() throws InterruptedException
	{
		String classpath = System.getProperty("java.class.path");
        System.out.println("Classpath: " + classpath);
		logger.info("this is a info ");
		logger.error("this is a error");
		logger.fatal("this is a fatal");
		logger.warn("this is a warning");
		Thread.sleep(10000);
		firstIntroScreen = new FirstIntroScreen(androidDriver);
		firstIntroScreenCheck();
		firstIntroScreen.switchToArabic();
		Thread.sleep(2000);
		firstIntroScreenCheck();
		firstIntroScreen.switchToEnglish();
		Thread.sleep(2000);
		softAssert.assertEquals(firstIntroScreen.whichDotIsEnabled(),1,"currently dot no : 1 is not enabled");
		softAssert.assertAll();
		firstIntroScreen.NextButton.click();	
	}
	
	public void firstIntroScreenCheck()
	{
		if(firstIntroScreen.isCurrentScreenInEnglish())
		{
			softAssert.assertTrue(firstIntroScreen.isSwitchToArabicCorrect(),"SwitchTo Arabic is not Correct");
			softAssert.assertTrue(firstIntroScreen.isFeatureInFirstLineCorrectInEnglish(),"Feature In First Line is not correct in english");
			softAssert.assertTrue(firstIntroScreen.isFeatureInSecondLineCorrectInEnglish(),"Feature In Second Line is not Correct in english");
			softAssert.assertTrue(firstIntroScreen.isSkipButtonTextCorrectInEnglish(),"Skip Button Text is not Correct in english");
			softAssert.assertTrue(firstIntroScreen.isNextButtonTextCorrectInEnglish(),"Next Button Text is not Correct in english");
		}
		else
		{
			softAssert.assertTrue(firstIntroScreen.isSwitchToEnglishCorrect(),"SwitchTo Arabic is not Correct");
			softAssert.assertTrue(firstIntroScreen.isFeatureInFirstLineCorrectInArabic(),"Feature In First Line is not correct in arabic");
			softAssert.assertTrue(firstIntroScreen.isFeatureInSecondLineCorrectInArabic(),"Feature In Second Line is not Correct in arabic");
			softAssert.assertTrue(firstIntroScreen.isSkipButtonTextCorrectInArabic(),"Skip Button Text is not Correct in arabic");
			softAssert.assertTrue(firstIntroScreen.isNextButtonTextCorrectInArabic(),"Next Button Text is not Correct in arabic");
		}
	}
	
	@Test(priority = 2)
	public void secondIntroScreenUiElementsPopulationCheck() throws InterruptedException
	{
		secondIntroScreen = new SecondIntroScreen(androidDriver);
		secondIntroScreenCheck();
		secondIntroScreen.switchToArabic();
		Thread.sleep(2000);
		secondIntroScreenCheck();
		secondIntroScreen.switchToEnglish();
		Thread.sleep(2000);
		softAssert.assertEquals(secondIntroScreen.whichDotIsEnabled(),2,"currently dot no : 2 is not enabled");
		softAssert.assertAll();
		secondIntroScreen.NextButton.click();
	}
	
	public void secondIntroScreenCheck()
	{
		if(secondIntroScreen.isCurrentScreenInEnglish())
		{
			softAssert.assertTrue(secondIntroScreen.isSwitchToArabicCorrect(),"SwitchTo Arabic is not Correct");
			softAssert.assertTrue(secondIntroScreen.isFeatureInFirstLineCorrectInEnglish(),"Feature In Second Line is not correct in english");
			softAssert.assertTrue(secondIntroScreen.isFeatureInSecondLineCorrectInEnglish(),"Feature In Second Line is not Correct in english");
			softAssert.assertTrue(secondIntroScreen.isSkipButtonTextCorrectInEnglish(),"Skip Button Text is not Correct in english");
			softAssert.assertTrue(secondIntroScreen.isNextButtonTextCorrectInEnglish(),"Next Button Text is not Correct in english");
		}
		else
		{
			softAssert.assertTrue(secondIntroScreen.isSwitchToEnglishCorrect(),"SwitchTo Arabic is not Correct");
			softAssert.assertTrue(secondIntroScreen.isFeatureInFirstLineCorrectInArabic(),"Feature In Second Line is not correct in arabic");
			softAssert.assertTrue(secondIntroScreen.isFeatureInSecondLineCorrectInArabic(),"Feature In Second Line is not Correct in arabic");
			softAssert.assertTrue(secondIntroScreen.isSkipButtonTextCorrectInArabic(),"Skip Button Text is not Correct in arabic");
			softAssert.assertTrue(secondIntroScreen.isNextButtonTextCorrectInArabic(),"Next Button Text is not Correct in arabic");
		}
	}
	
	@Test(priority = 3,enabled = true)
	public void thirdIntroScreenUiElementsPopulationCheck() throws InterruptedException
	{
		thirdIntroScreen = new ThirdIntroScreen(androidDriver);
		thirdIntroScreenCheck();
		Thread.sleep(2000);
		thirdIntroScreen.switchToArabic();
		Thread.sleep(2000);
		thirdIntroScreenCheck();
		thirdIntroScreen.switchToEnglish();
		softAssert.assertEquals(thirdIntroScreen.whichDotIsEnabled(),3,"currently dot no : 3 is not enabled");
		softAssert.assertAll();
		thirdIntroScreen.LoginButton.click();
		Thread.sleep(10000);
	}
	
	public void thirdIntroScreenCheck()
	{
		if(thirdIntroScreen.isCurrentScreenInEnglish())
		{
			softAssert.assertTrue(thirdIntroScreen.isSwitchToArabicCorrect(),"SwitchTo Arabic is not Correct");
			softAssert.assertTrue(thirdIntroScreen.isFeatureInFirstLineCorrectInEnglish(),"Feature In First Line is not Correct In English");
			softAssert.assertTrue(thirdIntroScreen.isFeatureInSecondLineCorrectInEnglish(),"Feature In Second Line is not Correct In English");
			softAssert.assertTrue(thirdIntroScreen.isLoginButtonTextCorrectInEnglish(),"Login Button Text is not Correct In English");
		}
		else
		{
			softAssert.assertTrue(thirdIntroScreen.isSwitchToEnglishCorrect(),"SwitchTo Arabic is not Correct");
			softAssert.assertTrue(thirdIntroScreen.isFeatureInFirstLineCorrectInArabic(),"Feature In First Line is not Correct In Arabic");
			softAssert.assertTrue(thirdIntroScreen.isFeatureInSecondLineCorrectInArabic(),"Feature In Second Line is not Correct In Arabic");
			softAssert.assertTrue(thirdIntroScreen.isLoginButtonTextCorrectInArabic(),"Login Button Text is not Correct In Arabic");
		}
	}
	
	@Test(priority = 4)
	public void loginScreenUiElementsPopulationCheck()
	{
		loginScreen = new LoginScreen(androidDriver);
		softAssert.assertTrue(loginScreen.isLoginLabelTextInEnglishCorrect(),"Login Label Text In English Is Not Correct");
		softAssert.assertTrue(loginScreen.isUsernameLabelTextInEnglishCorrect(),"Username Label Text In English Is Not Correct");
		softAssert.assertTrue(loginScreen.isUsernameTextboxEmpty(),"Username Textbox Is Not Empty");
		softAssert.assertTrue(loginScreen.isPasswordLabelTextInEnglishCorrect(),"Password Label Text In English Is Not Correct");
		softAssert.assertTrue(loginScreen.PasswordEye.isDisplayed(),"Password Eye is not displayed properly");
		softAssert.assertTrue(loginScreen.isForgotPasswordLinkTextInEnglishCorrect(),"ForgotPassword LinkText In English Is Not Correct");
		softAssert.assertTrue(loginScreen.isLoginButtonTextInEnglishCorrect(),"isLoginButtonTextInEnglishCorrect");
		softAssert.assertTrue(loginScreen.isNewtoSAIBLabelTextInEnglishCorrect(),"NewtoSAIB Label Text In English Is Not Correct");
		softAssert.assertTrue(loginScreen.isOpenAccountLinkTextInEnglishCorrect(),"OpenAccount Link Text In EnglishIs Not Correct");
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority = 5)
	public void skipButtonFunctionalityCheckOnIntroScreens() throws InterruptedException
	{
		//System.out.println("resetting the app");
		resetApp();
		Thread.sleep(10000);
		genericUIUtilites.clickOnWebElement(firstIntroScreen.SkipButton);
		Thread.sleep(2000);
		loginScreenUiElementsPopulationCheck();
		resetApp();
		Thread.sleep(10000);
		genericUIUtilites.clickOnWebElement(firstIntroScreen.NextButton);
		Thread.sleep(2000);
		genericUIUtilites.clickOnWebElement(secondIntroScreen.SkipButton);
		Thread.sleep(2000);
		loginScreenUiElementsPopulationCheck();
		//System.out.println("app reset completed successfully");
		Thread.sleep(20000);
	}
}
