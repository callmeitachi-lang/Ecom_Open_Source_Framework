package com.demo.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.opencart.qa.base.BasePage;
import com.demo.opencart.qa.utils.ElementUtil;

public class AccountsPage extends BasePage {
	private WebDriver driver;
	ElementUtil eutil;       

	// Creating By locators
	private By AccountsPageHeader = By.linkText("Your Store");
	private By PageHeaders = By.cssSelector("#content h2");
	private By SearchBox = By.cssSelector("#search [type='text']");
	private By ItemCount=By.cssSelector(".caption a");
	private By SearchButtn = By.cssSelector(".input-group-btn [type='button']");
    private By SearchfromProductName=By.cssSelector(".caption a");
	// Creating class constructor

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eutil=new ElementUtil(driver);
	}

	// Creating Page Actions

	public String getAccountsPageTittle() {
		

		return driver.getTitle();

	}

	public boolean getAccountsPageHeader() {
		
		return eutil.doIsDisplayed(AccountsPageHeader);
	}

	public List<String> getPageHeaders() {
		List<String> GetHeaderList = new ArrayList<String>();
		List<WebElement> HeaderList = driver.findElements(PageHeaders);
		for (WebElement e : HeaderList) {
			System.out.println(e.getText());
			GetHeaderList.add(e.getText());
		}
		return GetHeaderList;
	}

	
	public boolean searchBoxItemCount(String productname)
	{
		eutil.getElement(SearchBox).sendKeys(productname);
         eutil.doClick(SearchButtn);
         eutil.getElement(SearchBox).clear();
		if(
eutil.getElements(ItemCount).size()>0)
		{
			return true;
		}
		return false;
	}
	
	public Productinfopage SelectProductFromSearchedItem(String productname)
	{
		List<WebElement> SearchedProduct=eutil.getElements(SearchfromProductName);
	for(WebElement e:SearchedProduct)
	       if(e.getText().equals(productname))
	       {
	    	   e.click();
	    	   break;
	       }
	return new Productinfopage(driver);
	}
	
	
	
	
	
	
	
	
	
}
