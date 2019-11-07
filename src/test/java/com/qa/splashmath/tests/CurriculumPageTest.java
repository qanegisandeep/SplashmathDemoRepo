package com.qa.splashmath.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.pages.CurriculumPage;
import com.qa.splashmath.pages.LandingPage;

public class CurriculumPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LandingPage landingPage ;
	CurriculumPage curriculumPage;
	
	
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
		curriculumPage = landingPage.goToCurriculumPage();
	}
	
	@Test
	public void verifyKindergartenGrade() {
		
	}
	@Test
	public void verifyGradeOne() {
		
	}
	@Test
	public void verifyGradeTwo() {
		
	}
	@Test
	public void verifyGradeThree() {
		
	}
	@Test
	public void verifyGradeFour() {
		
	}
	@Test
	public void verifyGradeFive() {
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
