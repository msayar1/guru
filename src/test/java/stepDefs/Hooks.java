package stepDefs;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.SingletonBrowser;


public class Hooks {
	WebDriver driver;
	SingletonBrowser sb;
	@Before
	public void setUp() {
		sb = SingletonBrowser.getSingletonBrowser();
		driver = sb.getDriver();
	}
	
	
	@After
	public void tearDown() {
		sb.closeDriver();
	}
}
