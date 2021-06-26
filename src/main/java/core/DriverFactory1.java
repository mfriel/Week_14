package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory1 {

    private WebDriver driver = null;

    public WebDriver getDriver(String browser){
        switch (browser.toLowerCase()){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\martin.friel\\GitHub\\Full Stack Test Automation\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\martin.friel\\GitHub\\Full Stack Test Automation\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Entered browser is incorrect" +browser);
            }
            driver.manage().timeouts().pageLoadTimeout(Long.parseLong(TestConfig.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);  // One time config done for the whole project
            // This will wait 20 seconds for every page before throwing a TimedOutException
            driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS); // One time config
            // This will wat 10 seconds for any element to load before throwing a NoSuchElementException
            return driver;
    }
    public void quitDriver(){
        if (driver!= null){
            driver.quit();
        }
    }
}
