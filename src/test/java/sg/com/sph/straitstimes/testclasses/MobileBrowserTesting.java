package sg.com.sph.straitstimes.testclasses;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MobileBrowserTesting {

	public static final String USERNAME = "rajiraj1";
	public static final String AUTOMATE_KEY = "NSwpWoah1yzQWsy8uji6";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("device", "iPhone 8");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "11.0");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://www.straitstimes.com/");

		WebElement Login = driver.findElement(By.xpath("//a[text()='Login']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Login);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1
				.executeScript("document.getElementById('j_username').value='rajeswari.raj@outlook.com';");

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2
				.executeScript("document.getElementById('j_password').value='C0mm0npwd';");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebElement mainArticle = driver.findElement(By
				.xpath("//div[@data-vr-zone='Top Stories 0']"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", mainArticle);
		String Title = driver.getTitle();
		System.out.println(" Title of Main Article " + Title);
		driver.quit();

	}
}