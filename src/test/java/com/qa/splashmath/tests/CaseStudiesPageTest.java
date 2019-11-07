package com.qa.splashmath.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.pages.CaseStudiesPage;
import com.qa.splashmath.pages.LandingPage;
import com.qa.splashmath.utility.Constants;

public class CaseStudiesPageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LandingPage landingPage ; 
	CaseStudiesPage caseStudiesPage;
	
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
		caseStudiesPage = landingPage.goToCaseStudiesPage();
		
	}
	
	@Test
	public void verifyPageTitleTest() {
		Assert.assertEquals(caseStudiesPage.pageTitle(), Constants.CASE_STUDIES__PAGE_TITLE, "Case Studies page Title missing");
	}
	
	@Test
	public void verifyTeacherTabPresentTest() {
		Assert.assertTrue(caseStudiesPage.isTeacherTabPresent(), "Teacher tab not present on Case Studies Page");
	}
	
	@Test
	public void verifyParentTabPresentTest() {
		Assert.assertTrue(caseStudiesPage.isParentTabPresent(), "Parent tab not present on Case Studies Page");
	}
	
	@Test
	public void verifySplashmathLogoPresentTest() {
		Assert.assertTrue(caseStudiesPage.isSplashmathLogoPresent(), "Splashmath Logo not present on Case Studies Page");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

}
