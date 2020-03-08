package stepDefs;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.SingletonBrowser;

public class LoginStepDef {
	SingletonBrowser sb = SingletonBrowser.getSingletonBrowser();
	WebDriver driver = sb.getDriver();
	LoginPage lp = new LoginPage(driver);

	@Given("I want to go the home page")
	public void i_want_to_go_the_home_page() {
		driver.get(lp.getUrl());
	}

	@Given("I enter username")
	public void i_enter_username() {
		lp.username.sendKeys("mngr249460");
		;
	}

	@Given("I enter password")
	public void i_enter_password() {
		lp.password.sendKeys("ypAhyzY");
		;
	}

	@When("I click login")
	public void i_click_login() {
		lp.login.click();
	}

	@Then("I should be able to login my account")
	public void i_should_be_able_to_login_my_account() {
		assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());

	}

}
