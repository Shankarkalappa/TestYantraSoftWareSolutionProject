package com.vtiger.genericUtility;

import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;

public class BaseClass {

	public WebDriver driver;
	public HomePage homepage;
	public static WebDriver sdriver;
	/**
	 *  This annotation is used to Open the Database Connection with all 
	 * necessary inputs
	 * @throws Throwable
	 */
	@BeforeSuite

	public void establishDataBaseConnection() throws Throwable {
		ExcelUtility.openWorkbook(ConstantPath.excelPath);
		FileUtility.readDataFromProperties(ConstantPath.propertiesPath); 

		DataBaseUtility.getMysqlDatabaseConnection(FileUtility.getProperties("dburl"),
				FileUtility.getProperties("dbun"), FileUtility.getProperties("dbpwd"));
	}
	/**
	 * This annotation is used to Launch the browser with all precondition
	 * @param browser
	 * @throws Throwable 
	 */
	//@Parameters("browser")
	@BeforeClass
	//public void launchBrowser(String browser) throws Throwable {
		
	public void launchBrowser() throws Throwable {
			
		
		String browser = FileUtility.getProperties("browser");
		//String browser = System.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}else {
			Reporter.log("Please Specify Browser Properly", true);
		}
	}
	/**
	 * This annotation is used to Login To Application 
	 */
	@BeforeMethod
	public void loginToApplication() {

		String url = FileUtility.getProperties("url");
		//String url = System.getProperty("url");
		String timeouts = FileUtility.getProperties("timeout");
		long timeout = JavaUtility.convertStringToLong(timeouts);

		WebDriverUtility.launchApplicationWithMaximize(driver, url, timeout);
		sdriver=driver;

		LoginPage logiPage = new LoginPage(driver);
		logiPage.loginPageAction();

	}
	/**
	 * This Annotation is used to Logout from application
	 */
	@AfterMethod
	public void logOutFromApplication() {

		homepage = new HomePage(driver);
		homepage.signOutLink(driver);
	}
	/**
	 * This annotation is used to  Close the Browser
	 */
	@AfterClass
	public void closeBrowser() {
		WebDriverUtility.quiteBrowser(driver);

	}
	/**
	 * This annotation is used to Close the DataBase Connection
	 * @throws Throwable
	 */
	@AfterSuite
	public void closeDatabaseConnection() throws Throwable {
		DataBaseUtility.closeDatabaseConnection();
		ExcelUtility.closeWorkbook();
	}
}