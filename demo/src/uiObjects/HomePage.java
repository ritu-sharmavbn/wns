package uiObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
	WebDriver driver;
	By changeLanguage=By.xpath("//button[@id='language-dropdown-flag']");
	By clickFrgnExchngRate=By.xpath("//a[@href='/en-us/business/foreign-exchange-solutions/' AND @aria-label='Find out more']");

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@SuppressWarnings("deprecation")
	public void changeLanguage(String Language)
	{
		Select se = new Select(driver.findElement(changeLanguage));
		se.selectByVisibleText(Language);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void clickFER()
	{
		driver.findElement(clickFrgnExchngRate).click();
	}
}
