package seletest;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	public static void main(String[] args) {
		
		//System.setProperties("path to webdriver.exe"); in case of manual approach
	
		WebDriverManager.chromedriver().setup();
		//using the webdriver manager for better dependencies management
		
		//WebDriverManageer.firefoxdriver().setup();
		//In case of firefox 
		 
		//WebDriverManageer.edgedriver().setup();
		//In case of firefox
		
		
		ChromeDriver driver= new ChromeDriver();
		//Declaring broweser object
		
		driver.get("https://www.google.com");
		//calling the object to perform actions
		System.out.println(driver.getTitle());
		//printing the site title using java's println method
		driver.close();

	}

}
