package com.qa.splashmath.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtility {
	
	WebDriver driver;
	
	public ElementUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return element;
	}
	
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void doActionClick(By locator) {
		
		Actions action = new Actions(driver);
		try {
			action.moveToElement(getElement(locator)).click().build().perform();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void doSendKeys(By locator, String value) {
		if(isElementVisible(locator)) {
			try {
				getElement(locator).sendKeys(value);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}	
		
	}
	

	public void waitForElementToBeClickable(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	public void waitForElementToInvisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.invisibilityOf(getElement(locator)));
		
	}
	
	public void waitForElementPresent(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForTitlePresent(String title, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForTextPresent(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, getText(locator)));
	}
	
	public void waitForElementVisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		
	}
	
	public void waitForFrameAndSwitchToIt(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		
	}
	
	
	public String getPageTitle() {
		try {
			return driver.getTitle();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}
	
	public String getText(By locator) {
		try {
			return getElement(locator).getText();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean isElementVisible(By locator) {
		try {
			return getElement(locator).isDisplayed();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public void clickUsingJavaScriptExecutor(By locator) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", getElement(locator));
	}
	
	public void playGame(By locator,By problemAttempt, By next) {
		waitForFrameAndSwitchToIt(locator, 20);
		waitForElementVisible(problemAttempt, 20);
		clickUsingJavaScriptExecutor(problemAttempt);
		waitForElementVisible(next, 15);
		doActionClick(next);
		
	}

}
