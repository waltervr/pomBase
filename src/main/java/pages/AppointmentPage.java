package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentPage extends BasePage {

	@FindBy(id = "appointment")
	WebElement apptSection;
	
	@FindBy(id = "username")
	WebElement username;
	
	public AppointmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisplayed() {
		return apptSection.isDisplayed();
	}
	
	public String getUsername() {
		return username.getText();
	}

}
