package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		String url = "https://the-internet.herokuapp.com/javascript_alerts";
		driver = new ChromeDriver();
		driver.get(url);
		System.out.println("Entering before method SHARED");
	}
	
	@Test
	public void acceptAlert() {
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		driver.switchTo().alert().accept();
	}

}
