package com.demo.opencart.qa.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.opencart.qa.base.basetest;
import com.demo.opencart.qa.constants.Constants;

//@Listeners(ExtentReportListener.class)
public class AccountsPageTest extends basetest {

	@BeforeClass
	public void AccountsPageSetup() {
		accountspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		// loginpage.doLogin(prop.getProperty("username"),
		// prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void accountPagetitleTest() {
		String title = accountspage.getAccountsPageTittle();
		Assert.assertEquals(title, Constants.ACCOUNTSPAGE_TITLE);

	}

	@Test(priority = 2)
	public void accountsPageHeaderTest() {
		Assert.assertTrue(accountspage.getAccountsPageHeader());
	}

	@Test(priority = 3)
	public void pageheaderTest() {
		List<String> Accountheaderlist = accountspage.getPageHeaders();
		Assert.assertEquals(Accountheaderlist, Constants.pageheaderlist());

	}

	@DataProvider
	public Object[][] getData()

	{
		return new Object[][] { { "Macbook" }, { "IMAC" }, { "Apple" } };
	}

	@Test(priority = 4, dataProvider = "getData")

	public void searchItemTest(String productName) {

		Assert.assertTrue(accountspage.searchBoxItemCount(productName));
	}

}
