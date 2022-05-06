package uiObjects;

import java.time.Duration;
import java.util.List;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FREPage {
	WebDriver driver;
	By pageTitle=By.xpath("//h1[contains(text(),'Foreign exchange solutions for your business')]");
	By searchBar=By.xpath("//input[@id='nav_search']");
	By elementsAfterSearch=By.xpath("//a[@class='title u-m-b2']");
	public FREPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForPageLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
	}
	
	public void searchForBusiness(String business)
	{
		driver.findElement(searchBar).sendKeys(business,Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='"+business+"']")));	
	}
	
	public void validateEachArticleInPage()
	{
		List<WebElement> ele=driver.findElements(elementsAfterSearch);
		for(WebElement e:ele)
		{
			e.click();
			assertTrue(driver.getCurrentUrl().contains("https://www.moneycorp.com/en-us/"),"Link is correct");
			driver.navigate().back();
		}
	}
}
