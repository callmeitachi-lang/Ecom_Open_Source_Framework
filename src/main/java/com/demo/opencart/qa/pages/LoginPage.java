package com.demo.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.opencart.qa.base.BasePage;

public class LoginPage extends BasePage {
	// Step 1--Creating By locators

	private WebDriver driver;

	private By ForgotPasswordLink = By.linkText("Forgotten Password");
	private By UserName = By.id("input-email");
	private By password = By.id("input-password");
	private By LoginButton = By.cssSelector("[type=submit]");
	private By registerlink = By.linkText("Register");
	// private By ZeroItem =By.cssSelector("#cart [type=button]");
	// private By CartEmptyMesg = By.linkText("Your shopping cart is empty!");

	// Step 2--Creating class constuctor

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// Step-2 Creating Page Actions

	public String LoginPageTittle() {

		return driver.getTitle();
	}

	public boolean forgotpasswordLink() {
		return driver.findElement(ForgotPasswordLink).isDisplayed();
	}

	public AccountsPage doLogin(String un, String pw) {

		driver.findElement(UserName).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(LoginButton).click();
		return new AccountsPage(driver);

	}
	/*
	 * public String noIteminCart() { driver.findElement(ZeroItem).click(); return
	 * driver.findElement(CartEmptyMesg).getText();
	 * }
	 */

	public RegisterPage registerlink() {
		WebDriverWait wb=new WebDriverWait(driver, 15);
		wb.until(ExpectedConditions.visibilityOfElementLocated(registerlink));
		driver.findElement(registerlink).click();

		return new RegisterPage(driver);

	}

}
