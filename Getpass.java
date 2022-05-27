package seletest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Getpass {

	public static void main(String[] args) throws InterruptedException {
	String name = "tariq";
	String msg = "You are successfully logged in.";
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String password = getPassword(driver);
	driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
	driver.findElement(By.id("inputUsername")).sendKeys(name);
	driver.findElement(By.name("inputPassword")).sendKeys(password);
	driver.findElement(By.className("signInBtn")).click();
	Thread.sleep(2000);
	System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	Assert.assertEquals(driver.findElement(By.xpath("//p[contains(@style,'color')]")).getText(), msg);
	Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello "+name+",");
	driver.findElement(By.xpath(" //button[text()=\"Log Out\"] ")).click();

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
		
		
		
	}
}
