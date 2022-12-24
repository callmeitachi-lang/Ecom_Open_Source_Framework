package com.demo.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.opencart.qa.base.BasePage;
import com.demo.opencart.qa.utils.ElementUtil;

public class AddtoCartPage extends BasePage {
	private WebDriver driver;
	private ElementUtil eutil;
	private By CartDetails = By
			.xpath("//a[contains(text(),'MacBook Pro')]//ancestor::div[@id='content']//thead//..//tbody//td");

	private By shippingTax = By.xpath("(//i[@class='fa fa-caret-down'])[3]");
	private By selectCountry = By.xpath("//select[@id='input-country']//option");
	private By RegionorState = By.xpath("//select[@id='input-zone']//option");
	private By GetQuote = By.xpath("//button[@id='button-quote']");
	private By CheckOut = By.xpath("//a[contains(text(),'Checkout')]");
	private By FlatRate = By.xpath("//input[@type='radio']");
	private By ApplyShipping = By.xpath("//input[@type='button' and @value='Apply Shipping']");
	private By ShoppingCart_Total = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]");
	private By Cart_total = By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[1]/td[2]");

	public AddtoCartPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);

	}

	public boolean shoppingCartDetails() {
		List<String> list = new ArrayList<String>();

		List<WebElement> CartList = eutil.getElements(CartDetails);

		for (WebElement e : CartList) {

			System.out.println(e.getText());
			list.add(e.getText());
			if (e.getText().contains("MacBook Pro")) {
				return true;
			}

		}
		return false;
	}

	public void EstimatedshippingDetails() {
		eutil.doClick(shippingTax);
		List<WebElement> countryList=eutil.getElements(selectCountry);
		for (WebElement e : countryList) {
			if (e.getText().equalsIgnoreCase("India")) {
				e.click();

			}
		}
		List<WebElement> stateList =eutil.getElements(RegionorState);
		for (WebElement e1 : stateList) {
			if (e1.getText().equalsIgnoreCase("Andhra Pradesh")) {
				e1.click();
			}
		}

		// Select select1=new Select(driver.findElement(RegionorState));
		// select1.selectByValue("1476");
		eutil.doClick(GetQuote);
	}

	public void preferredShippingMethod() {
		eutil.doClick(FlatRate);
		eutil.doClick(ApplyShipping);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eutil.doClick(CheckOut);
	}

	public String addtoCartPageTitle() {
		return driver.getTitle();
	}

	public boolean cartTotal() {
		String TotalCartAmount = eutil.doGetText(Cart_total);
		String Shopping_Cart_amount = eutil.doGetText(ShoppingCart_Total);
		System.out.println(TotalCartAmount);
		System.out.println(Shopping_Cart_amount);

		if (TotalCartAmount.trim().equals(Shopping_Cart_amount.trim())) {
			return true;
		}
		return false;
	}

}
