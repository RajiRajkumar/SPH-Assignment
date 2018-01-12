package sg.com.sph.straitstimes.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainArticlePage extends BasePage {
	public static int ImageCount;
	public static boolean imagePresent;
	public static boolean articleImagesPresent() {
		List<WebElement> allImages = driver.findElements(By.tagName("img"));
		int ImageCount = allImages.size();
		System.out.println("Number of images" + ImageCount);
		if (ImageCount > 0) {
			System.out.println("Images/videos are in the article");

		} else {
			System.out.println("No images/videos in the article");
		}
		return imagePresent;
	}
}
