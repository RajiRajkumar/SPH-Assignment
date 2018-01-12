package sg.com.sph.straitstimes.testclasses;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sg.com.sph.straitstimes.pageobjects.HomePage;
import sg.com.sph.straitstimes.pageobjects.LoginPage;
import sg.com.sph.straitstimes.pageobjects.MainArticlePage;

public class AcceptanceTests extends TestBase {

	SoftAssert s = new SoftAssert();
	final static Logger log = Logger.getLogger(AcceptanceTests.class);

	@Test(description = "Verify Home Page", priority = 1)
	public void testHomePage() {

		String hpTitle = HomePage.launchHomePage();
		s.assertEquals(
				hpTitle,
				"The Straits Times - Breaking news, Singapore news, Asia and world news & multimedia",
				"Home Page title mismatch to expected value");
		s.assertAll();
	}

	@Test(description = "Verify Login to the site", priority = 2)
	public void testLogin() {

		String loginPageTitle = LoginPage.launchLoginPage();
		s.assertEquals(loginPageTitle, "SPH Login Straits Times",
				"Login Page title mismatch");
		s.assertAll();
	}

	@Test(description = "Verify Login to the site with Login ID and password", priority = 3)
	public void testUsernamePassword() {

		String Title = LoginPage.enterUserNamePassword();
		s.assertEquals(
				Title,
				"The Straits Times - Breaking news, Singapore news, Asia and world news & multimedia",
				"Home Page Title does not match to expected");
		System.out.println("The title is " + Title);

		s.assertAll();

	}

	@Test(description = "Verify the user has been logged in", priority = 4)
	public void testLoginSuccess() {

		String LoggedInUser = LoginPage.isUserNameDisplayed();
		s.assertEquals(LoggedInUser, "rajeswari.raj@outlook.com",
				"User Name does not match");
		log.info("Following User is logged in   " + LoggedInUser);
		s.assertAll();
	}

	@Test(description = "Verify that the main article is launched", priority = 5)
	public void testMainArticle() {

		String ArticleTitle = HomePage.gotToMainArticle();
		log.info("Main Article Title is " + ArticleTitle);
		s.assertAll();

	}

	@Test(description = "Verify images/videos on the main article", priority = 6)
	public void testArticleImages() {

		boolean imgpresent = MainArticlePage.articleImagesPresent();
		s.assertEquals(imgpresent, true,
				"Main Article does not have images/videos");
		log.info("Main Article has images/videos");

	}

}
