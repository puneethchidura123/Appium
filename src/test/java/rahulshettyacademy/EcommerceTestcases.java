package rahulshettyacademy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceTestcases extends BaseTest {
	
	@Test
	public void fillFormTest()
	{
		WebElement CountryDropDownElement = 
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		
		CountryDropDownElement.click();
		
		//scrollToText("India");  // find out why this is not working
		androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
		WebElement RequiredOption = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
		RequiredOption.click();
		
		WebElement Your_NameTextBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		Your_NameTextBox.sendKeys("Puneeth Chidura");
		
		androidDriver.hideKeyboard();
		
		WebElement MaleCheckBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
		MaleCheckBox.click();
		
		WebElement Lets_ShopButton = androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		Lets_ShopButton.click();
	}
	
	
	@Test
	public void toastMessageTest()
	{
		WebElement CountryDropDownElement = 
				androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
				
				CountryDropDownElement.click();
				
				//scrollToText("India");  // find out why this is not working
				androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
				WebElement RequiredOption = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
				RequiredOption.click();
				WebElement MaleCheckBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
				MaleCheckBox.click();
				WebElement Lets_ShopButton = androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
				Lets_ShopButton.click();
				
				
				//getting toast message
				String ToastMessage = androidDriver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
				System.out.println("ToastMessage :: "+ToastMessage);
				Assert.assertEquals(ToastMessage, "Please enter your name");
	}
	
	
	@Test
	public void verifyAdditionToCart()
	{
		WebElement CountryDropDownElement = 
				androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));

		CountryDropDownElement.click();

		//scrollToText("India");  // find out why this is not working
		androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
		WebElement RequiredOption = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
		RequiredOption.click();

		System.out.println("country selected");
		WebElement Your_NameTextBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		Your_NameTextBox.sendKeys("Puneeth Chidura");
		System.out.println("name entered");
		
		androidDriver.hideKeyboard();

		WebElement MaleCheckBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
		MaleCheckBox.click();
		System.out.println("male option selected");
		
		WebElement Lets_ShopButton = androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		Lets_ShopButton.click();
		
		
		String ProductToBeAdded = "Converse All Star";
		//scrolling till the required product
		androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
		//identifying the required add to cart button
		List<WebElement> ProductNames = 
		androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']"));
		int requiredIndex = 0;
		for(int i=0;i<ProductNames.size();i++)
		{
			if(ProductNames.get(i).getAttribute("text").equals(ProductToBeAdded))
			{
				requiredIndex=i+1;
				break;
			}
		}
		
		// clicking on the required add to cart
		androidDriver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])["+requiredIndex+"]")).click();
		
		// identifying the cart button and clicking on it
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//System.out.println(androidDriver.getTitle());
		
		WebDriverWait webDriverWait = new WebDriverWait(androidDriver,Duration.ofSeconds(6));
		webDriverWait.until(ExpectedConditions.titleIs("Cart"));
		
		//checking if the added product is available in cart
		List<WebElement> ProductNamesInCart = 
		androidDriver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.androidsample.generalstore:id/rvCartProductList']/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
		System.out.println(ProductNamesInCart.size());
		boolean isRequiredProductFoundInCart = false;
		
		for(int i =0;i<ProductNamesInCart.size();i++)
		{
			String ProductName = ProductNamesInCart.get(i).getAttribute("text").trim();
			System.out.println("ProductName :: "+ProductName);
			if(ProductName.equals(ProductToBeAdded))
			{
				System.out.println(" required product name matched");
				isRequiredProductFoundInCart = true;
			}
		}
		Assert.assertTrue(isRequiredProductFoundInCart);
	}
	
	@Test
	public void totalAmountValidationInCartPage()
	{
		WebElement CountryDropDownElement = 
				androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));

		CountryDropDownElement.click();

		//scrollToText("India");  // find out why this is not working
		androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
		WebElement RequiredOption = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
		RequiredOption.click();

		System.out.println("country selected");
		WebElement Your_NameTextBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		Your_NameTextBox.sendKeys("Puneeth Chidura");
		System.out.println("name entered");
		
		androidDriver.hideKeyboard();

		WebElement MaleCheckBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
		MaleCheckBox.click();
		System.out.println("male option selected");
		
		WebElement Lets_ShopButton = androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		Lets_ShopButton.click();
		
		List<String> ProductsList = new ArrayList<String>();
		ProductsList.add("Converse All Star");
		ProductsList.add("Air Jordan 4 Retro");
		
		double calculatedTotalAmount = 0;
		Iterator itr = ProductsList.iterator();
		while(itr.hasNext())
		{
			String ProductToBeAdded = (String) itr.next();
			//scrolling till the required product
			androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ProductToBeAdded+"\"))"));
			//identifying the required add to cart button
			List<WebElement> ProductNames = 
			androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']"));
			int requiredIndex = 0;
			for(int i=0;i<ProductNames.size();i++)
			{
				if(ProductNames.get(i).getAttribute("text").equals(ProductToBeAdded))
				{
					requiredIndex=i+1;
					break;
				}
			}
			//extracting current product price and adding it to calculatedTotalAmount
			double currentProductPrice =   Double.parseDouble( 
					androidDriver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice'])["+requiredIndex+"]")).getAttribute("text").substring(1));
			System.out.println("current product is :: "+ProductToBeAdded+" and its price is :: "+currentProductPrice);
			calculatedTotalAmount = calculatedTotalAmount+currentProductPrice;
			//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']
			// clicking on the required add to cart
			androidDriver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])["+requiredIndex+"]")).click();	
		}
		System.out.println("calculatedTotalAmount :: "+calculatedTotalAmount);
		// identifying the cart button and clicking on it
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//identifying total amount and extracting it
		double TotalAmount = Double.parseDouble(androidDriver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getAttribute("text").substring(2));
		Assert.assertEquals(TotalAmount,calculatedTotalAmount);
	}
	
	@Test
	public void orderPlacementTest()
	{
		WebElement CountryDropDownElement = 
				androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));

		CountryDropDownElement.click();

		//scrollToText("India");  // find out why this is not working
		androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
		WebElement RequiredOption = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
		RequiredOption.click();

		System.out.println("country selected");
		WebElement Your_NameTextBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		Your_NameTextBox.sendKeys("Puneeth Chidura");
		System.out.println("name entered");
		
		androidDriver.hideKeyboard();

		WebElement MaleCheckBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
		MaleCheckBox.click();
		System.out.println("male option selected");
		
		WebElement Lets_ShopButton = androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		Lets_ShopButton.click();
		
		
		String ProductToBeAdded = "Converse All Star";
		//scrolling till the required product
		androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
		//identifying the required add to cart button
		List<WebElement> ProductNames = 
		androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']"));
		int requiredIndex = 0;
		for(int i=0;i<ProductNames.size();i++)
		{
			if(ProductNames.get(i).getAttribute("text").equals(ProductToBeAdded))
			{
				requiredIndex=i+1;
				break;
			}
		}
		
		// clicking on the required add to cart
		androidDriver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])["+requiredIndex+"]")).click();
		
		// identifying the cart button and clicking on it
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//System.out.println(androidDriver.getTitle());
		
		WebDriverWait webDriverWait = new WebDriverWait(androidDriver,Duration.ofSeconds(6));
		webDriverWait.until(ExpectedConditions.titleIs("Cart"));
		
		//checking if the added product is available in cart
		List<WebElement> ProductNamesInCart = 
		androidDriver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.androidsample.generalstore:id/rvCartProductList']/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
		System.out.println(ProductNamesInCart.size());
		boolean isRequiredProductFoundInCart = false;
		
		for(int i =0;i<ProductNamesInCart.size();i++)
		{
			String ProductName = ProductNamesInCart.get(i).getAttribute("text").trim();
			System.out.println("ProductName :: "+ProductName);
			if(ProductName.equals(ProductToBeAdded))
			{
				System.out.println(" required product name matched");
				isRequiredProductFoundInCart = true;
			}
		}
		Assert.assertTrue(isRequiredProductFoundInCart);
		
		//long pressing on the terms and conditions link
		WebElement TermsAndConditions = androidDriver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longClick(TermsAndConditions, 5);
		//closing the "terms of conditions" popup
		androidDriver.findElement(By.id("android:id/button1")).click();
		//clicking on "Visit to the website to complete purchase"
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	}
	
	
	@Test
	public void contextSwitchingTest() throws Exception
	{
		WebElement CountryDropDownElement = 
				androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));

		CountryDropDownElement.click();

		//scrollToText("India");  // find out why this is not working
		androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
		WebElement RequiredOption = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
		RequiredOption.click();

		System.out.println("country selected");
		WebElement Your_NameTextBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		Your_NameTextBox.sendKeys("Puneeth Chidura");
		System.out.println("name entered");
		
		androidDriver.hideKeyboard();

		WebElement MaleCheckBox = androidDriver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
		MaleCheckBox.click();
		System.out.println("male option selected");
		
		WebElement Lets_ShopButton = androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		Lets_ShopButton.click();
		
		
		String ProductToBeAdded = "Converse All Star";
		//scrolling till the required product
		androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
		//identifying the required add to cart button
		List<WebElement> ProductNames = 
		androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']"));
		int requiredIndex = 0;
		for(int i=0;i<ProductNames.size();i++)
		{
			if(ProductNames.get(i).getAttribute("text").equals(ProductToBeAdded))
			{
				requiredIndex=i+1;
				break;
			}
		}
		
		// clicking on the required add to cart
		androidDriver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])["+requiredIndex+"]")).click();
		
		// identifying the cart button and clicking on it
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//System.out.println(androidDriver.getTitle());
		
		WebDriverWait webDriverWait = new WebDriverWait(androidDriver,Duration.ofSeconds(6));
		//webDriverWait.until(ExpectedConditions.titleIs("Cart"));
		
		//checking if the added product is available in cart
		List<WebElement> ProductNamesInCart = 
		androidDriver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.androidsample.generalstore:id/rvCartProductList']/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
		System.out.println(ProductNamesInCart.size());
		boolean isRequiredProductFoundInCart = false;
		
		for(int i =0;i<ProductNamesInCart.size();i++)
		{
			String ProductName = ProductNamesInCart.get(i).getAttribute("text").trim();
			System.out.println("ProductName :: "+ProductName);
			if(ProductName.equals(ProductToBeAdded))
			{
				System.out.println(" required product name matched");
				isRequiredProductFoundInCart = true;
			}
		}
		Assert.assertTrue(isRequiredProductFoundInCart);
		Thread.sleep(7000);
		//long pressing on the terms and conditions link
//		WebElement TermsAndConditions = androidDriver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//		longClick(TermsAndConditions, 10);
//		Thread.sleep(7000);
//		//closing the "terms of conditions" popup
//		androidDriver.findElement(By.id("android:id/button1")).click();
		//clicking on "Visit to the website to complete purchase"
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(8000);
		//getting contextHandles
		Set<String> Handles = androidDriver.getContextHandles();
		String CurrentContext = androidDriver.getContext();
		System.out.println("CurrentContext :: "+CurrentContext);
		for(String CurrentHandle : Handles)
		{
			System.out.println("CurrentHandle :: "+CurrentHandle);
		}
		androidDriver.context("WEBVIEW_com.androidsample.generalstore");
		
		//identifying the google search bar and entering some search text
		WebElement GoogleSearchTextBox = androidDriver.findElement(By.name("q"));
		//GoogleSearchTextBox.sendKeys("i just entered webview from mobile");
		//GoogleSearchTextBox.sendKeys(Keys.ENTER);
		
		//clicking on the english hyperlink
		androidDriver.findElement(By.linkText("English")).click();
		Thread.sleep(7000);
		System.out.println("clicked on english hyperlink");
	}
	
	
	@Test
	public void travelAppTest()
	{
		
	}
	
	
}
