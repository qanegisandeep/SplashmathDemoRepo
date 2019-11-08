package com.qa.splashmath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.utility.Constants;
import com.qa.splashmath.utility.ElementUtility;

public class GradeOnePage extends BasePage{
	WebDriver driver;
	ElementUtility elementUtility;
	
	
	By parentSignUpButton = By.linkText("Parents, Sign Up for Free");
	By teacherSignUpLink = By.linkText("Teachers, Sign Up for Free");
	By header = By.xpath("//h1[text()='Grade 1 Math Curriculum']");
	By skillName = By.xpath("//span[text()='"+Constants.PLAY_GRADE_ONE_SKILL+"']");
	By questionFrame = By.id("sp-iframe");
	By problemAnswer = By.xpath("//div[@class='choice-text']//ancestor::div[@class='btn-choice pt-choice index-0']");
	By nextQuestion = By.className("button-text-img");
	By closeIframe = By.id("iframe-close-button");
	By showFullCurriculum = By.xpath("//a[text()='Show full curriculum']//parent::div[@class='curriculum-state-btn js-show-curriculum']");
	By hippoLoader = By.xpath("//div[text()='Loading...']");
	
	public GradeOnePage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
		elementUtility.waitForElementVisible(header, 15);
	}
	
	public String getHeadertext() {
		return elementUtility.getText(header);
	}
	
	public boolean isParentSignUpButtonPresent() {
		return elementUtility.isElementVisible(parentSignUpButton);
	}
	public boolean isTeacherSignUpButtonPresent() {
		return elementUtility.isElementVisible(teacherSignUpLink);
	}

	/**
	 * Currently this logic is not working [Figuring it out and will update] 
	 */
	public void guestUserPlaysGames() {
		getSkillToPlay();	
		elementUtility.waitForFrameAndSwitchToIt(questionFrame,15);
		System.out.println("In Iframe = " + questionFrame);
		elementUtility.playGame(questionFrame, problemAnswer, nextQuestion);
	}
	
	public void getSkillToPlay() {
		elementUtility.doClick(skillName);
		System.out.println("clicked skill" + skillName);
	}
	
	

}
