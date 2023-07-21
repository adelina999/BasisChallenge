package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ApplyJobPage extends BasePage{
    public ApplyJobPage(WebDriver driver) {
        super(driver);
    }

    public ApplyJobPage verifyJobdetails(String urlToApply){
        WebElement postingdetails= driver.findElement(By.className("posting-categories"));
        String currentUrl= driver.getCurrentUrl();
        String jobTitle= postingdetails.getText();
      //  System.out.println(jobTitle);
       if(jobTitle.contains("UNITED STATES")){
           System.out.println("Job location is correct");
       }

        Assert.assertEquals(currentUrl,urlToApply, "Job URL  doesn't match.");
        return new ApplyJobPage(driver);
    }

    public ApplyJobPage clickApplytoThisJob(){
        WebElement applyBttn= driver.findElement(By.xpath("//div[@class='postings-btn-wrapper']//a[@class='postings-btn template-btn-submit black'][normalize-space()='Apply for this job']"));
        applyBttn.click();
        //Assert.assertEquals(jobTitle, jobName, "Job title doesn't match.");
        return new ApplyJobPage(driver);
    }

}
