package com.demo.opencart.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.demo.opencart.qa.pages.AccountsPage;
import com.demo.opencart.qa.pages.AddtoCartPage;
import com.demo.opencart.qa.pages.LoginPage;
import com.demo.opencart.qa.pages.Productinfopage;
import com.demo.opencart.qa.pages.RegisterPage;

public class basetest {

	BasePage basepage;
	public Properties prop;
	WebDriver driver;
	public LoginPage loginpage;
	public RegisterPage registerpage;
	public AccountsPage accountspage;
	public Productinfopage productinfopage;
	public AddtoCartPage addtocartpage;


	 @BeforeTest
	public void setup() {
		basepage = new BasePage();
		prop=new Properties();
		prop = basepage.init_prop();
		String browser = prop.getProperty("browser");
		driver = basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		//accountspage=new AccountsPage(driver);
	 }

	@AfterTest
	
	public void teardown() {
		//driver.quit();
	}
}
