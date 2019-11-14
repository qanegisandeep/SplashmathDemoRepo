package com.qa.splashmath.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.pages.LandingPage;
import com.qa.splashmath.utility.Constants;

public class LandingPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LandingPage landingPage ; 
	
	
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
	}
	
	@Test
	public void verifyLandingPageTitleTest() {
		Assert.assertEquals(landingPage.getLandingPageTitle(), Constants.LANDING_PAGE_TITLE, "Landing Page Title not found");
	}
	
	@Test
	public void verifySignInButtonPresentTest() {
		Assert.assertTrue(landingPage.isSignInButtonPresent(), "SignIn button not present on landing page");
	}
	
	@Test
	public void verifyCaseStudiesLinkPresentTest() {
		Assert.assertTrue(landingPage.isCaseStudiesLinkPresent(), "CaseStudies Link not present on landing page");
	}
	
	@Test
	public void verifyFeatureAndPlansLinkPresentTest() {
		Assert.assertTrue(landingPage.isFeatureAndPlansLinkPresent(), "FeatureAndPlans Link not present on landing page");
	}
	
	@Test
	public void verifyCurriculumLinkPresentTest() {
		Assert.assertTrue(landingPage.isCurriculumLinkPresent(), "Curriculum Link not present on landing page");
	}
	
	@Test
	public void verifyParentSignUpForFreeButtonPresentTest() {
		Assert.assertTrue(landingPage.isParentSignUpForFreeButtonPresent(), "ParentSignUpForFree Button not present on landing page");
	}
	
	@Test
	public void verifyTeacherSignUpForFreeButtonPresentTest() {
		Assert.assertTrue(landingPage.isTeacherSignUpForFreeButtonPresent(), "TeacherSignUpForFree Button not present on landing page");
	}
	
	@Test
	public void verifySplashmathLogoPresentTest() {
		Assert.assertTrue(landingPage.isSplashmathLogoPresent(), "Splashmath Logo not present on landing page");
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
