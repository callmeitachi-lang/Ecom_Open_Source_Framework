package com.demo.opencart.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.opencart.qa.base.basetest;
import com.demo.opencart.qa.constants.Constants;

public class loginPageTest extends basetest {

	@Test(priority = 1)
	public void forgotpasswordlinkTest() {
		
		//C:\Users\{your-username}\.cache\selenium
		// download chromedriver.exe in the above mentioned path
		Assert.assertTrue(loginpage.forgotpasswordLink());
	}

	@Test(priority = -1)
	public void homepagetitleTest() {

		String title=loginpage.LoginPageTittle();
		Assert.assertEquals(title,Constants.lOGINPAGE_TITLE);
	}

	@Test(priority = 2)
	public void dologinTest() {

	 accountspage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	// @Test(priority = 3)
	/*
	 * public void noItemCartTest() { String EmptyCartMesgPopup =
	 * loginpage.noIteminCart(); Assert.assertEquals(EmptyCartMesgPopup,
	 * constants.EmptyCart_PopUp);
	 * 
	 * }
	 */
}
