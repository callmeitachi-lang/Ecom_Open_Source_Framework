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

	@DataProvider
	public Object[][] getRegisterData() {
		Object[][] data = excelutil.getTestData("registration");
		return data;
	}

	@Test(priority = 3, dataProvider = "getRegisterData")
	public void accountCreationTest(String firstname, String lastname, String email, String telephone, String password,
			String Subscribe) {

		// registerpage.accountCreationDetails("dev", "singh", "xyqaqa@gmail.com",
		// "9874515891", "dev@123", "yes");
		registerpage.accountCreationDetails(firstname, lastname, email, telephone, password, Subscribe);
		loginpage.registerlink();

	}

}
