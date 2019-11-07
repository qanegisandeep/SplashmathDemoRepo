package com.qa.splashmath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.utility.ElementUtility;

public class ParentSignUpPage extends BasePage{

	WebDriver driver;
	ElementUtility elementUtility;
	
	By splashmathLogo = By.xpath("//a[@class='logo pull-left']/img");
	By loginButton = By.linkText("Login");
	By header = By.className("header-text");
	By googleSignUpButton = By.xpath("//a[@class='js-social-signup-button']//parent::li[@class='google']");
	By facebookSignUpButton = By.xpath("//a[@class='js-social-signup-button']//parent::li[@class='facebook']");
	By email = By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@type='password']");
	By dateOfBirth = By.id("user_dob_year");
	By createAccountButton = By.xpath("//input[@type='submit']");
	By termsOfUseLink = By.linkText("Terms of Use");
	By privacyPolicyLink = By.linkText("Privacy Policy");
	By teachersSignUpLink = By.linkText("Teachers, Click here to sign up");
	
	public ParentSignUpPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
	}
	
	public String getPageHeader() {
		return elementUtility.getText(header);
	}
	
	public boolean isSplashmathLogoPresent() {
		return elementUtility.isElementVisible(splashmathLogo);
	}
	
	public boolean isLoginButtonPresent() {
		return elementUtility.isElementVisible(loginButton);
	}
	
	public boolean isGoogleSignUpButtonPresent() {
		return elementUtility.isElementVisible(googleSignUpButton);
	}
	
	public boolean isFacebookSignUpButtonPresent() {
		return elementUtility.isElementVisible(facebookSignUpButton);
	}
	
	public boolean isEmailFieldPresent() {
		return elementUtility.isElementVisible(email);
	}
	
	public boolean isPasswordFieldPresent() {
		return elementUtility.isElementVisible(password);
	}
	
	public boolean isDateOfBirthFieldPresent() {
		return elementUtility.isElementVisible(dateOfBirth);
	}
	public boolean isTermsOfUseLinkPresent() {
		return elementUtility.isElementVisible(termsOfUseLink);
	}
	public boolean isPrivacyPolicyLinkPresent() {
		return elementUtility.isElementVisible(privacyPolicyLink);
	}
	
	public boolean isTeachersSignUpLinkPresent() {
		return elementUtility.isElementVisible(teachersSignUpLink);
	}
	
	
	
	
	
	
	
}
