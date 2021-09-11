package com.demo.opencart.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.opencart.qa.base.BasePage;

public class Productinfopage extends BasePage {

	// By
	private WebDriver driver;
	private By ProductNameHeader = By.cssSelector("#content h1");
	private By ProductMetaDeta = By.cssSelector("#content  .list-unstyled:nth-of-type(1) li");
	private By ProductPrice = By.cssSelector("#content  .list-unstyled:nth-of-type(2) li");
	private By ProductQuantity = By.cssSelector("[name=quantity]");
	private By AddtoCartProduct = By.cssSelector(".form-group #button-cart");
	private By SuccessMesgaddtoCart = By.cssSelector(".alert.alert-success.alert-dismissible a+a");
	private By ProductImageCount = By.cssSelector("#content img");
	private By ProductBasicInformation = By.cssSelector(".cpt_product_description b");
	private By ItemCart = By.xpath("//button[@type='button' and @data-toggle='dropdown']");
	private By ViewCart = By.xpath("//strong[contains(text(),'View Cart')]");

	// Page Constructor

	public Productinfopage(WebDriver driver) {
		this.driver = driver;
	}

	// page Actions

	public String searchedProductNameHeader()

	{

		return driver.findElement(ProductNameHeader).getText();
	}

	public String pageinfotitle() {
		return driver.getTitle().trim();

	}

	public Map<String, String> searchedproductMetadataDetails() {

		Map<String, String> productlist = new HashMap<String, String>();
		List<WebElement> metadatalist = driver.findElements(ProductMetaDeta);
		for (WebElement e : metadatalist) {
			System.out.println(e.getText());
			productlist.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}
		List<WebElement> Pricelist = driver.findElements(ProductPrice);
		productlist.put("Price", Pricelist.get(0).toString());

		return productlist;

	}

	public int productImageCount() {
		return driver.findElements(ProductImageCount).size();
	}

	public int getSelectedProductDescription() {
		List<WebElement> productinfo = driver.findElements(ProductBasicInformation);

		productinfo.stream().forEach(e -> System.out.println(e.getText()));
		return productinfo.size();
	}

	public boolean addQuantity() {
		if (driver.findElements(ProductQuantity).size() == 1) {
			return true;
		} else
			return false;
	}

	public List<String> addtoCart() {
		driver.findElement(AddtoCartProduct).click();
		List<String> list = new ArrayList<>();
		List<WebElement> SuccesfulMesg = driver.findElements(SuccessMesgaddtoCart);
		for (WebElement e : SuccesfulMesg) {
			System.out.println(e.getText());
			list.add(e.getText());
		}
		return list;
	}

	public AddtoCartPage CartClick() {
		driver.findElement(ItemCart).click();
		driver.findElement(ViewCart).click();
		return new AddtoCartPage(driver);
	}

}
