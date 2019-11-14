package com.qa.splashmath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.utility.Constants;
import com.qa.splashmath.utility.ElementUtility;

public class LandingPage extends BasePage{
	
	WebDriver driver;
	ElementUtility elementUtility;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
		elementUtility.waitForTitlePresent(Constants.LANDING_PAGE_TITLE, 20);
	}
	
	By signInButton = By.linkText("Sign In");
	By caseStudiesLink = By.linkText("Case Studies");
	By featureAndPlansLink = By.linkText("Features & Plans");
	By curriculumLink = By.linkText("Curriculum");
	By parentSignUpForFreeButton = By.linkText("Parents, Sign Up for Free");
	By teacherSignUpForFreeButton = By.linkText("Teachers, Sign Up for Free");
	
	By splashmathLogo = By.xpath("//a[@class='logo pull-left']/img");
	By hotjarNoThanksRadioButton = By.xpath("//div[contains(@data-index,'1')]");
	By hotjarNextButton = By.id("_hj-f5b2a1eb-9b07_action_submit");
	By cancelConsentOption = By.xpath("//div[@class='_hj-f5b2a1eb-9b07_consent_actions']/button[1]");
	public String getLandingPageTitle() {
		return elementUtility.getPageTitle();
	}
	
	public boolean isSignInButtonPresent() {
		elementUtility.waitForElementPresent(signInButton, 10);
		return elementUtility.isElementVisible(signInButton);
	}
	
	public boolean isCaseStudiesLinkPresent() {
		elementUtility.waitForElementPresent(caseStudiesLink, 10);
		return elementUtility.isElementVisible(caseStudiesLink);
	}
	
	public boolean isFeatureAndPlansLinkPresent() {
		elementUtility.waitForElementPresent(featureAndPlansLink, 10);
		return elementUtility.isElementVisible(featureAndPlansLink);
	}
	
	public boolean isCurriculumLinkPresent() {
		elementUtility.waitForElementPresent(curriculumLink, 10);
		return elementUtility.isElementVisible(curriculumLink);
	}
	
	public boolean isParentSignUpForFreeButtonPresent() {
		elementUtility.waitForElementPresent(parentSignUpForFreeButton, 10);
		return elementUtility.isElementVisible(parentSignUpForFreeButton);
	}
	
	public boolean isTeacherSignUpForFreeButtonPresent() {
		elementUtility.waitForElementPresent(teacherSignUpForFreeButton, 10);
		return elementUtility.isElementVisible(teacherSignUpForFreeButton);
	}
	
	public boolean isSplashmathLogoPresent() {
		elementUtility.waitForElementPresent(splashmathLogo, 10);
		return elementUtility.isElementVisible(splashmathLogo);
	}
	
	
	public void clickOnSignInButton() {
		elementUtility.waitForElementPresent(signInButton, 10);
		elementUtility.doClick(signInButton);
	}
	
	public SignInPage goToSignInPage() {
		clickOnSignInButton();
		return new SignInPage(driver);
	}
	
	
	
	public void clickOnParentSignUpButton() {
		elementUtility.waitForElementPresent(parentSignUpForFreeButton, 10);
		elementUtility.doClick(parentSignUpForFreeButton);
	}
	
	public ParentSignUpPage goToParentSignUpPage() {
		clickOnParentSignUpButton();
		return new ParentSignUpPage(driver);
	}
	
	
	public void clickTeacherSignUp() {
		
	}
	
	public void clickOnCaseStudiesLink() {
		elementUtility.waitForElementPresent(caseStudiesLink, 10);
		elementUtility.doClick(caseStudiesLink);
	}
	
	public CaseStudiesPage goToCaseStudiesPage() {
		clickOnCaseStudiesLink();
		return new CaseStudiesPage(driver);
	}
	
	public void clickFeatureAndPlans() {
		
	}
	public void clickCurriculum() {
		elementUtility.waitForElementPresent(curriculumLink, 10);
		elementUtility.doActionClick(curriculumLink);	
	}
	
	public void clickOnHotjarBot() {
		elementUtility.waitForElementVisible(hotjarNextButton, 20);
		elementUtility.doClick(hotjarNoThanksRadioButton);
		elementUtility.doClick(hotjarNextButton);
		elementUtility.doClick(cancelConsentOption);
	}
	public CurriculumPage goToCurriculumPage() {
		clickCurriculum();
		return new CurriculumPage(driver);
		
	}
	
	

}
