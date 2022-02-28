package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tutorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Programming\\selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Google and select the search box using the name element and retrieve the tag name
		driver.get("https://www.google.com/");
		String tagName = driver.findElement(By.name("q")).getTagName();
		
		//When tagName is retrieved print it out in console
		System.out.println("Tag Name : "+ tagName);
		
		//search for cheese and press enter on search bar
		driver.findElement(By.name("q")).sendKeys("Cheese" + Keys.ENTER);
		

	}

}
