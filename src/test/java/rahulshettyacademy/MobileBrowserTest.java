package rahulshettyacademy;

import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {

	
	@Test
	public void browserTest()
	{
		androidDriver.get("https://google.com");
		System.out.println(androidDriver.getTitle());
	}
}
