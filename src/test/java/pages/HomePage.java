package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    private WebDriver driver;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href=\"/company/careers\"]")
    private WebElement carrerLink;

    public HomePage agreeCookie() throws Exception {
        WebElement acceptcookieBttn = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));

        acceptcookieBttn.click();
         return new HomePage(driver);

    }

    public CareersPage clickOnCareerLink() throws Exception{
        scrollTotheButtom();
        WebElement careersLink = driver.findElement(By.xpath("//a[@href=\"/company/careers\"]"));
        clickonElement(careersLink);
       // System.out.println("completed");
        return new CareersPage(driver);
    }




}
