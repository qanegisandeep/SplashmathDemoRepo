package com.qa.splashmath.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.pages.HomeLoginPage;
import com.qa.splashmath.pages.LandingPage;
import com.qa.splashmath.pages.SignInPage;
import com.qa.splashmath.utility.Constants;
import com.qa.splashmath.utility.ExcelUtil;

public class HomeLoginPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LandingPage landingPage ; 
	SignInPage signInPage;
	HomeLoginPage homeLoginPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		landingPage = new LandingPage(driver);
		signInPage = landingPage.goToSignInPage();
		homeLoginPage = signInPage.goToHomeLoginPage();
	}
	
	@Test
	public void verifySplashmathLogoTest() {
		Assert.assertTrue(homeLoginPage.isSplashmathLogoPresent(), "Splashmath logo not present on Home Login Page");
	}
	@Test
	public void verifyBackIconTest() {
		Assert.assertTrue(homeLoginPage.isBackIconPresent(), "Back Icon not present on Home Login Page");
	}
	@Test
	public void verifyCrossButtonTest() {
		Assert.assertTrue(homeLoginPage.isCrossIconPresent(), "Cross Icon not present on Home Login Page");
	}
	@Test
	public void verifyParentEmailFieldTest() {
		Assert.assertTrue(homeLoginPage.isParentEmailFieldPresent(), "Parent Email Field not present on Home Login Page");
	}
	@Test
	public void verifyPasswordFieldTest() {
		Assert.assertTrue(homeLoginPage.isPasswordFieldPresent(), "Password Field not present on Home Login Page");
	}
	@Test
	public void verifyForgotPasswordLinkTest() {
		Assert.assertTrue(homeLoginPage.isForgotPasswordLinkPresent(), "Forgot Password Link not present on Home Login Page");
	}
	@Test
	public void verifyLoginButtonTest() {
		Assert.assertTrue(homeLoginPage.isLoginButtonPresent(), "Login Button not present on Home Login Page");
	}
	@Test
	public void verifyGoogleButtonTest() {
		Assert.assertTrue(homeLoginPage.isGoogleLoginButtonPresent(), "Google Login Button not present on Home Login Page");
	}
	@Test
	public void verifyFacebookButtonTest() {
		Assert.assertTrue(homeLoginPage.isFacebookLoginButtonPresent(), "Facebook Login Button not present on Home Login Page");
	}
	
	@DataProvider
	public Object[][] getLogintTestData(){
		Object[][]data = ExcelUtil.getData(Constants.LOGIN_SHEET_DATA);
		return data;
	}
	
	@Test(dataProvider ="getLogintTestData")
	public void verifyUserLogin(String email, String password) {
		homeLoginPage.doLogin(email, password);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

