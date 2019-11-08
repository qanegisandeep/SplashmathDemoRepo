package com.qa.splashmath.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.pages.CurriculumPage;
import com.qa.splashmath.pages.GradeOnePage;
import com.qa.splashmath.pages.LandingPage;

public class GradeOnePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LandingPage landingPage ; 
	CurriculumPage curriculumPage;
	GradeOnePage gradeOnePage ;
	
	
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
		curriculumPage = landingPage.goToCurriculumPage();
		gradeOnePage = curriculumPage.goToGradeOnePage();
	}
	
	
	@Test(enabled = false)
	public void verifyGuestSignUpPopUpTest() {
		gradeOnePage.guestUserPlaysGames();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
