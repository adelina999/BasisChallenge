package tests;
import org.openqa.selenium.WebDriver;
import  org.selenium_core.DriverManager;
import  org.selenium_core.DriverManagerFactory;

import java.time.Duration;


public class BaseTest {
    DriverManager driverManager;
    public WebDriver driver;

    public void init(String browser, String wait) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(wait)));
    }

    public void quit() {
        driverManager.quitDriver();
    }
}
