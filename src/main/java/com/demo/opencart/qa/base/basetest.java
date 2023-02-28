package com.demo.opencart.qa.base;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.demo.opencart.qa.pages.AccountsPage;
import com.demo.opencart.qa.pages.AddtoCartPage;
import com.demo.opencart.qa.pages.LoginPage;
import com.demo.opencart.qa.pages.Productinfopage;
import com.demo.opencart.qa.pages.RegisterPage;

public class basetest {

	public BasePage basepage;

	public LoginPage loginpage;
	public AccountsPage accountspage;
	public RegisterPage registerpage;
	public Productinfopage productinfopage;
	public AddtoCartPage addtocartpage;
	public Properties prop;
	public WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setup() {
		//Method method=new Method();
		//System.out.println("The current running class is "+method.getClass());
		System.out.println("The running thread is::=> "+Thread.currentThread().getId());
		basepage = new BasePage();
		prop = new Properties();
		prop = basepage.init_prop();
		/*if (browsername != null) {
			browser = browsername;
		}*/

		driver = basepage.init_driver(prop);
		driver.get(prop.getProperty("url"));

		loginpage = new LoginPage(driver);
           
		
	}

	@AfterTest

	public void teardown() {
		driver.quit();
	}
}
