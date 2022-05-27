package seletest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		//Pass the wrong credentials in input fields and print the error message on the console
		
		String name = "tariq";
		String email = "tarique@gmail.com";
		String email2 = "snowyman@gmail.com";
		String pass = "rahulshettyacademy";
		String msg = "You are successfully logged in.";
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//this methods waits for the specified time before throwing error
		String password = getPassword(driver);
		//getting password from getPassword method and storing it in password variable
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("tarique");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		//Getting error message and printing it to console
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		//using the linkText method (must have <a> tag)
		
		driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys(email);
		//using declared variables instead of hard coding the values
		
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//using type=text with index , value must be in single quote
		
		Thread.sleep(2000);
		//waiting 2 seconds before performing next action 
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(email2);
		//Using the CSS selector - NOTE - value must be in single quote
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("123456781");
		//using the parent child technique with index
		
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		// using css selector with class tagname.classname
		
		
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//using the cssSelector with parent to child traverse technique
		
		driver.findElement(By.xpath("//div/button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[contains(@id,'input')]")).sendKeys(name);
		//using the regular expression for xpath
		
		driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys(password);
		//Using regular expression for CSS selector
		
		driver.findElement(By.id("chkboxOne")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.xpath("//p[contains(@style,'color')]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(@style,'color')]")).getText(), msg);
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello "+name+",");
		//using the TestNg's assertion method to valid the expected results
		
		System.out.println(driver.findElement(By.xpath("//h2")).getText());
		Thread.sleep(3000);
		driver.findElement(By.xpath(" //button[text()=\"Log Out\"] ")).click();
		//using the text based xpath for button
		Thread.sleep(5000);
		System.out.println("Test Completed Successfully");
		driver.quit();
				

	}
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordtext = driver.findElement(By.cssSelector("form p")).getText();
		String[] passarray = passwordtext.split("'");
		String password = passarray[1].split("'")[0];
		return password;
		
		//creating new method to extract the password from info message dynamically using split method
		//and returning the password
		
	}

}
