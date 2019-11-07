package com.qa.splashmath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.utility.ElementUtility;

public class CurriculumPage extends BasePage{
	
	WebDriver driver;
	ElementUtility elementUtility;
	
	
	By kindergarten = By.xpath("//p[text()='Kindergarten']");
	By gradeOne = By.xpath("//p[text()='Grade 1']");
	By gradeTwo = By.xpath("//p[text()='Grade 2']");
	By gradeThree = By.xpath("//p[text()='Grade 3']");
	By gradeFour = By.xpath("//p[text()='Grade 4']");
	By gradeFive = By.xpath("//p[text()='Grade 5']");
	By viewAllSkills = By.className("view-all-link");
	
	
	public CurriculumPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
		elementUtility.waitForElementPresent(viewAllSkills, 20);
		
	}
	
	public void clickViewAllLink() {
		elementUtility.waitForElementVisible(viewAllSkills, 20);
		elementUtility.doClick(viewAllSkills);
	}
	
	public void clickKindergarten() {
		elementUtility.doClick(kindergarten);
	}
	
	public void goToKindergartenPage() {
		clickViewAllLink();
	}
	
	public void clickGradeOne() {
		elementUtility.waitForTextPresent(gradeOne, 20);
		elementUtility.doActionClick(gradeOne);
	}
	
	public GradeOnePage goToGradeOnePage() {
		clickGradeOne();
		clickViewAllLink();
		return new GradeOnePage(driver);
	}
	
	public void clickGradeTwo() {
		elementUtility.doClick(gradeTwo);
	}
	
	public void goToGradeTwoPage() {
		clickViewAllLink();
	}
	public void clickGradeThree() {
		elementUtility.doClick(gradeThree);
	}
	
	public void goToGradeThreePage() {
		clickViewAllLink();
	}
	public void clickGradeFour() {
		elementUtility.doClick(gradeFour);
	}
	
	public void goToGradeFourPage() {
		clickViewAllLink();
	}
	public void clickGradeFive() {
		elementUtility.doClick(gradeFive);
	}
	
	public void goToGradeFive() {
		clickViewAllLink();
	}
	
	
	

}
