package com.demo.opencart.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.opencart.qa.base.basetest;
import com.demo.opencart.qa.constants.Constants;
import com.demo.opencart.qa.pages.AccountsPage;

public class loginPageTest extends basetest {

	@Test(priority = 1)
	public void forgotpasswordlinkTest() {
		Assert.assertTrue(loginpage.forgotpasswordLink());
	}

	@Test(priority = 0)
	public void homepagetitleTest() {
		String Tittle = loginpage.LoginPageTittle();
		Assert.assertEquals(Tittle, Constants.LoginPage_Title);

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
