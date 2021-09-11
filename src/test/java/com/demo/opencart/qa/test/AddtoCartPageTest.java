package com.demo.opencart.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demo.opencart.qa.base.basetest;
import com.demo.opencart.qa.constants.Constants;

public class AddtoCartPageTest extends basetest {

	@BeforeClass
	public void AddtoCartSetup() {
		accountspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void shoppingCartItemTest() {
		accountspage.searchBoxItemCount("MacBook");
		productinfopage = accountspage.SelectProductFromSearchedItem("MacBook Pro");
		productinfopage.addQuantity();
		productinfopage.addtoCart();
		addtocartpage = productinfopage.CartClick();
		Assert.assertTrue(addtocartpage.shoppingCartDetails());
		addtocartpage.EstimatedshippingDetails();
		addtocartpage.preferredShippingMethod();
		/*
		 * MacBook Pro *** Reward Points: 9600 Product 18
		 */

	}

	@Test(priority = 2)
	public void addtoCartPagetitleTest() {
		Assert.assertEquals(addtocartpage.addtoCartPageTitle(), Constants.ShoppingCart_Title);
	}

	@Test(priority = 3)
	public void cartTotalTest() {
		Assert.assertTrue(addtocartpage.cartTotal());
	}

}
