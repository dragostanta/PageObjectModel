package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{

	@Parameters({"user", "pass"})
	@Test(priority=1, groups = "LoginFunctionality")
	public void validLoginTest(String username, String password) {	
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login =  new LoginPage(driver);
		login.loginInApp(username, password);
		assertTrue(login.checkLoginMessageIsDiplayed(login.sucessLoginPopup));
		login.logoutFromApp();
	}
	
	@Parameters({"invUser", "invPass"})
	@Test(priority=2, groups = "LoginFunctionality")
	public void invalidLoginTest(String invalidUser, String invalidPassword) {
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login =  new LoginPage(driver);
		login.loginInApp(invalidUser, invalidPassword);
		assertTrue(login.checkLoginMessageIsDiplayed(login.errorLoginPopup));	
		login.closePopup();
	}
	
//	@Test(priority=3)
	public void validLoginTest4() {	
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login =  new LoginPage(driver);
		login.loginInApp("TestUser", "12345@67890");
		assertTrue(login.checkLoginMessageIsDiplayed(login.sucessLoginPopup));
		login.logoutFromApp();
	}
	
}
