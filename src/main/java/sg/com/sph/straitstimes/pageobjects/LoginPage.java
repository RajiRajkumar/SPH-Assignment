package sg.com.sph.straitstimes.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	public static String launchLoginPage() {
		WebElement Login = driver.findElement(By.xpath("//a[text()='Login']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Login);
		String LoginPageTitle = driver.getTitle();
		return LoginPageTitle;
	}

	public static String enterUserNamePassword() {
		driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys(
				"rajeswari.raj@outlook.com");
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys(
				"C0mm0npwd");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		String HomePageTitle = driver.getTitle();
		return HomePageTitle;
	}

	public static String isUserNameDisplayed() {
		String loginName = driver.findElement(By.name("login-user-name"))
				.getText();
		System.out.println("Logged in person is      " + loginName);
		return loginName;

	}
}
