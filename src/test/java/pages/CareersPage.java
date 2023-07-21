package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CareersPage extends BasePage{
    private WebDriver driver;

    public CareersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CareersPage verifyCareerPageUrl(){
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://basis.com/company/careers";
        Assert.assertEquals(currentUrl, expectedUrl, "URLs do not match.");
        return new CareersPage(driver);
    }

    public CentroPage clickOnViewAllPositions(){
        WebElement viewAllPosBttn= driver.findElement(By.xpath("//a[@id= 'link_button-61-100']"));
        viewAllPosBttn.click();
        System.out.println("allposition");
        return new CentroPage(driver);
    }



}
