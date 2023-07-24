package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class ApplicationPage extends BasePage {
    public ApplicationPage(WebDriver driver) {
        super(driver);
    }

    HashMap<String, WebElement> elementMap = new HashMap<>();

    private void setupElementMap() {
        elementMap = new HashMap<>();
        elementMap.put("He/him", driver.findElement(By.xpath("//input[@value='He/him']")));
        elementMap.put("She/her", driver.findElement(By.xpath("//input[@value='She/her']")));
        elementMap.put("They/them", driver.findElement(By.xpath("//input[@value='They/them']")));
        elementMap.put("Xe/xem", driver.findElement(By.xpath("//input[@value='Xe/xem']")));
        elementMap.put("Ze/hir", driver.findElement(By.xpath("//input[@value='Ze/hir']")));
        elementMap.put("Ey/em", driver.findElement(By.xpath("//input[@value='Ey/em']")));
        elementMap.put("Hir/hir", driver.findElement(By.xpath("//input[@value='Hir/hir']")));
        elementMap.put("Fae/faer", driver.findElement(By.xpath("//input[@value='Fae/faer']")));
        elementMap.put("Hu/hu", driver.findElement(By.xpath("//input[@value='Hu/hu']")));
        elementMap.put("UseNameOnly", driver.findElement(By.xpath("//input[@id='useNameOnlyPronounsOption']")));
        elementMap.put("Custom", driver.findElement(By.xpath("//input[@id='customPronounsOption']")));

    }

    public ApplicationPage verifyApplicationPage(String url) {
        url += "/apply";
        System.out.println(url);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url, "Application page URL  doesn't match.");
        return this;
    }

    public ApplicationPage attachResume(String format, String scenario) {
        format = format.toUpperCase();
        scenario = scenario.toUpperCase();
        String localpdfFile = null;
        //String pdfFilePath = "C:/Users/adelk/OneDrive/Desktop/resume/Adele Nosonovich_Test.pdf";
        if (format == "PDF" && scenario == "POSITIVE") {
            localpdfFile = "C:/work/BasisChallenge/src/test/java/fileUPload/Adele Nosonovich_Test.pdf";
        } else if (format == "WORD" && scenario == "POSITIVE") {
            localpdfFile = "C:/work/BasisChallenge/src/test/java/fileUPload/Adele Nosonovich_Test.docx";
        } else if (format == "PDF" && scenario == "NEGATIVE") {
            localpdfFile = "C:/work/BasisChallenge/src/test/java/fileUPload/basis_automation_assignment.pdf";
        } else if (format == "WORD" && scenario == "NEGATIVE") {
            localpdfFile = "C:/work/BasisChallenge/src/test/java/fileUPload/basis_automation_assignment.pdf";
        }

        WebElement fileinput = driver.findElement(By.cssSelector("#resume-upload-input"));
        fileinput.sendKeys(localpdfFile);
        //attachResumeBttn.click();
        try {
            Thread.sleep(5000); // Wait for 5 seconds (adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //  System.out.println("attaching resume");


        return this;
    }

    public ApplicationPage verifySuccessMessage(String scenario) {
        //After attaching right format and real resume, success message should appear on the screen, otherwise no success message
        WebElement successMessage = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        scenario = scenario.toUpperCase();

        if (scenario == "POSITIVE") {
            successMessage = driver.findElement(By.xpath("//div[normalize-space()='Success!']"));
            successMessage.getText().equals("Success!");
        } else if (scenario == "NEGATIVE") {
            boolean isElementNotPresent = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[normalize-space()='Success!']")));
            if (isElementNotPresent) {
                System.out.println("The success message is not present on the specific flow.");
            }
        }
        return this;
    }

    public ApplicationPage verifyinputfield() {
        //After successfully attaching resume I perform validations that the input field were auto populated with the expected information from the file
        //The validation can be done against data set as well, here I choose fixed, hard coded values
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));
        //  String nameText= nameInput.getAttribute("value");
        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
        WebElement phoneInput = driver.findElement(By.cssSelector("input[name='phone']"));
        WebElement currentCompanyInput = driver.findElement(By.xpath("//input[@name='org']"));
        Assert.assertEquals(nameInput.getAttribute("value"), "Adele Nosonovich");
        Assert.assertEquals(emailInput.getAttribute("value"), "fake81@gmail.com");
        Assert.assertEquals(phoneInput.getAttribute("value"), "+14444444444");
        Assert.assertEquals(currentCompanyInput.getAttribute("value"), "Cloudexa");

        return this;
    }

    public ApplicationPage testSinglePronouns(String pronoun) {
        setupElementMap();
        WebElement checkPronounBox = elementMap.get(pronoun);
        checkPronounBox.click();
        System.out.println(pronoun + " checked");
        checkPronounBox.click();
        System.out.println(pronoun + " unchecked");
        return this;

    }

    public ApplicationPage testMultiplePronouns(List<String> pronounList) {

        return this;

    }


}
