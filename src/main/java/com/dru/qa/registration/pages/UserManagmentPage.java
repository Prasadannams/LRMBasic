package com.dru.qa.registration.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dru.qa.registration.helpers.Helpers;

public class UserManagmentPage extends Helpers {

	Helpers helpers;

	@FindBy(xpath = ("//iframe[@class='iframe-width ng-star-inserted']"))
	WebElement frmaeUser;

	@FindBy(xpath = ("//select[@formcontrolname='honorificNm']"))
	WebElement honorific;

	@FindBy(xpath = ("//input[@formcontrolname='firstNm']"))
	WebElement userName;

	@FindBy(xpath = ("//input[@formcontrolname='lastNm']"))
	WebElement lastName;

	@FindBy(xpath = ("//input[@formcontrolname='emailId']"))
	WebElement email;

	@FindBy(xpath = ("//input[@formcontrolname='mobileNo']"))
	WebElement mobile;

	@FindBy(xpath = ("//ng-select[@bindlabel='languageNm']"))
	WebElement selectlanguages;

	@FindBy(xpath = ("//div[@class='ng-option ng-star-inserted']"))
	List<WebElement> languages;

	@FindBy(xpath = ("//ng-select[@bindlabel='designation']"))
	WebElement selectdesignation;

	@FindBy(xpath = ("//span[@class='ng-option-label ng-star-inserted']"))
	List<WebElement> designations;

	@FindBy(xpath = ("//ng-select[@bindlabel='deptNm']"))
	WebElement selectDepartment;

	@FindBy(xpath = ("//div[@class='ng-option ng-star-inserted']"))
	List<WebElement> departments;

	@FindBy(xpath = ("//ng-select[@bindlabel='specialityNm']"))
	WebElement selectSpecialization;

	@FindBy(xpath = ("//div[@class='ng-option ng-star-inserted']"))
	List<WebElement> specializations;
	
	@FindBy(xpath=("//input[@formcontrolname='empCode']"))
	WebElement empID;
	
	@FindBy(xpath=("//input[@formcontrolname='userNm']"))
	WebElement usName;
	
	@FindBy(xpath=("//input[@formcontrolname='empQualification']"))
	WebElement empQualification;
	
	@FindBy(xpath=("//input[@formcontrolname='experienceSummary']"))
	WebElement expSummary;

	@FindBy(xpath=("//label[@for='mciNumber']"))
	WebElement numMCI;

	@FindBy(xpath=("//label[@for='mohNumber']"))
	WebElement numMOH;
	
	@FindBy(xpath=("//input[@formcontrolname='doctorRegisterNo']"))
	WebElement licenseNum;

	@FindBy(xpath=("//input[@formcontrolname='feeValidDays']"))
	WebElement consValidty;

	@FindBy(xpath=("//input[@formcontrolname='feeValidVisits']"))
	WebElement numOfFollowUps;
	
	@FindBy(xpath=("//div[@class='col-sm-4 p-t-8 p-b-8 item-align-center-start']//child::input"))
	WebElement enterRoles;

	@FindBy(xpath="//select[@formcontrolname='role']")
	WebElement searchFilters;

	@FindBy(xpath=("//select[@formcontrolname='role']/option"))
	List<WebElement> searchRoles;
	
	@FindBy(xpath=("//span[text()='Add']"))
	List<WebElement> addRoles;
	
	@FindBy(xpath=("//input[@class='browse-btn']"))
	WebElement browseUpload;
	
    @FindBy(xpath=("//button[@class='btn-txticon']"))
    WebElement editFile;
	
	// Initialize PageFatory
	public UserManagmentPage() {

		PageFactory.initElements(driver, this);
		helpers = new Helpers();
	}

	// Action Methods

	public void selectHonorific(String title) {
		Select select = new Select(honorific);
		select.selectByVisibleText(title);
	}

	public void enterFirsName(String fn) {
		helpers.sendKeysToWebElement(userName, fn);
	}

	public void enterLastName(String ln) {
		helpers.sendKeysToWebElement(lastName, ln);
	}

