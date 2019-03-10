package SeleniumGridwithDocker.dockerTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class geckoTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/dbhovi/selenium/geckodriver-v0.21.0/geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		 driver.get("http://www.toolsqa.com");
		 
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 driver.quit();

	}

}
