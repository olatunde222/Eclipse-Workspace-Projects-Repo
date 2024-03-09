package com.opencart.stepdefinationsfiles;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opencart.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	@Given("I am on the openCart login page")
	public void i_am_on_the_open_cart_login_page() {
	    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	    loginPage = new LoginPage(driver);
	}

	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
	    loginPage.enterEmail("nexole9687@aersm.com");
	    loginPage.enterPassword("12345");
	}
	
	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String username,String password) {
	    loginPage.enterEmail(username);
	    loginPage.enterPassword(password);
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
	   loginPage.clickLoginBtn();
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		Assert.assertEquals(loginPage.checkLogoutLink(), true);
	}



	@Then("I should see an error message indicating {string}")
	public void i_should_see_an_error_message_indicating(String errorMessage) {
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
	}


	@When("I click on the \"Forgotten Password\" link")
	public void i_click_on_the_link() {
	    loginPage.clickForgottenPassword();
	}

	@Then("I should be redirected to the reset page")
	public void i_should_be_redirected_to_the_reset_page() {
	    Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
	}

}
