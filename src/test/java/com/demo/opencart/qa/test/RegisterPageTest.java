package com.demo.opencart.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.opencart.qa.base.basetest;
import com.demo.opencart.qa.constants.Constants;
import com.demo.opencart.qa.utils.excelutil;

public class RegisterPageTest extends basetest {

	@BeforeClass
	public void RegisterPageSetup() {

		registerpage = loginpage.registerlink();
	}

	@Test(priority = 1)
	public void registerPagetitleTest() {

		Assert.assertEquals(registerpage.registerPagetitle(), Constants.Register_Account_Title);

	}

	@Test(priority = 2)
	public void registerPageHeaderTest() {
		Assert.assertTrue(registerpage.registerPageHeader());
	}

	//Delta Approach---->Its allways better to use hard coded value using in data provider rather than using in excel
	// ex: u just need to delete 2-3 users after registering them , than maintaining 50-60 plus data and getting them deleted later
	@DataProvider
	public Object[][] getRegisterData() {
		Object[][] data = excelutil.getTestData("registration");
		return data;
	}

	@DataProvider
	public Object[][] fillData()
	{
		return new Object[][]{{"kanwar","singh","helllo@gmail.com","7843929847","googly@123","yes"},
			
			{"gk","singh","helllooo@gmail.com","7843929847","googly@123","yes"}};
	}
	
	
	@Test(priority = 3, dataProvider = "fillData")
	public void accountCreationTest(String firstname, String lastname, String email, String telephone, String password,
			String Subscribe) {

		// registerpage.accountCreationDetails("dev", "singh", "xyqaqa@gmail.com",
		// "9874515891", "dev@123", "yes");
		registerpage.accountCreationDetails(firstname, lastname, email, telephone, password, Subscribe);
		loginpage.registerlink();

	}

}
