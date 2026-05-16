package com.OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.OrangeHRM.actiondriver.ActionDriver;

public class LoginPage {
    private ActionDriver actionDriver;
    
    //define locators using By class
    
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//p[.='Invalid credentials']");
  
    public LoginPage(WebDriver driver) {
		this.actionDriver = new ActionDriver(driver);
    	
    }
  //method for login
    public void login(String username, String password) {
		actionDriver.type(usernameField, "admin");
		actionDriver.type(passwordField, "admin123");
		actionDriver.click(loginButton);
	}
	
	//method to get error message
	public boolean isErrorMessageDislayed() {
	    return actionDriver.isDisplayed(errorMessage);
	}
	
	//method to get error message text
	public String getErrorMessageText() {
	    return actionDriver.getText(errorMessage);
	}
	
	//verify error message is correct or not
	public void verifyErrorMessage(String expectedMessage) {
		actionDriver.compareText(errorMessage, expectedMessage);
	}
	
}

