package SeleniumGridwithDocker.dockerTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class HomeTest {
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser) throws MalformedURLException{
		
		if (browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/dbhovi/selenium/geckodriver-v0.21.0/geckodriver.exe");
			DesiredCapabilities dcap = DesiredCapabilities.firefox();
		    driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),dcap);
		}
		else if (browser.equals("chrome")){
			String exePath = "/Users/dbhovi/Downloads/chromedriver/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);		

			DesiredCapabilities dcap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),options);
			//   driver = new ChromeDriver(options);
		}   

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	
	@Test
	public void validateTravelYaari(){
		driver.get("https://www.travelyaari.com/offers");
		driver.findElement(By.linkText("Cities")).click();
		driver.findElement(By.linkText("Routes")).click();
		driver.findElement(By.linkText("Bus")).click();
	}
	
	@Test
	public void validateThis(){
		  driver.get("https://www.vrlbus.in/vrl2013/booking_home_page.aspx");
		  driver.findElement(By.linkText("Privacy Policy")).click();
		  driver.findElement(By.linkText("Track Your Bus")).click();
	}
	
	@AfterTest
	public void tearDown() throws MalformedURLException{
		 driver.quit();
	}
	
	

}
