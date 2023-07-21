package tests;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;

import java.util.concurrent.TimeUnit;

public class JobApplicationTest extends BaseTest{
    @BeforeClass
public void setUp() throws Exception {
    init("chrome","30");
    BasePage basePage= new BasePage(driver);

}
    @Test(enabled = true)
    public void applyJob() throws Exception {
        HomePage homePage= new HomePage(driver);
        //Opening Basis WebUrl
        driver.get("https://basis.com");
        //Accepting Cookies and clicking on Careers
        homePage.agreeCookie()
                .clickOnCareerLink();
        //Verifying career page anc clicking on view all positions
        CareersPage careersPage= new CareersPage(driver);
        careersPage.verifyCareerPageUrl()
                .clickOnViewAllPositions();

        //verifying new tab is opened , choosing location=USA and clicking the first job posting
        CentroPage centroPage= new CentroPage(driver);

        centroPage.newTabVerification()
                .chooseJobLocation();
        String urlToApply= centroPage.getjobId();
        centroPage.chooseJobToApply();

        ApplyJobPage applyJobPage= new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
               applicationPage.attachResume("PDF", "POSITIVE")
                       .verifySuccessMessage("POSITIVE");

    }

    @AfterClass
    public void tearDown(){
        quit();
    }
}
