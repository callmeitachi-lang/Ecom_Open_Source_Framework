package com.demo.opencart.qa.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.opencart.qa.base.basetest;
import com.demo.opencart.qa.constants.Constants;
import com.demo.opencart.qa.listeners.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class AccountsPageTest extends basetest {

	@BeforeClass
	public void AccountsPageSetup() {		
		accountspage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		 //loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void accountPagetitleTest() {
		String title = accountspage.getAccountsPageTittle();
		Assert.assertEquals(title, Constants.AccountsPage_Title);

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

	@Test(priority = 4)
	public void searchItemTest() {

		Assert.assertTrue(accountspage.searchBoxItemCount("IMAC"));
	}

}
