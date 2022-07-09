package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy(css = "img[alt='Create Contact...']")
	private WebElement createContactIcon;

	public WebElement getCreateContactIcon() {
		return createContactIcon;
	}
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickCreateContactIcon() {
		createContactIcon.click();
	}
}
