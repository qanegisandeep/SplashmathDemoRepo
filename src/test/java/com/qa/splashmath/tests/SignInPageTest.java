package com.qa.splashmath.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.pages.LandingPage;
import com.qa.splashmath.pages.SignInPage;
import com.qa.splashmath.utility.Constants;

public class SignInPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LandingPage landingPage ; 
	SignInPage signInPage ;
	
	
	@BeforeTest
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
		
	}
	
	@Test
	public void verifySplashmathLogoTest() {
	Assert.assertTrue(signInPage.isSplashmathLogoPresent(), "Splashmath Logo not present on SignIn page");
	}
	
	@Test
	public void verifySignInPageHeaderTest() {
		Assert.assertEquals(signInPage.getHeaderText(), Constants.SIGN_IN_PAGE_HEADER, "SignIn page Header missing");
	}
	
	@Test
	public void verifyCloseSignInPageIconTest() {
		Assert.assertTrue(signInPage.iscloseSignInPageIconPresent(), "Close Icon not present on SignIn page");
	}
	
	@Test
	public void verifyClassLoginIconTest() {
		Assert.assertTrue(signInPage.isClassroomLoginOptionPresent(), "Classroom login Option not present on SignIn page");
	}
	
	@Test
	public void verifyHomeLoginIconTest() {
		Assert.assertTrue(signInPage.isHomeLoginOptionPresent(), "Home login Option not present on SignIn page");
	}
	
	@Test
	public void verifyTeacherParentSignInLinkTest() {
		Assert.assertTrue(signInPage.isTeacherParentLoginLinkPresent(), "Teacher/Parent login Link not present on SignIn page");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
