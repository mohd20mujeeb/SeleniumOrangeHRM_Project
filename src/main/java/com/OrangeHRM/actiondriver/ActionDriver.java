package com.OrangeHRM.actiondriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.base.BaseClass;

public class ActionDriver {
	private WebDriver driver;
	private WebDriverWait wait;

	public ActionDriver(WebDriver driver) {
		this.driver = driver;
		int explicitWait = Integer.parseInt(BaseClass.getProp().getProperty("explicitWait"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
	}

	// Method to click on element
	public void click(By by) {
		try {
			waitForElementToBeClickable(by);
			driver.findElement(by).click();
		} catch (Exception e) {
			System.out.println("Unable to click on element:" + e.getMessage());
		}
	}

	// method to type text in input field
	public void type(By by, String value) {
		try {
			waitForElementToBeVisible(by);
			WebElement element = driver.findElement(by);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to type in element:" + e.getMessage());
		}
	}

	// method to get text from element
	public String getText(By by) {
		try {
			waitForElementToBeVisible(by);
			String text = driver.findElement(by).getText();
			return text;
		} catch (Exception e) {
			System.out.println("Unable to get text from element:" + e.getMessage());
			return "";
		}
	}

	// method to compare two texts
	public void compareText(By by, String expectedText) {
		try {
			String actualText = driver.findElement(by).getText();
			if (expectedText.equals(actualText)) {
				System.out.println("Test are matching:" + actualText + " equals " + expectedText);
			} else {
				System.out.println("Test are not matching:" + actualText + " does not equals " + expectedText);
			}
		} catch (Exception e) {
			System.out.println("Unable to compare text:" + e.getMessage());
		}
	}

	// method to check if element is displayed
	public boolean isDisplayed(By by) {
		try {
			waitForElementToBeVisible(by);
			return driver.findElement(by).isDisplayed();
		} catch (Exception e) {
			System.out.println("Unable to check if element is displayed:" + e.getMessage());
			return false;
		}
	}

	// wait for page to load
	public void waitForPageLoad(int timeOutInSec) {
		try {
			wait.withTimeout(Duration.ofSeconds(timeOutInSec)).until(WebDriver -> ((JavascriptExecutor) WebDriver)
					.executeScript("return document.readyState").equals("complete"));
			System.out.println("Page is loaded successfully");
		} catch (Exception e) {
			System.out.println("Page is not loaded within the specified timeout:" + e.getMessage());
		}

	}
	//scroll to element
	public void scrollToElement(By by) {
		try {
			waitForElementToBeVisible(by);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(by);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			System.out.println("Scrolled to element successfully");
		} catch (Exception e) {
			System.out.println("Unable to scroll to element:" + e.getMessage());
		}
	}
	
	// wait for element to be clickable

	private void waitForElementToBeClickable(By by) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			System.out.println("element is not clickable:" + e.getMessage());
		}
	}

	// Wait for element to be visible
	private void waitForElementToBeVisible(By by) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			System.out.println("element is not visible:" + e.getMessage());
		}
	}
}
