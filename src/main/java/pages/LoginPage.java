package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	@FindBy(id = "btn-make-appointment")
	WebElement btnMakeAppt;
	
	@FindBy(name = "username")
	WebElement usernameField;
	
	@FindBy(name = "password")
	WebElement passwordField;
	
	@FindBy(className = "btn-default")
	WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public AppointmentPage doLogin(String user, String pwd) {
		clickOnElement(btnMakeAppt);
		typeOnElement(usernameField, user);
		typeOnElement(passwordField, pwd);
		clickOnElement(btnLogin);
		return new AppointmentPage(driver);
	}

}