	public void selectGender(String gender) {
		driver.findElement(By.xpath("//li[@class='radio m-r-48']/input[@value='" + gender + "']"));
	}

	public void enterEmail(String em) {
		helpers.sendKeysToWebElement(email, em);
	}

	public void enterMobile(String num) {
		helpers.sendKeysToWebElement(mobile, num);
	}

	public void selectLanguages() {
		helpers.performClick(selectlanguages);
		try {
			ListOfWebElements(languages);
		} catch (Exception e) {
		}
	}

	public void selectDesignations() {
		helpers.performClick(selectdesignation);
		for (int i = 0; i < designations.size(); i++) {
			designations.get(i).getText();
			helpers.scrollIntoView(designations.get(i));
			helpers.jsClick(designations.get(i));
			helpers.performClick(selectdesignation);
			helpers.performClick(selectdesignation);
			
			
		}
		helpers.actionTab();
	}

	public void selectDoctorType(String doctype) {
		driver.findElement(By.xpath("//label[@for='" + doctype + "']")).click();
	}

	public void selectSpecialization() {
		helpers.performClick(selectSpecialization);
		for (int i = 0; i < specializations.size(); i++) {
			specializations.get(i).getText();
			helpers.scrollIntoView(specializations.get(i));
			helpers.jsClick(specializations.get(i));
			helpers.performClick(selectSpecialization);
			helpers.performClick(selectSpecialization);

		}
	}

	public void selectDepartments() {
		helpers.jsClick(selectDepartment);
		for (int i = 0; i < departments.size(); i++) {
			departments.get(i).getText();
			helpers.scrollIntoView(departments.get(i));
			helpers.performClick(departments.get(i));
			helpers.performClick(selectDepartment);

		}

	}
	public void enterQualification(String qualification) {

		helpers.sendKeysToWebElement(empQualification, qualification);
	}
	
	public void enterExpSummary(String expsummary) {

		helpers.sendKeysToWebElement(expSummary, expsummary);
	}
	
	public void enterEmpID(String employeeID) {

		helpers.sendKeysToWebElement(empID, employeeID);
	}

	public void enterUserName(String userName) {

		helpers.sendKeysToWebElement(usName, userName);
	}
	
	public void selectMCIMOH(String MCI) {
		if(MCI.equalsIgnoreCase("mciNumber")) {
			numMCI.click();
		}else {
			numMOH.click();
		}
	}

	public void enterLicenseNum(String licNum) {
		helpers.sendKeysToWebElement(licenseNum, licNum);
	}
	
	public void enterConsultation(String consultation , String followups) {
		helpers.sendKeysToWebElement(consValidty, consultation);
		helpers.sendKeysToWebElement(numOfFollowUps, followups);
	}
	
//	public void selectFilters(String FilterValue) {
//		helpers.explicitWait(20, frmaeUser);
//		helpers.switchToFrame(frmaeUser);
//		Select select= new Select(searchFilters);
//        select.selectByVisibleText(FilterValue);
//        helpers.implicitWait(10);
//		
//	}
//	
//	public void selectRoles(String roleNames) {
//		for(WebElement roleName : searchRoles) {
//			String roleValue = roleName.getText();
//			if(roleValue.equalsIgnoreCase(roleNames)) {
//				roleName.click();
//			}
//		}
	
	
	public void addRole() {

		for (WebElement element : addRoles) {
			helpers.scrollIntoView(element);
			helpers.jsClick(element);
		}
	}
	
	
	public boolean clickUpload() throws AWTException {
		helpers.jsClick(browseUpload);
		//To copy the path in clipBoard
		StringSelection ss = new StringSelection("C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot (7).png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);	
        helpers.pressControl();
		helpers.pressV();
		helpers.ReleaseControl();
		helpers.releaseV();
		helpers.pressEnter();
		helpers.releaseEnter();	
		helpers.getScreenShot();
		return editFile.isDisplayed();
	}

	
	
	
	
	
	
	
	
	
}
