package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingletonBrowser {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		String browser = System.getProperty("browser")==null?"chrome":System.getProperty("browser");
		if(driver == null) {
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
				break;
			}
		}
		return driver;
	}
	
	public void closeDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	private SingletonBrowser() {}
	
	public static SingletonBrowser instanceOfSingleton;
	
	
	public static SingletonBrowser getSingletonBrowser() {
		if(instanceOfSingleton == null)
			instanceOfSingleton = new SingletonBrowser();
		return instanceOfSingleton;
	}
	
}
