package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtility.FileUtility;

public class LoginPage {
	@FindBy(name="user_name")
	private WebElement userNameTextField;

	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		
		//PageFactory.initElements(driver, LoginPage.class);
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	/**
	 * This method is used to Enter the UserName,Password and click the Login Page 
	 */
	public void loginPageAction() {
		userNameTextField.sendKeys(FileUtility.getProperties("username"));
		passwordTextField.sendKeys(FileUtility.getProperties("password"));
		loginButton.click();
	}
}
	
