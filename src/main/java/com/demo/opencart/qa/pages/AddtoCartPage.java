package com.demo.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.opencart.qa.base.BasePage;

public class AddtoCartPage extends BasePage {
	private WebDriver driver;

	private By CartDetails = By.xpath(
			"//a[contains(text(),'MacBook Pro')]//ancestor::div[@id='content']//thead//..//tbody//td");

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
	}

	public boolean shoppingCartDetails() {
		List<String> list = new ArrayList<String>();
		List<WebElement> CartList = driver.findElements(CartDetails);

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
		driver.findElement(shippingTax).click();
		List<WebElement> countryList = driver.findElements(selectCountry);
		for (WebElement e : countryList) {
			if (e.getText().equalsIgnoreCase("India")) {
				e.click();

			}
		}
		List<WebElement> stateList = driver.findElements(RegionorState);
		for (WebElement e1 : stateList) {
			if (e1.getText().equalsIgnoreCase("Andhra Pradesh")) {
				e1.click();
			}
		}

		// Select select1=new Select(driver.findElement(RegionorState));
		// select1.selectByValue("1476");
		driver.findElement(GetQuote).click();
	}

	public void preferredShippingMethod() {
		driver.findElement(FlatRate).click();
		driver.findElement(ApplyShipping).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(CheckOut).click();
	}

	public String addtoCartPageTitle() {
		return driver.getTitle();
	}

	public boolean cartTotal() {
		String TotalCartAmount = driver.findElement(Cart_total).getText();
		String Shopping_Cart_amount = driver.findElement(ShoppingCart_Total).getText();
System.out.println(TotalCartAmount);
System.out.println(Shopping_Cart_amount);

if (TotalCartAmount.trim() == Shopping_Cart_amount.trim()) {
			return true;
		}
		return false;
	}

}
