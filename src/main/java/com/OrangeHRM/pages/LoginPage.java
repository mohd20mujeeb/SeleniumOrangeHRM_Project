package com.OrangeHRM.pages;

import org.openqa.selenium.By;

import com.OrangeHRM.actiondriver.ActionDriver;

public class LoginPage {
    private ActionDriver actionDriver;
    
    //define locators using By class
    
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//p[.='Invalid credentials']");
}
