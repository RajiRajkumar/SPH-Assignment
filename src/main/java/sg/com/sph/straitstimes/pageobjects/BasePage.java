package sg.com.sph.straitstimes.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

	public static WebDriver driver;
	static String driverPath = "C:\\jba\\workspaces\\default\\straitstimes\\Driver\\";
	static String App_Url = "http://www.straitstimes.com/";

	public static WebDriver getDriver(String browserType) {
		if (browserType.equalsIgnoreCase("chrome")) {
			System.out.println("Launching Google Chrome ...");
			System.setProperty("webdriver.chrome.driver", driverPath
					+ "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.out.println("Launching Firefox ...");
			System.setProperty("webdriver.chrome.driver", driverPath
					+ "firefoxdriver.exe");
			driver = new FirefoxDriver();
		}

		return driver;

	}

	public static void openBrowser() {
		driver = BasePage.getDriver("chrome");
		driver.navigate().to(App_Url);
		driver.manage().window().maximize();
	}

	public static void tearDown() {
		driver.quit();

	}
}
