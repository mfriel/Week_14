package tests;

import core.DriverFactory1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class W3Launch extends DriverFactory1 {

    private WebDriver driver = null;

    String url = "https://www.w3schools.com/";
    String browserName = "chrome";

    By acceptCookies = By.xpath(".//div[@id='accept-choices']");
    By tryItYourselfButton = By.xpath(".//a[@class='w3-button tryit-button']");


    @Test
    public void LaunchW3Schools(){
        driver = getDriver(browserName);
        driver.get(url);
        driver.findElement(acceptCookies).click();
        Assert.assertEquals(driver.findElement(tryItYourselfButton).isDisplayed(), true, "W3 schools didn't load");
        driver.quit();
    }

}
