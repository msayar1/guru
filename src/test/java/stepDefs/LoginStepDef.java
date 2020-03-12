package stepDefs;

import static org.junit.Assert.*;

import org.openqa.selenium.Alert;
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

		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Test case: Passed");
		} else {
			System.out.println("Test case : Failed");
		}
	}

	@Given("I enter {string} and {string}")
	public void i_enter_and(String username, String pwd) {
		lp.username.sendKeys(username);
		lp.password.sendKeys(pwd);
	}

	@Then("I should see a warning pop-up")
	public void i_should_see_a_warning_pop_up() {

		String ActualMessage = driver.switchTo().alert().getText();
		String ExpectedMessage = "User or Password is not valid";

		assertEquals(ExpectedMessage, ActualMessage);

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}
