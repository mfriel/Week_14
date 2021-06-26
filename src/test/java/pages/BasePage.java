package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
	

}
