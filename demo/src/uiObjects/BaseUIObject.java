package uiObjects;

import org.openqa.selenium.WebDriver;

public class BaseUIObject {
	
	public void openApplication(WebDriver driver,String url)
	{
		driver.manage().window().maximize();
		driver.get(url);
	}

}
