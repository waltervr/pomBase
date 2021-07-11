package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AppointmentPage;
import pages.LoginPage;
import utils.Util;

public class Tests_Login extends BaseTest {
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	@Parameters({"user", "pwd"})
	public void testValidLogin(String user, String pwd) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		AppointmentPage apptPage = loginPage.doLogin(user, pwd);
		
		
		softAssert.assertTrue(apptPage.isDisplayed());
		softAssert.assertEquals(apptPage.getUsername(), "Walter");
		softAssert.assertEquals(apptPage.getUsername(), "Walter");
		softAssert.assertEquals(apptPage.getUsername(), "Walter");
		
		softAssert.assertAll();
	}
	
	//@Test
	public void testInvalidLogin() throws InterruptedException {		
		String user = "John Doe";
		String pwd = Util.generateRandomName("CE");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);
	}
	
}
