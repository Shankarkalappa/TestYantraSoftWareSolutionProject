package com.vtiger.createOrganization;

import org.testng.annotations.Test;
import com.vtiger.genericUtility.BaseClass;
import com.vtiger.genericUtility.ExcelUtility;
import com.vtiger.genericUtility.FileUtility;
import com.vtiger.genericUtility.JavaUtility;
import com.vtiger.objectrepository.CreateOrganizationPage;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.OrganizationInformation;
import com.vtiger.objectrepository.OrganizationPage;

public class TC_01_CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganization() {	
		HomePage homepage = new HomePage(driver);
		String sheetName = FileUtility.getProperties("sheetname");

		int randomNumber = JavaUtility.randomNumber(1000);
		String organizationName = ExcelUtility.readData(sheetName, 33, 4)+randomNumber;


		homepage.organizationLink();

		OrganizationPage orgPage= new OrganizationPage(driver);
		orgPage.createOrganizationIcon();


		CreateOrganizationPage createOrgPage= new CreateOrganizationPage(driver);
		createOrgPage.createOrganizationTxtField(organizationName+randomNumber);

		OrganizationInformation orgInformation= new OrganizationInformation(driver);
		String actualSucessfullMsg = orgInformation.verifySucessfullMessage();

		if (actualSucessfullMsg.contains(organizationName)) {

			System.out.println(organizationName+"= Organization Created Sucessfully");
		}else {
			System.out.println(organizationName+"= Organization Not Created Sucessfully");
		}
	}

	@Test
	public void createOrganizationWithIndustryType() {

		HomePage homepage = new HomePage(driver);
		String sheetName = FileUtility.getProperties("sheetname");
		int randomNumber = JavaUtility.randomNumber(1000);
		String organizationName = ExcelUtility.readData(sheetName, 33, 4)+randomNumber;


		homepage.organizationLink();

		OrganizationPage orgPage= new OrganizationPage(driver);
		orgPage.createOrganizationIcon();

		CreateOrganizationPage createOrgPage= new CreateOrganizationPage(driver);
		createOrgPage.createOrganizationTxtField(organizationName+randomNumber);
		String industryDropDownValue = ExcelUtility.readData(sheetName, 44,6);
		String expectedIndustryTpye = createOrgPage.industryTypeDropDown(industryDropDownValue);

		OrganizationInformation orgInformation= new OrganizationInformation(driver);
		String actualSucessfullMsg = orgInformation.verifySucessfullMessage();

		if (actualSucessfullMsg.contains(organizationName)) {

			System.out.println(organizationName+"= Organization Created Sucessfully");
		}else {
			System.out.println(organizationName+"= Organization Not Created Sucessfully");
		}

		String actualIndustryType = orgInformation.verifyDropDownText();
		if (actualIndustryType.equals(expectedIndustryTpye)){
			System.out.println(expectedIndustryTpye+"=  Industry Verified Sucessfully");
		} else {
			System.out.println(expectedIndustryTpye+"=  Industry is not Verified Sucessfully");
		}
	}

	@Test
	public void dropDownListAppear() {

		HomePage homepage = new HomePage(driver);


		homepage.organizationLink();

		OrganizationPage orgPage= new OrganizationPage(driver);
		orgPage.createOrganizationIcon();
		CreateOrganizationPage createOrgPage= new CreateOrganizationPage(driver);
		createOrgPage.verifyTypeDropDown(driver);	
	}
}
