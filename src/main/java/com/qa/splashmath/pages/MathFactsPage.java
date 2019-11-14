package com.qa.splashmath.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.splashmath.basePage.BasePage;
import com.qa.splashmath.utility.Constants;
import com.qa.splashmath.utility.ElementUtility;

public class MathFactsPage extends BasePage{

	WebDriver driver;
	ElementUtility elementUtility;
	
	By startButton = By.id("start-btn");
	By questionFrame = By.id("sp-iframe");
	By selectOption = By.xpath("(//tr[@class='btn-choice-row'])[1]/td[1]/div");
	By answerSymbol = By.xpath("//div[@class='bulb-box wrong-ans' or @class='bulb-box right-ans']");
	By answerBulb = By.xpath("//div[@class='bulb-box']//preceding-sibling::table[@class='tbl-arithmetic-cont']");
	By header = By.xpath("//h1[text()='"+ Constants.MATH_FACTS_PAGE_HEADER+"']");
	By parentSignUpButton = By.linkText("Parents, Sign Up for Free");
	
	public MathFactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtility(driver);
		elementUtility.waitForElementVisible(startButton, 15);
	}
	
	public void playMathFact() {
		clickStart();
		elementUtility.waitForElementVisible(questionFrame, 20);
	}
	
	public void clickStart() {
		elementUtility.doClick(startButton);
		elementUtility.waitForFrameAndSwitchToIt(questionFrame,20);
		System.out.println("Switched to iframe : "+ questionFrame);
		//elementUtility.waitForElementVisible(answerBulb, 20);
		elementUtility.playMathFactGame(answerBulb, selectOption, Constants.QUESTION_LIMIT);
	}
}

// F6 = > To execute particular line number [Step by step execution]
// To know value of any particular statement > Right click > Watch
// F8 = Will jump from one debugging point to another debugging point