package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import org.testng.Reporter;
import tests.BaseTest;

import java.util.concurrent.TimeUnit;

public class JobApplicationTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(JobApplicationTest.class);

    @BeforeClass
    public void setUp() throws Exception {
        try {
            init("chrome", "30");
            logger.info("Browser opened");
            BasePage basePage = new BasePage(driver);
        } catch (Exception e) {
            // Handle initialization errors here
            e.printStackTrace();
            Assert.fail("Test setup failed: " + e.getMessage());
        }

    }

    @Test(enabled = true)
    public void applyJob() throws Exception {
        try {
            HomePage homePage = new HomePage(driver);
            //Opening Basis WebUrl
            driver.get("https://basis.com");
            logger.info("Basis home page opened");
            //Accepting Cookies and clicking on Careers
            homePage.agreeCookie()
                    .clickOnCareerLink();
            Reporter.log("User scrolled to the bottom of the page ,accpeted cookies and clicked on Careers link");
            //Verifying career page anc clicking on view all positions
            CareersPage careersPage = new CareersPage(driver);
            careersPage.verifyCareerPageUrl()
                    .clickOnViewAllPositions();
            Reporter.log("User redirected to careers page, and clicks on view all positions");

            //verifying new tab is opened , choosing location=USA and clicking the first job posting
            CentroPage centroPage = new CentroPage(driver);

            centroPage.newTabVerification()
                    .chooseJobLocation();
            String urlToApply = centroPage.getjobId();
            centroPage.chooseJobToApply();
            logger.info("User redirected to a new tab where he choose location USA and click on second job to apply ");

            ApplyJobPage applyJobPage = new ApplyJobPage(driver);
            applyJobPage.verifyJobdetails(urlToApply)
                    .clickApplytoThisJob();
            ApplicationPage applicationPage = new ApplicationPage(driver);
            applicationPage.verifyApplicationPage(urlToApply);
            applicationPage.attachResume("PDF", "POSITIVE")
                    .verifySuccessMessage("POSITIVE");
            logger.info("PDF file was successfully attached and the input fields were verified");
            logger.info("Test completed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @AfterClass
    public void tearDown() {
        try {
            quit();
        } catch (Exception e) {
            // Handle cleanup errors here
            e.printStackTrace();

        }
    }
}
