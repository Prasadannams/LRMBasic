package com.dru.qa.registration.helpers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.dru.qa.registration.base.Testbase;

public class Helpers extends Testbase{
	
	public Robot rb;
	public SoftAssert softAssert;
	public JavascriptExecutor js;
	
	
	
//===========ResUsable Methods==============
	
	

	public  void clickMethod(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele)).isEnabled();
		ele.click();
	}
	
	public  boolean isDisplay(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
	}
	
	public  void clcik(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele)).click();
	}
	
	
	public  void display(WebElement ele , int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.isDisplayed();
	}
	
	// Used to Send Elements on WebPage
	public void sendKeysToWebElement(WebElement ele , String value) {
		ele.clear();
		ele.sendKeys(value);
	}
	
	
	public void performClick(WebElement ele) {
		ele.click();
	}
	
	
	// JavaScriptExecutor Methods
	public void jsClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void scrollIntoView(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
		
	
	
	//IT WILL ENTER VALUES AFTER CLEARING THE FIELD
	public void sendKeys(WebElement ele,  String un, WebElement ele1, String pwd ) {
		 ele.clear();
		 ele.sendKeys(un);
		 ele1.clear();
		 ele1.sendKeys(pwd);
	}
	
	public  void explicitWait(int time, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	public void Designation() {
		
		List<WebElement> languages=driver.findElements(By.xpath(" //div[@class='ng-dropdown-panel-items scroll-host']/div/div"));
        for(WebElement lang : languages) {
        	if(lang.getText().equalsIgnoreCase("Telugu")) {
        		lang.click();
        	}
        }
	}
	
	public void ListOfWebElements(List<WebElement> elements) {
		for(WebElement ele : elements) {
             scrollIntoView(ele);
             jsClick(ele);
	
		
		}
		
	}
	
	public void implicitWait(int time) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	
	// Action class methods 
	public void actionClick(WebElement ele) {
		
		Actions action = new Actions(driver);
		action.click(ele).build().perform();
	}
	
	public void actionTab() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();

	}
	
	//Robots class methods
	public void pressControl() throws AWTException {
		
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
	}
	
   public void ReleaseControl() throws AWTException {
		
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.delay(1000);
	}

   public void pressV() throws AWTException {
		
		rb.keyPress(KeyEvent.VK_V);
	}
	
	
   public void releaseV() throws AWTException {
		
 		rb.keyPress(KeyEvent.VK_V);
 		rb.delay(1000);
 	}
   
   public void pressEnter() {
	   
	   rb.keyPress(KeyEvent.VK_ENTER);
   }
 	
   
   public void releaseEnter() {
	   
	   rb.keyPress(KeyEvent.VK_ENTER);
   }
   
   
   public void SoftAssertFalse(WebElement ele, String Msg) {
	   SoftAssert softAssert = new SoftAssert();		
	   boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		softAssert.assertFalse(value, Msg);
		softAssert.assertAll();
	}
   
   public void SoftAssertTrue(WebElement ele, String Msg) {
	   boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		softAssert.assertTrue(value, Msg);
		softAssert.assertAll();
	}
	
	//Getscreenshot methods
   
   public void getScreenShot() {
	   
	   TakesScreenshot scrShot =((TakesScreenshot)driver);
	   File  srcFile = scrShot.getScreenshotAs(OutputType.FILE);	  
       //Copy file at destination
       try {
		FileUtils.copyFile(srcFile, new File("./screenshots/results.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}

   }
   
   
   
   
   
   
   
   
   
   
   
   
   
}