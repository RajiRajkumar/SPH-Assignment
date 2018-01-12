package sg.com.sph.straitstimes.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	public static String launchHomePage() {
		BasePage.openBrowser();
		String HomePageTitle = driver.getTitle();
		return HomePageTitle;
	}

	public static String gotToMainArticle() {
		WebElement mainArticle = driver.findElement(By.xpath("//div[@data-vr-zone='Top Stories 0']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", mainArticle);

		String ArticleTitle = driver.getTitle();
		return ArticleTitle;
	}

}
