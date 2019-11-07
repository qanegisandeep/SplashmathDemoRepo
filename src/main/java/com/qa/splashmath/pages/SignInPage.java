package com.qa.splashmath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.utility.ElementUtility;

public class SignInPage extends BasePage{
	
	WebDriver driver;
	ElementUtility elementUtility;
	
	By header = By.className("student-login-title");
	By splashmathLogo = By.xpath("//a[@class='logo']/img");
	By crossIcon = By.xpath("//a[@class='cross']//preceding-sibling::div[@class='modal-title']");
	By classLogin = By.xpath("//a[@data-logintype='class']/img");
	By homeLogin = By.xpath("//a[@data-logintype='home']");
	By iAmTeacherParentLink = By.linkText("I am a Teacher/Parent");
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
		elementUtility.waitForElementPresent(header, 15);
	}
	
	
	public String getHeaderText() {
		return elementUtility.getText(header);
	}
	
	public void closeSignInPage() {
		elementUtility.doClick(crossIcon);
	}
	
	public boolean iscloseSignInPageIconPresent() {
		return elementUtility.isElementVisible(crossIcon);
	}
	
	public boolean isSplashmathLogoPresent() {
		return elementUtility.isElementVisible(splashmathLogo);
	}
	
	public boolean isClassroomLoginOptionPresent() {
		elementUtility.waitForElementVisible(classLogin, 10);
		return elementUtility.isElementVisible(classLogin);
	}
	
	public boolean isHomeLoginOptionPresent() {
		return elementUtility.isElementVisible(homeLogin);
	}
	
	public boolean isTeacherParentLoginLinkPresent() {
		return elementUtility.isElementVisible(iAmTeacherParentLink);
	}
	
	public void clickHomeLoginIcon() {
		elementUtility.waitForElementVisible(homeLogin, 10);
		elementUtility.doClick(homeLogin);
	}
	
	public HomeLoginPage goToHomeLoginPage() {
		clickHomeLoginIcon();
		return new HomeLoginPage(driver);
	}
	


}
