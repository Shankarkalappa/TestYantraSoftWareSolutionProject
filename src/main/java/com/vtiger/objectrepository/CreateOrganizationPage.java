package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vtiger.genericUtility.WebDriverUtility;

public class CreateOrganizationPage {

	@FindBy(css = "input[name='accountname']")
	private WebElement organizationTextField;

	@FindBy(css = "[title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getOrganizationTextField() {
		return organizationTextField;
	}
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public void createOrganizationTxtField(String organizationName) {
		organizationTextField.sendKeys(organizationName);
		saveButton.click();
	}
	public String industryTypeDropDown(String dropDownValue) {
		WebDriverUtility.select(industryDropDown, dropDownValue);
		return dropDownValue;
	}
	public void verifyTypeDropDown(WebDriver driver) {
		WebDriverUtility.click(driver, typeDropDown);
	}
}
