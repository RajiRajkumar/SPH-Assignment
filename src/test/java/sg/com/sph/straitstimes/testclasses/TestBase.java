package sg.com.sph.straitstimes.testclasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import sg.com.sph.straitstimes.pageobjects.BasePage;

public class TestBase {

	@BeforeClass
	public void launchBrowser(){
		BasePage.openBrowser();
	}

	@AfterClass
	public void closeBrowser(){
		BasePage.tearDown();
	}
}
