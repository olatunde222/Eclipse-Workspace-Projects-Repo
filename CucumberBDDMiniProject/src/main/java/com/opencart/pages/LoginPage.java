package com.opencart.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	//Driver
	private WebDriver driver;

	//Locators method -1
	@FindBy(name = "email")
	private WebElement emailInputLocator;
	@FindBy(name = "password")
	private WebElement passwordInputLocator;
	@FindBy(id = "input-password")
	private WebElement loginButtonLocator;
	@FindBy(linkText = "Forgotten password")
	private WebElement forgotPasswordLocator;
	@FindBy(linkText = "Logout")
	private WebElement logoutButtonLocator;
	
	
	//Locators method -2
//	private By emailInputLocator = By.name("email");
//	private By passwordInputLocator = By.name("password");
//	private By loginButtonLocator = By.id("input-password");
//	private By forgotPasswordLocator = By.linkText("Forgotten password");
//	private By logoutButtonLocator = By.linkText("Logout");
	
	
	//Constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Methods/Actions
	public void enterEmail(String email) {
		emailInputLocator.sendKeys(email);
	}
	public void enterPassword(String password) {
		emailInputLocator.sendKeys(password);
	}
	public void clickLoginBtn() {
		loginButtonLocator.click();
	}
	public void clickForgottenPassword() {
		forgotPasswordLocator.click();
	}
	public boolean checkForgottenPasswordLink() {
		return forgotPasswordLocator.isDisplayed();
	}
	public void clickLogoutBtn() {
		logoutButtonLocator.click();
	}
	public boolean checkLogoutLink() {
		return logoutButtonLocator.isDisplayed();
	}
	
	public void login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLoginBtn();
	}
	
	public String getForgotPwdPageUrl() {
		String forgotpwdPageUrl = driver.getCurrentUrl();
		return forgotpwdPageUrl;
	}
}
