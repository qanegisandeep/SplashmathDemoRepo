package com.qa.splashmath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.utility.ElementUtility;

public class GradeOnePage extends BasePage{
	WebDriver driver;
	ElementUtility elementUtility;
	
	
	By parentSignUpButton = By.linkText("Parents, Sign Up for Free");
	By teacherSignUpLink = By.linkText("Teachers, Sign Up for Free");
	By header = By.xpath("//h1[text()='Grade 1 Math Curriculum']");
	By skillName = By.xpath("//span[text()='Make a Number']");
	
	
	
	public GradeOnePage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
	}
	
	public String getHeadertext() {
		return elementUtility.getText(header);
	}
	
	public void isParentSignUpButtonPresent() {
		elementUtility.isElementVisible(parentSignUpButton);
	}
	public void isTeacherSignUpButtonPresent() {
		elementUtility.isElementVisible(teacherSignUpLink);
	}

	
	public void guestUserPlaysGames() {
		
	}
	
	public void getSkillToPlay() {
		
	}
	
	

}
