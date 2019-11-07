package com.qa.splashmath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.utility.ElementUtility;

public class HomeLoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtility elementUtility ;
	
	By splashmathLogo = By.xpath("(//a[@class='logo']//img)[2]");
	By header = By.className("login-title");
	By backIcon = By.xpath("//i[@class='iconcust-iconBackBtn']//ancestor::div[@class='modal-title-wrap']");
	By crossIcon = By.xpath("//a[@class='cross' and @data-source='home signin popup']");
	By parentEmail = By.id("user_login");
	By password = By.id("user_password");
	By forgotPassword = By.id("forget-password");
	By loginButton = By.id("login-button");
	By goolgeLoginButton = By.xpath("//div[@id='oauth']/a[1]/span[1]");
	By facebookLoginButton = By.xpath("//div[@id='oauth']/a[2]/span[1]");
	
	public HomeLoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
	}
	
	public boolean isSplashmathLogoPresent() {
		return elementUtility.isElementVisible(splashmathLogo);
	}
	
	public boolean isBackIconPresent() {
		return elementUtility.isElementVisible(backIcon);
	}
	public boolean isCrossIconPresent() {
		return elementUtility.isElementVisible(crossIcon);
	}
	public boolean isParentEmailFieldPresent() {
		return elementUtility.isElementVisible(parentEmail);
	}
	public boolean isPasswordFieldPresent() {
		return elementUtility.isElementVisible(password);
	}
	public boolean isForgotPasswordLinkPresent() {
		return elementUtility.isElementVisible(forgotPassword);
	}
	public boolean isLoginButtonPresent() {
		return elementUtility.isElementVisible(loginButton);
	}
	public boolean isGoogleLoginButtonPresent() {
		return elementUtility.isElementVisible(goolgeLoginButton);
	}
	public boolean isFacebookLoginButtonPresent() {
		return elementUtility.isElementVisible(facebookLoginButton);
	}
	
	public void doLogin(String userEmail, String pwd) {
		elementUtility.doSendKeys(parentEmail, userEmail);
		elementUtility.doSendKeys(password, pwd);
		elementUtility.doClick(loginButton);
	}
	
	
	
	
}
