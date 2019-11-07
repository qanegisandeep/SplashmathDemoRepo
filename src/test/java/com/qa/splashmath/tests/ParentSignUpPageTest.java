package com.qa.splashmath.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.pages.LandingPage;
import com.qa.splashmath.pages.ParentSignUpPage;
import com.qa.splashmath.utility.Constants;

public class ParentSignUpPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LandingPage landingPage ; 
	ParentSignUpPage parentSignUpPage;
	
	
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
		parentSignUpPage = landingPage.goToParentSignUpPage();
		
	}
	
	@Test
	public void verifySplashmathLogoTest() {
		Assert.assertTrue(parentSignUpPage.isSplashmathLogoPresent(), "Splashmath logo not present on Parent SignUp Page");
	}
	
	@Test
	public void verifyPageHeaderTest() {
		Assert.assertEquals(parentSignUpPage.getPageHeader(),Constants.PARENT_SIGNUP__PAGE_HEADER, "Header missing on Parent SignUp Page");
	}
	
	@Test
	public void verifyLoginButtonTest() {
		Assert.assertTrue(parentSignUpPage.isLoginButtonPresent(), "Login Button not present on Parent SignUp Page");
	}
	
	@Test
	public void verifyGoogleSignUpButtonTest() {
		Assert.assertTrue(parentSignUpPage.isGoogleSignUpButtonPresent(), "Google Button not present on Parent SignUp Page");
	}
	@Test
	public void verifyEmailFieldTest() {
		Assert.assertTrue(parentSignUpPage.isEmailFieldPresent(), "Email Field not present on Parent SignUp Page");
	}
	@Test
	public void verifyPasswordFieldTest() {
		Assert.assertTrue(parentSignUpPage.isPasswordFieldPresent(), "Password Field not present on Parent SignUp Page");
	}
	@Test
	public void verifyTermsOfUseTest() {
		Assert.assertTrue(parentSignUpPage.isTermsOfUseLinkPresent(), "Terms of Use Link not present on Parent SignUp Page");
	}
	@Test
	public void verifyPrivacyPolicyLinkTest() {
		Assert.assertTrue(parentSignUpPage.isPrivacyPolicyLinkPresent(), "Privacy Policy link not present on Parent SignUp Page");
	}
	@Test
	public void verifyTeachersSignUpLinkTest() {
		Assert.assertTrue(parentSignUpPage.isTeachersSignUpLinkPresent(), "Teacher SignUp Link not present on Parent SignUp Page");
	}
	
	
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
