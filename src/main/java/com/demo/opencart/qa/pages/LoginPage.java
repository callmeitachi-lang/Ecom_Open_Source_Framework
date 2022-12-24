package com.demo.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.opencart.qa.base.BasePage;
import com.demo.opencart.qa.utils.ElementUtil;
import com.demo.opencart.qa.utils.JavaScriptUtil;

public class LoginPage extends BasePage {
	// Step 1--Creating By locators

	private WebDriver driver;
	ElementUtil eutil;
	private JavaScriptUtil jsScript;
	private By ForgotPasswordLink = By.linkText("Forgotten Password");
	private By UserName = By.id("input-email");
	private By password = By.id("input-password");
	private By LoginButton = By.cssSelector("[type=submit]");
	private By registerlink = By.linkText("Register");
	private By errorMesg = By.cssSelector(".alert.alert-danger.alert-dismissible");
	// private By ZeroItem =By.cssSelector("#cart [type=button]");
	// private By CartEmptyMesg = By.linkText("Your shopping cart is empty!");

	// Step 2--Creating class constuctor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
		jsScript = new JavaScriptUtil(driver);
	}

	// Step-2 Creating Page Actions

	public String LoginPageTittle() {

		return driver.getTitle();

	}

	public boolean forgotpasswordLink() {

		return eutil.doIsDisplayed(ForgotPasswordLink);
	}

	public AccountsPage doLogin(String un, String pw) {

		eutil.doActionsSendKeys(UserName, un);
		eutil.doActionsSendKeys(password, pw);
		eutil.doClick(LoginButton);
		return new AccountsPage(driver);

	}
	/*
	 * public String noIteminCart() { driver.findElement(ZeroItem).click(); return
	 * driver.findElement(CartEmptyMesg).getText(); }
	 */

	public boolean doLoginWithWrngCred(String usr, String pwd) {
		eutil.doSendKeys(UserName, usr);
		eutil.doSendKeys(password, pwd);
		eutil.doClick(LoginButton);
		if (eutil.doGetText(errorMesg).contains(" Warning: No match for E-Mail Address and/or Password.")) {
			return false;
		}
		return true;
	}

	public RegisterPage registerlink() {/*
		WebDriverWait wb = new WebDriverWait(driver, 15);
		wb.until(ExpectedConditions.visibilityOfElementLocated(registerlink));
		driver.findElement(registerlink).click();
*/
		     eutil.getElement(registerlink).click();
		
		return new RegisterPage(driver);

	}

}
