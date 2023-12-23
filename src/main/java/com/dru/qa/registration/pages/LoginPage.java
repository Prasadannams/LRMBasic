package com.dru.qa.registration.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dru.qa.registration.base.Testbase;
import com.dru.qa.registration.helpers.Helpers;

public class LoginPage extends Helpers{
	
	//create a PageFactory	
	@FindBy(xpath=("//img[@class='logo-size']"))
	WebElement druLogo;
	
	@FindBy(xpath=("//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='UserName']"))
	WebElement userName;
	
	@FindBy(xpath=("//*[@class='form-control ng-untouched ng-pristine ng-valid']"))
	WebElement passWord;
	
	@FindBy(xpath=("//*[text()=' Login ']"))
	WebElement loginButton;
	
	@FindBy(xpath=("//h4[text()='Log out of other device?']"))
	WebElement otherDevice;
	
	@FindBy(xpath=("//button[@class='btn-sm btn-primary']"))
	WebElement accept;
	
	//Initialize page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Create a Action Methods
	
	public String validateURL() {
		return driver.getTitle();
	}
	
	public boolean validateLoginPage() {
		
		return isDisplay(druLogo);
		
	
	}
	
	public HomePage login(String un , String pwd) {
		
		explicitWait(50, userName);
        sendKeys(userName, un, passWord, pwd);
		loginButton.click();
		
		if(otherDevice.isDisplayed()) {
			accept.click();
		}
		
		return new HomePage();
		
		
	}

}
