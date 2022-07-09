package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement createOrganiztionIcon;

	public WebElement getCreateOrganiztionIcon() {
		return createOrganiztionIcon;
	}

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void createOrganizationIcon() {
		createOrganiztionIcon.click();
	}
}
