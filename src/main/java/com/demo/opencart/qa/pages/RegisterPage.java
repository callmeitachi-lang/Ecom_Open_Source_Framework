package com.demo.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.opencart.qa.base.BasePage;

public class RegisterPage extends BasePage {

	private By RegisterPageHeader = By.cssSelector("#content h1");
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	private By SubscribeYes = By.cssSelector(".radio-inline input[value='1']");
	private By SubscribeNo = By.cssSelector(".radio-inline input[value='0']");
	private By Policy = By.name("agree");
	private By ContinueClick = By.cssSelector(".btn.btn-primary");
	private By SucessAccountRegisterMesg=By.cssSelector("#content h1");
	private By LogOutLink=By.linkText("Logout");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public String registerPagetitle() {
		return driver.getTitle();
	}

	public boolean registerPageHeader() {
		String Header = driver.findElement(RegisterPageHeader).getText();

		if (Header.equals("Register Account")) {
			return true;
		}
		return false;

	}

	public Boolean accountCreationDetails(String firstname, String lastname, String email, String telephone,
			String password, String Subscribe)

	{
		driver.findElement(this.firstname).sendKeys(firstname);
		driver.findElement(this.lastname).sendKeys(lastname);
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(this.telephone).sendKeys(telephone);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.confirmpassword).sendKeys(password);
		if (Subscribe.equals("yes")) {
			driver.findElement(SubscribeYes).click();} 
		else {driver.findElement(SubscribeNo).click();
		}
		driver.findElement(Policy).click();
		driver.findElement(ContinueClick).click();


		if (driver.findElement(SucessAccountRegisterMesg).getText().contains("Your Account Has Been Created!")) {
			driver.findElement(LogOutLink).click();

			return true;
		}
		return false;

	}

}
