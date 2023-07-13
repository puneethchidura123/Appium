package com.org.saib.travelapp.pageobjects.introscreens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.saib.genericjavautilites.GenericJava;
import com.org.saib.genericjavautilites.PropertiesFileManager;

public class LoginScreen extends GenericUIUtilites{
	
	WebDriver driver;
	PropertiesFileManager loginScreenPropertiesManager,metaPropertiesManager;
	
	@FindBy(xpath = "//android.widget.TextView[@text='العربية']")
	WebElement AlArabia;                       
	
	@FindBy(xpath = "//android.widget.TextView[@text='Login' and @index='2']")
	WebElement LoginLabel;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Username']")
	WebElement UsernameLabel;
	
	@FindBy(xpath = "//android.widget.EditText[@bounds='[181,919][1259,1017]']")
	WebElement UsernameTextbox;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Password']")
	WebElement PasswordLabel;
	
	@FindBy(xpath = "//android.widget.EditText[@bounds='[181,1269][1175,1367]']")
	WebElement PasswordTextbox;
	
	@FindBy(xpath = "//com.horcrux.svg.PathView[@bounds='[1204,1297][1232,1325]']")
	public
	WebElement PasswordEye;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Forgot Password?']")
	WebElement ForgotPasswordLink;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Login' and @index='0']")
	WebElement LoginButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='New to SAIB? ']")
	WebElement New_to_SAIBLabel;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Open Account']")
	WebElement Open_AccountLink;
	
	public LoginScreen(WebDriver driver)
	{
		this.driver = driver;
		metaPropertiesManager = getMetaPropertiesManager();
		loginScreenPropertiesManager = new PropertiesFileManager(System.getProperty("user.dir")+metaPropertiesManager.getProperty("LoginScreen"));
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLoginLabelTextInEnglishCorrect()
	{
		return LoginLabel.getText().equals(loginScreenPropertiesManager.getProperty("LoginLabelTextInEnglish"));
	}
	
	public boolean isUsernameLabelTextInEnglishCorrect()
	{
		return UsernameLabel.getText().equals(loginScreenPropertiesManager.getProperty("UsernameLabelTextInEnglish"));
	}
	
	public boolean isUsernameTextboxEmpty()
	{
		return UsernameTextbox.getAttribute("text").equals(loginScreenPropertiesManager.getProperty("InitialTextInUsernameTextbox"));
	}
	
	public boolean isPasswordLabelTextInEnglishCorrect()
	{
		return PasswordLabel.getText().equals(loginScreenPropertiesManager.getProperty("PasswordLabelTextInEnglish"));
	}
	
	public boolean isPasswordTextboxEmpty()
	{
		return PasswordTextbox.getAttribute("text").equals(loginScreenPropertiesManager.getProperty("InitialTextInPasswordTextbox"));
	}
	
	public boolean isForgotPasswordLinkTextInEnglishCorrect()
	{
		return ForgotPasswordLink.getText().equals(loginScreenPropertiesManager.getProperty("ForgotPasswordLinkTextInEnglish"));
	}
	
	public boolean isLoginButtonTextInEnglishCorrect()
	{
		return LoginButton.getText().equals(loginScreenPropertiesManager.getProperty("LoginButtonTextInEnglish"));
	}
	
	public boolean isNewtoSAIBLabelTextInEnglishCorrect()
	{
		return New_to_SAIBLabel.getText().equals(loginScreenPropertiesManager.getProperty("NewToSAIBLabelTextInEnglish"));
	}
	
	public boolean isOpenAccountLinkTextInEnglishCorrect()
	{
		return Open_AccountLink.getText().equals(loginScreenPropertiesManager.getProperty("OpenAccountLinkTextInEnglish"));
	}
	
	public void logiInToTravelApp(String Username,String Password)
	{
		enterTextIntoTextBox(UsernameTextbox, Username);
		enterTextIntoTextBox(PasswordTextbox, Password);
		clickOnWebElement(LoginButton);
	}
}
