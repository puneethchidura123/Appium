package com.org.saib.travelapp.pageobjects.introscreens;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.saib.genericjavautilites.GenericJava;

public class GenericUIUtilites extends GenericJava{


	WebDriver driver;
	
	public GenericUIUtilites(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public GenericUIUtilites()
	{
		
	}
	
	public void clickOnWebElement(WebElement webElement)
	{
		try
		{
			System.out.println("inside try block");
			webElement.click();
		}
		catch(NoSuchElementException noSuchElementException)
		{
			noSuchElementException.printStackTrace();
		}
		catch (StaleElementReferenceException staleElementReferenceException) {
			staleElementReferenceException.printStackTrace();
		}
		catch(java.lang.NullPointerException nullPointerException)
		{
			nullPointerException.printStackTrace();
		}
	}
	
	public void enterTextIntoTextBox(WebElement webElement,String text)
	{
		try
		{
			webElement.sendKeys(text);
			System.out.println("entered text is :: "+webElement.getText());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clearAndEnterTextIntoTextBox(WebElement webElement,String text)
	{
		try
		{
			clearTextFromTextBox(webElement);
			webElement.sendKeys(text);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clearTextFromTextBox(WebElement webElement)
	{
		try
		{	
			webElement.clear();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean doesAnyTextExistInTextBox(WebElement webElement)
	{
		String ExistingText = webElement.getAttribute("text");
		return ExistingText.isEmpty();
	}
	
	public String getExistingTextFromTextBox(WebElement webElement)
	{
		String ExistingText = webElement.getAttribute("text");
		return ExistingText;
	}
	
	
	// below are the waits related utilites
	
	public void explicityWaitForUntilElementToBeClickable(WebDriver driver,String Xpath)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
	}
	
	public void explicityWaitForUntilElementToBeClickable(String Xpath)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
	}
	
	public void explicityWaitForUntilElementToBeVisible(WebDriver driver,String Xpath)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
	}
	
	public void explicityWaitForUntilElementToBeVisible(String Xpath)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
	}
	
	public void hardWaitformilliSeconds(long waittime) throws InterruptedException
	{
		Thread.sleep(waittime);
	}
	
	
}
