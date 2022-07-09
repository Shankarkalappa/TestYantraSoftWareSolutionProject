package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtility.WebDriverUtility;

public class CreateNewContactPage {
	@FindBy(name = "firstname")
	private WebElement firstNameTxtField;

	@FindBy(css = "input[class='crmButton small save']")
	private WebElement saveButton;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTxtField;
	
	@FindBy(xpath = "//td[text()='Assistant ']/..//img[@alt='Select']")
	private WebElement reportsLookUpIcon;

	public WebElement getReportsLookUpIcon() {
		return reportsLookUpIcon;
	}

	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}

	public WebElement getFirstNameTxtField() {
		return firstNameTxtField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public CreateNewContactPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public String verifyAlertPopUpNotification(WebDriver driver) {
		String alerTxt = WebDriverUtility.getAlertPopUpText(driver);
		driver.switchTo().defaultContent();
		return alerTxt; 
	}
	public void switchToChildWindowContacts(WebDriver driver, String partialText) {
		WebDriverUtility.switchToWindow(partialText, driver);
	}
}
