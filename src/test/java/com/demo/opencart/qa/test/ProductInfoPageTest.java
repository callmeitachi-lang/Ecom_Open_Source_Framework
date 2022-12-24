package com.demo.opencart.qa.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.opencart.qa.base.basetest;

//@Listeners(ExtentReportListener.class)

public class ProductInfoPageTest extends basetest {

	@BeforeClass
	public void ProductinfoPageSetup() {
		accountspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void SearchProductinforesultTest() {
		accountspage.searchBoxItemCount("MacBook");
		productinfopage = accountspage.SelectProductFromSearchedItem("MacBook Pro");
		Map<String, String> InfoTest = productinfopage.searchedproductMetadataDetails();

		// Brand: Apple
		// Product Code: Product 18
		// Reward Points: 800
		// Availability: Out Of Stock
		// Assert.assertTrue(true, InfoTest.put("Brand","Value"));--Tested to check
		// whether Assertions are working or not

		Assert.assertTrue(true, InfoTest.put("Brand", "Value"));
		Assert.assertTrue(true, InfoTest.put("Product Code", "Product 18"));
		Assert.assertTrue(true, InfoTest.put("Reward Points", " 800"));
		Assert.assertTrue(true, InfoTest.put("Availability", " Out Of Stock"));

	}

	@Test(priority = 2)
	public void SelectedProductHeaderTest() {
		Assert.assertEquals("MacBook Pro", productinfopage.searchedProductNameHeader());
	}

	@Test(priority = 3)
	public void addQuantityTest() {
		Assert.assertTrue(productinfopage.addQuantity());

	}

	@Test(priority = 7)
	public void addToCartTest() {
		productinfopage.addtoCart();
	}

	@Test(priority = 4)
	public void ProductImageCountTest() {
		Assert.assertEquals(4, productinfopage.productImageCount());
	}

	@Test(priority = 5)
	public void ProductinfoTest() {
		Assert.assertEquals(5, productinfopage.getSelectedProductDescription());
	}

	@Test(priority = 6)
	public void producttitleTest() {
		Assert.assertEquals("MacBook Pro", productinfopage.pageinfotitle());
	}

}
