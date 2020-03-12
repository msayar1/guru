package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String url = System.getProperty("url");

	public String getUrl() {
		if (url == null) {
			return "http://www.demo.guru99.com/V4/";
		}
		return url;
	}
	
	@FindBy( xpath= "//input[@name='uid']")
	public WebElement username;
	
	@FindBy( name= "password")
	public WebElement password;
	
	@FindBy( name= "btnLogin")
	public WebElement login;
	
	
	public void SignIn (String user, String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		login.click();
		
	}
	
	
}
