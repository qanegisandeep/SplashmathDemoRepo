package com.qa.splashmath.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.pages.CurriculumPage;
import com.qa.splashmath.pages.GradeOnePage;
import com.qa.splashmath.pages.LandingPage;
import com.qa.splashmath.pages.MathFactsPage;

public class MathFactsPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LandingPage landingPage ; 
	CurriculumPage curriculumPage;
	GradeOnePage gradeOnePage ;
	MathFactsPage mathFactsPage;
	
	
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
		landingPage.clickOnHotjarBot();
		curriculumPage = landingPage.goToCurriculumPage();
		gradeOnePage = curriculumPage.goToGradeOnePage();
		mathFactsPage = gradeOnePage.goToMathFactsPage();
	}
	
	
	@Test(enabled = true)
	public void verifyGuestSignUpPopUpTest() {
		mathFactsPage.playMathFact();
	}
	
	@Test
	public void fun() {
		System.out.println("Hello");
	}
	
	@Test
	public void adam() {
		System.out.println("Adam");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
