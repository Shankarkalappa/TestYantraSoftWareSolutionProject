package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformation {
	@FindBy(xpath = "//span[@class='dvHeaderText']/..")
	private WebElement organizationText;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement dropdownText;
	
	public WebElement getDropdownText() {
		return dropdownText;
	}
	public WebElement getOrganizationText() {
		return organizationText;
	}
	public OrganizationInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String verifySucessfullMessage() {
		 return organizationText.getText();
	}
	public String verifyDropDownText() {
		 return dropdownText.getText();
	}
	
}
