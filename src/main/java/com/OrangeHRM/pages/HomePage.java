package com.OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.OrangeHRM.actiondriver.ActionDriver;

public class HomePage {
	private ActionDriver actionDriver;

//define locators using By class
	private By adminTab = By.xpath("//span[.='Admin']");
	private By userIDButton = By.className("oxd-userdropdown-name");
	private By logoutButton = By.xpath("//a[.='Logout']");
	private By orangeHRMLogo = By.xpath("//img[@alt='client brand banner']");

//Initializing ActionDriver in constructor
	public HomePage(WebDriver driver) {
		this.actionDriver = new ActionDriver(driver);
	}

//method to verify if admin tab is displayed
	public boolean isAdminTabViible() {
		return actionDriver.isDisplayed(adminTab);
	}

	public boolean isOrangeHRMLogoVisible() {
		return actionDriver.isDisplayed(orangeHRMLogo);
	}
	
	//method to perform logout action
	public void logout() {
		actionDriver.click(userIDButton);
		actionDriver.click(logoutButton);
	}
}
