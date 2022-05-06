package uiTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uiObjects.BaseUIObject;
import uiObjects.FREPage;
import uiObjects.HomePage;

public class TestMoneyCorp extends BaseUIObject{
	WebDriver driver;
	String url="https://www.moneycorp.com/en-gb/";
	FREPage frePage;
	HomePage homePage;
	
	@BeforeMethod
	void beforemethod()
	{
		driver=new ChromeDriver();
		frePage=new FREPage(driver);
		homePage=new HomePage(driver);
	}
	@Test
	public void TestMoneyCorp()
	{
		openApplication(driver,url);
		homePage.changeLanguage("USA English");
		homePage.clickFER();
		frePage.waitForPageLoad();
		frePage.searchForBusiness("Corporate foreign exchange");
		frePage.validateEachArticleInPage();
	}

	@AfterMethod
	void aftermethod()
	{
		driver.close();
	}
}
