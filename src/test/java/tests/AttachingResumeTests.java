package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AttachingResumeTests extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AttachingResumeTests.class);

    @BeforeClass
    public void setUp() throws Exception {
        try {
            init("chrome", "30");
            logger.info("Browser opened");
           // BasePage basePage = new BasePage(driver);
        } catch (Exception e) {
            // Handle initialization errors here
            e.printStackTrace();
            Assert.fail("Test setup failed: " + e.getMessage());
        }

    }

    @Test(enabled = true)
    public void attachPDFFilePositive() throws Exception {
        driver.get("https://jobs.lever.co/centro?location=United%20States");
        logger.info("carrer job page is open");
        //verifying new tab is opened , choosing location=USA and clicking the first job posting
        CentroPage centroPage = new CentroPage(driver);

        centroPage.newTabVerification();
        logger.info("New tab is open");
        String urlToApply = centroPage.getjobId();
        logger.info("Job Id stored");
        centroPage.chooseJobToApply();
        logger.info("job to apply is choosen");

        ApplyJobPage applyJobPage = new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        logger.info("job details confirmed anc user clicked on apply to this job");
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
        applicationPage.attachResume("PDF", "POSITIVE")
                .verifySuccessMessage("POSITIVE")
                .verifyinputfield();
        logger.info("PDF file was successfully attached and the input fields were verified");

        logger.info("Test completed successfully!");

    }

    @Test(enabled = true)
    public void attachWordFilePositive() throws Exception {
        driver.get("https://jobs.lever.co/centro?location=United%20States");
        //verifying new tab is opened , choosing location=USA and clicking the first job posting
        CentroPage centroPage = new CentroPage(driver);
        logger.info("New tab is open");
        centroPage.newTabVerification();
        String urlToApply = centroPage.getjobId();
        logger.info("URL With Job Id stored");
        centroPage.chooseJobToApply();
        logger.info("job to apply is choosen");
        ApplyJobPage applyJobPage = new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        logger.info("job details confirmed anc user clicked on apply to this job");
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
        applicationPage.attachResume("WORD", "POSITIVE")
                .verifySuccessMessage("POSITIVE")
                .verifyinputfield();
        logger.info("WORD file was successfully attached and the input fields were verified");

        logger.info("Test completed successfully!");

    }

    @Test(enabled = true)
    public void attachWordFileNegative() throws Exception {
        driver.get("https://jobs.lever.co/centro?location=United%20States");
        //verifying new tab is opened , choosing location=USA and clicking the first job posting
        CentroPage centroPage = new CentroPage(driver);
        logger.info("New tab is open");
        centroPage.newTabVerification();

        String urlToApply = centroPage.getjobId();
        centroPage.chooseJobToApply();
        logger.info("job to apply is choosen");
        ApplyJobPage applyJobPage = new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
        applicationPage.attachResume("WORD", "NEGATIVE")
                .verifySuccessMessage("NEGATIVE");
        logger.info("WORD file with wrong format was successfully attached, no success message displayed ");

        logger.info("Test completed successfully!");
    }

    @Test(enabled = true)
    public void attachPDFFileNegative() throws Exception {
        driver.get("https://jobs.lever.co/centro?location=United%20States");
        //verifying new tab is opened , choosing location=USA and clicking the first job posting
        CentroPage centroPage = new CentroPage(driver);

        centroPage.newTabVerification();
        String urlToApply = centroPage.getjobId();
        centroPage.chooseJobToApply();

        ApplyJobPage applyJobPage = new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
        applicationPage.attachResume("PDF", "NEGATIVE")
                .verifySuccessMessage("NEGATIVE");
        logger.info("WORD file with wrong format was successfully attached, no success message displayed ");

        logger.info("Test completed successfully!");
    }

    @AfterClass
    public void tearDown(){
        try {
            quit();
        } catch (Exception e) {
            // Handle cleanup errors here
            e.printStackTrace();

        }    }
}
