package com.dru.qa.registration.testcases;


import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dru.qa.registration.base.Testbase;
import com.dru.qa.registration.pages.HomePage;
import com.dru.qa.registration.pages.LoginPage;
import com.dru.qa.registration.pages.UserManagmentPage;
import com.dru.qa.registration.util.Testutil;

public class UserManagementTest extends Testbase {

	LoginPage loginpage;
	HomePage homepage;
	UserManagmentPage usermanagementpage;
	Testutil testutil;
	String sheet = "usermanagement";

	public UserManagementTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initiliaze();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.selectUserScreen();
		usermanagementpage = homepage.addUser();
		usermanagementpage = new UserManagmentPage();
		testutil = new Testutil();
	}

	@DataProvider
	public Object[][] getLRMTestData() {
		Object data[][] = Testutil.getTestData(sheet);
		return data;
	}

	
	@Test(priority=1)
	public void uploadfile() throws AWTException {
	boolean status =usermanagementpage.clickUpload()	;
	Assert.assertTrue(status, "Profilel picture not updated");
	}
	
	@Test(priority = 2, dataProvider = "getLRMTestData", description = "Add new user")
	public void validateUsers(String title, String fn, String ln, String gender, String em, String num,
			String doctortype,  String qualification , String expsummary , String employeeID , String userName , 
			String LicenseType , String licnum, String consulatation , String followUps , String searchFilter , String searchRoles) {
	
		usermanagementpage.selectHonorific(title);
		usermanagementpage.enterFirsName(fn);
		usermanagementpage.enterLastName(ln);
		usermanagementpage.selectGender(gender);
		usermanagementpage.enterEmail(em);
		usermanagementpage.enterMobile(num);
		usermanagementpage.selectLanguages();
		usermanagementpage.selectDesignations();	
//     	usermanagementpage.selectDoctorType(prop.getProperty(doctotType));
		usermanagementpage.selectSpecialization();
		usermanagementpage.selectDepartments();
		usermanagementpage.enterQualification(qualification);
		usermanagementpage.enterExpSummary(expsummary);
		usermanagementpage.enterEmpID(employeeID);
		usermanagementpage.enterUserName(userName);
		usermanagementpage.selectMCIMOH(LicenseType);
		usermanagementpage.enterLicenseNum(licnum);
		usermanagementpage.enterConsultation(consulatation, followUps);
//		usermanagementpage.selectFilters(searchFilter);
//		usermanagementpage.selectRoles(searchRoles);
		usermanagementpage.addRole();

	}
	
	
	
	
 //   @AfterMethod
//	public void teardown() throws InterruptedException {
//		Thread.sleep(30);
//		driver.quit();
//	}

}
