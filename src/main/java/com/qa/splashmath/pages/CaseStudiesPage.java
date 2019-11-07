package com.qa.splashmath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.utility.ElementUtility;

public class CaseStudiesPage extends BasePage {
	
	WebDriver driver;
	ElementUtility elementUtility;
	
	By teacherTab = By.xpath("//a[text()='Teachers']");
	By parentTab = By.xpath("//a[text()='Parents']");
	By splashmathLogo = By.xpath("//a[@class='logo pull-left']/img");
	
	
	
	public CaseStudiesPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
	}
	
	public String pageTitle() {
		return elementUtility.getPageTitle();
	}
	
	public void isLogoPresent() {
		elementUtility.isElementVisible(splashmathLogo);
	}
	
	public boolean isTeacherTabPresent() {
		return elementUtility.isElementVisible(teacherTab);
	}
	
	public boolean isParentTabPresent() {
		return elementUtility.isElementVisible(parentTab);
	}
	
	public boolean isSplashmathLogoPresent() {
		return elementUtility.isElementVisible(splashmathLogo);
	}
	
	
	

}
