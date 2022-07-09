package com.vitiger.createContact;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.genericUtility.BaseClass;
import com.vtiger.genericUtility.ExcelUtility;
import com.vtiger.genericUtility.FileUtility;
import com.vtiger.objectrepository.ContactInformationPage;
import com.vtiger.objectrepository.ContactPage;
import com.vtiger.objectrepository.ContactsAndActionPage;
import com.vtiger.objectrepository.CreateNewContactPage;
import com.vtiger.objectrepository.HomePage;

public class TC_01_CreateContactTest extends BaseClass{
	@Test
	public void createContact() {

		HomePage homepage = new HomePage(driver);
		homepage.getContactLink().click();

		ContactPage contactpage = new ContactPage(driver);
		contactpage.getCreateContactIcon().click();

		String sheetName = FileUtility.getProperties("sheetname");
		String firstName=ExcelUtility.readData(sheetName, 7, 7);

		CreateNewContactPage createcontactpage= new CreateNewContactPage(driver);
		createcontactpage.getFirstNameTxtField().sendKeys(firstName);
		createcontactpage.getSaveButton().click();

		String actualAlertPopUpText = createcontactpage.verifyAlertPopUpNotification(driver);	


		String alertPopUpText = ExcelUtility.readData(sheetName, 8, 6);
		if (actualAlertPopUpText.equals(alertPopUpText)) {
			System.out.println("PASS:: AlertPopUp Appear With Proper Error Message");
		} else {
			System.out.println("FAIL:: AlertPopUp Not Appear With Proper Error Message");
		}
	}

	@Test
	public void createContactWithMandatoryField() {

		HomePage homepage = new HomePage(driver);
		homepage.getContactLink().click();

		ContactPage contactpage = new ContactPage(driver);
		contactpage.getCreateContactIcon().click();

		String sheetName = FileUtility.getProperties("sheetname");
		String lastName=ExcelUtility.readData(sheetName, 21, 4);

		CreateNewContactPage createcontactpage= new CreateNewContactPage(driver);
		createcontactpage.getLastNameTxtField().sendKeys(lastName);
		createcontactpage.getReportsLookUpIcon().click();
		createcontactpage.switchToChildWindowContacts(driver, lastName);

		ContactsAndActionPage contactsandactionpage = new ContactsAndActionPage(driver);
		contactsandactionpage.getContactList().click();
		String partialUrl=ExcelUtility.readData(sheetName, 21, 7);

		contactsandactionpage.switchToCurrentParentPage(driver, partialUrl);
		createcontactpage.getSaveButton().click();

		ContactInformationPage contactInfoPage = new ContactInformationPage(driver);
		String actualTitle = contactInfoPage.getContactInfoTitle().getText();
		String expectedTitle =ExcelUtility.readData(sheetName, 23, 6);
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		Reporter.log("Pass:: Contact Information Updated",true);
	}
}