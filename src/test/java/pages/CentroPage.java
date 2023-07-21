package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CentroPage extends BasePage {
    public CentroPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CentroPage newTabVerification() {
        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                // Switch to the new tab
                driver.switchTo().window(windowHandle);

                // Verify the content on the new page
                // For example, you can assert the page url
                String currentUrl = driver.getCurrentUrl();
                String expectedUrl = "https://jobs.lever.co/centro";
                if (currentUrl.equals(expectedUrl)) {
                    System.out.println("New page title is correct: " + currentUrl);
                } else {
                    System.out.println("New page title is incorrect: " + currentUrl);
                }

            }
        }
        return new CentroPage(driver);
    }

    public CentroPage chooseJobLocation() {
        //System.out.println("centro Page");
        try {
            // Locate the location dropdown element
            WebElement locationDropdown = driver.findElement(By.xpath("(//*[name()='svg'][@class='filter-button-caret icon icon-caret-down'])[2]"));

            // Click on the location dropdown to expand it
            locationDropdown.click();

            // Locate and select "United States" from the dropdown
            WebElement unitedStatesOption = driver.findElement(By.cssSelector(".category-link[href='?location=United%20States']"));
            unitedStatesOption.click();

            // Wait for a moment to ensure the page updates after the selection (You may need to use WebDriverWait)
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CentroPage(driver);
    }


    public ApplyJobPage chooseJobToApply() {
        WebElement seconfJobApply = driver.findElement(By.xpath("//div[@class='postings-wrapper']//div[2]//div[4]//div[1]//a[1]"));

        System.out.println(seconfJobApply.getAttribute("href"));
        seconfJobApply.click();
        return new ApplyJobPage(driver);
    }

    public String getjobId() {
        WebElement seconfJobApply = driver.findElement(By.xpath("//div[@class='postings-wrapper']//div[2]//div[4]//div[1]//a[1]"));
        String urlToApply = seconfJobApply.getAttribute("href");
        return urlToApply;
    }
}
