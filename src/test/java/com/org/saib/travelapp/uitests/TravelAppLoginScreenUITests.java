package com.org.saib.travelapp.uitests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.saib.travelapp.pageobjects.introscreens.FirstIntroScreen;
import com.org.saib.travelapp.pageobjects.introscreens.GenericUIUtilites;
import com.org.saib.travelapp.pageobjects.introscreens.LoginScreen;

public class TravelAppLoginScreenUITests extends BaseTest{

	
	static LoginScreen loginScreen;
	static FirstIntroScreen firstIntroScreen;
	static GenericUIUtilites genericUIUtilites;
	private static Logger logger;
	
	
	@Test
	public void loginTest() throws InterruptedException
	{
		loginScreen = new LoginScreen(androidDriver);
		firstIntroScreen = new FirstIntroScreen(androidDriver);
		genericUIUtilites = new GenericUIUtilites(androidDriver);
		logger = LogManager.getLogger("TravelAppLoginScreenUITests.class");
		genericUIUtilites.hardWaitformilliSeconds(5000);
		genericUIUtilites.clickOnWebElement(firstIntroScreen.SkipButton);
		genericUIUtilites.explicityWaitForUntilElementToBeVisible("//android.widget.TextView[@text='Skip']");
		loginScreen.logiInToTravelApp("ZD173064", "Saib1234");
		genericUIUtilites.hardWaitformilliSeconds(35000);
	}
	
	
//	@DataProvider
//	public Object loginTestDataProvider()
//	{
//		
//	}
	
}
