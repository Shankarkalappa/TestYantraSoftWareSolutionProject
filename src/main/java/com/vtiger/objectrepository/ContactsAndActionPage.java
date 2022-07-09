package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtility.WebDriverUtility;

public class ContactsAndActionPage {
	@FindBy(xpath = "//td[text()=' Administrator']/preceding-sibling::td/a")
	private WebElement contactList;

	public WebElement getContactList() {
		return contactList;
	}
	public ContactsAndActionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void switchToCurrentParentPage(WebDriver driver,String partilaUrltext) {
		WebDriverUtility.switchToWindow(driver, partilaUrltext);
	}
}

