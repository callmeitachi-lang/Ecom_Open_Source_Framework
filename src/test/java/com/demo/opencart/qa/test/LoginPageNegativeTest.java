package com.demo.opencart.qa.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.demo.opencart.qa.base.basetest;

public class LoginPageNegativeTest extends basetest {

	// Automation is about happy path scenario
	// Allways try to create seperate classes for negative scenerio
	// Try not to automate to much on negative scenerio ,Try doing manual testing

	@DataProvider
	public Object[][] getLoginData() {

		return new Object[][] { { "test11@gmail.com", "test@123" }, { "", "" }, { "", "Kanwar@77" },
				{ "knwrpl.singh@gmail.com", "" }, { "  ", "     " } };
	}

	@Test(dataProvider = "getLoginData")
	public void checkDoLoginWithWrongCredential(String usr, String pwd) {
		loginpage.doLoginWithWrngCred(usr, pwd);
	}

}
