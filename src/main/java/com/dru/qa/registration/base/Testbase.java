package com.dru.qa.registration.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dru.qa.registration.util.Testutil;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	FileInputStream file = null;

	public Testbase() {

		prop = new Properties();

		try {
			file = new FileInputStream(
					"E:/LRMRegistration/src/main/java/com/dru/qa/registration/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initiliaze() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Testutil.page_load));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.implict_wait));
		driver.get(prop.getProperty("url"));

	}

}
