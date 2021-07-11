package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage {

	//@Test
	public void locators() throws InterruptedException {
		String url = "https://katalon-demo-cura.herokuapp.com/";
		String user = "John Doe";
		String pwd = "ThisIsNotAPassword";

		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement copyrightText= driver.findElement(By.tagName("p"));
		copyrightText.getText();

		WebElement btnMakeAppt= driver.findElement(By.id("btn-make-appointment"));
		btnMakeAppt.click();

		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys(user);

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(pwd);

		WebElement btnLogin = driver.findElement(By.className("btn-default"));
		btnLogin.click();
	}

	//@Test
	public void raceCondition() {
		String url = "https://www.phptravels.net/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement element = driver.findElement(By.tagName("p"));
		System.out.println(element.getText());
	}

	//@Test
	public void raceConditionWithExplicitWait() {
		String url = "https://www.phptravels.net/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));
		System.out.println(element.getText());
	}

	//@Test
	public void raceConditionWithImplicitWait() {
		String url = "https://www.phptravels.net/";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		WebElement element = driver.findElement(By.tagName("p"));
		System.out.println(element.getText());
	}

	//@Test
	public void raceConditionWithFluentWait() {
		String url = "https://www.phptravels.net/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
				.withTimeout(Duration.ofSeconds(30)) 
				.pollingEvery(Duration.ofSeconds(3)) 
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() { 
			public WebElement apply(WebDriver driver) { 
				return driver.findElement(By.tagName("p"));
			} 
		});

		System.out.println(element.getText());
	}

	//@Test
	public void getAlertText() {
		String url = "https://the-internet.herokuapp.com/javascript_alerts";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

	}

	//@Test
	public void acceptAlert() {
		String url = "https://the-internet.herokuapp.com/javascript_alerts";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	//@Test
	public void dismissAlert() {
		String url = "https://the-internet.herokuapp.com/javascript_alerts";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	//@Test
	public void switchWindow() {
		String url = "https://the-internet.herokuapp.com/windows";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		String originalWindow = driver.getWindowHandle();

		driver.findElement(By.linkText("Click Here")).click();

		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("New Window"));
	}

	//@Test
	public void closeTabAndReturnToOriginal() {
		String url = "https://the-internet.herokuapp.com/windows";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		String originalWindow = driver.getWindowHandle();

		driver.findElement(By.linkText("Click Here")).click();

		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("New Window"));

		driver.close();
		driver.switchTo().window(originalWindow);
	}

	//@Test
	public void frames() {
		String url = "https://codepen.io/wvargascr/full/jOVyvWj";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.switchTo().frame("result");
		WebElement element = driver.findElement(By.id("email"));
		element.sendKeys("Testing frames");

	}

	@Test
	public void jsExecutor() {
		String url = "https://katalon-demo-cura.herokuapp.com/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.id("btn-make-appointment"));

		String buttonText = (String) js.executeScript("return arguments[0].innerText", button);

		js.executeScript("arguments[0].click();", button);

		js.executeScript("console.log('"+ buttonText +"')");

	}
}
