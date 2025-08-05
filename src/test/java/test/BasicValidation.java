package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicValidation {
	
	public static WebDriver driver;
	public String url = "https://www.facebook.com";
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		
		
		
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
	
	@Test
	public void welcomeValidateMessage() {
		String expectedResult = "Facebook helps you connect and share with the people in your life.";
		String actualResult = driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();
		
		Reporter.log("Expected Result = "+expectedResult);
		Reporter.log("actualResult = "+actualResult);
		
		Assert.assertTrue(actualResult.equals(expectedResult), "Mismatch in the welcome message");
	}
}
