package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vtiger.genericUtility.WebDriverUtility;

public class HomePage {
	@FindBy(xpath = "//td[@class='tabUnSelected']/..//a[text()='Organizations']")
	private WebElement organizationLink;

	@FindBy(xpath  = "//span[@class='userName']/../..//img[contains(@src,'user')]")
	private WebElement UserImage;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactLink;
	
	@FindBy(linkText ="More")
	private WebElement moreDropDown;

	public WebElement getMoreDropDown() {
		return moreDropDown;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getUserImage() {
		return UserImage;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void organizationLink() {
		organizationLink.click();
	}
	
	public void moreDropdownLink(WebDriver driver) {
		WebDriverUtility.moveToElement(driver, moreDropDown);
		
	}
	public void signOutLink(WebDriver driver) {
		WebDriverUtility.moveToElement(driver, UserImage);
		signOutLink.click();
	}
}
