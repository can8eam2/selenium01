package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Day1 {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
	
	public void invokeBrowser() {
		try {
			//call on chrome webdriver exe file, delete all cookies, maximize window and surrounding with try/catch block
			System.setProperty("webdriver.chrome.driver", "C:\\Programming\\selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			
			//bait synchronization - synching code and browser speeds. webdriver will keep pulling DOMs until it finds element for max 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			//open amazon and call on OreoSearch
			driver.get("https://www.amazon.com/");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oreos");
			//threading, sleeping for to handle exceptions (this puts buffer time in so you can see actions taking place
			Thread.sleep(1500);
			driver.findElement(By.id("nav-search-submit-text")).click();
			OreoSearch();
			//try-catch exception
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//using elements to type in the search box and click on the search icon
	public void OreoSearch() {
		try {
			//we could use driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oreos", Keys.ENTER); as well, but we will use buffer time
			selectCheckBox("Lemon"); 
			selectCheckBox("Amazon Export Sales LLC.");
			
			//try-catch exception
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}

	private void selectCheckBox(String displayText) throws InterruptedException {
		
		//helps execute javascript
		jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1200)");
		Thread.sleep(1500);
		
		//click on checkbox from dynamic list, xpath for light element
		WebElement checkbox = driver.findElement(By.xpath("//li[@aria-label='"+displayText+"']//input"));
		//the i element <i class="a-icon a-icon-checkbox"></i> is the clickable element
		WebElement i = driver.findElement(By.xpath("//li[@aria-label='"+displayText+"']//i"));
		boolean b = checkbox.isSelected();
		System.out.println(b);
		if(!b) {
			i.click();
		}
		
		//prevents stale element exceptions
		System.out.println(driver.findElement(By.xpath("//li[@aria-label='Lemon']//input")).isSelected());
		Thread.sleep(1500);
	}
	


	//running/calling Day1 class
	public static void main(String[] args) {
		
		Day1 myObj = new Day1();
		myObj.invokeBrowser();
	}

}
