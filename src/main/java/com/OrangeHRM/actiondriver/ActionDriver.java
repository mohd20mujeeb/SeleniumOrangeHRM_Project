package com.OrangeHRM.actiondriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDriver {
   private WebDriver driver;
   private WebDriverWait wait;
   
   public ActionDriver(WebDriver driver) {
	   this.driver=driver;
   }
}
