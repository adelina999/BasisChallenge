package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class AttachingResumeTests extends BaseTest{
    @BeforeClass
    public void setUp() throws Exception {
        init("chrome","10");
        BasePage basePage= new BasePage(driver);

    }
    @Test(enabled = true)
    public void attachPDFFilePositive() throws Exception {
driver.get("https://jobs.lever.co/centro?location=United%20States");
        //verifying new tab is opened , choosing location=USA and clicking the first job posting
        CentroPage centroPage= new CentroPage(driver);

        centroPage.newTabVerification();
        String urlToApply= centroPage.getjobId();
        centroPage.chooseJobToApply();

        ApplyJobPage applyJobPage= new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
        applicationPage.attachResume("PDF", "POSITIVE")
                .verifySuccessMessage("POSITIVE")
                .verifyinputfield();

    }
    @Test(enabled = true)
    public void attachWordFilePositive() throws Exception {
        driver.get("https://jobs.lever.co/centro?location=United%20States");
        //verifying new tab is opened , choosing location=USA and clicking the first job posting
        CentroPage centroPage= new CentroPage(driver);

        centroPage.newTabVerification();
        String urlToApply= centroPage.getjobId();
        centroPage.chooseJobToApply();

        ApplyJobPage applyJobPage= new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
        applicationPage.attachResume("WORD", "POSITIVE")
                .verifySuccessMessage("POSITIVE")
                .verifyinputfield();

    }

    @Test(enabled = true)
    public void attachWordFileNegative() throws Exception {
        driver.get("https://jobs.lever.co/centro?location=United%20States");
        //verifying new tab is opened , choosing location=USA and clicking the first job posting
        CentroPage centroPage= new CentroPage(driver);

        centroPage.newTabVerification();

        String urlToApply= centroPage.getjobId();
        centroPage.chooseJobToApply();

        ApplyJobPage applyJobPage= new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
        applicationPage.attachResume("WORD", "NEGATIVE")
                .verifySuccessMessage("NEGATIVE");

    }

    @Test(enabled = true)
    public void attachPDFFileNegative() throws Exception {
        driver.get("https://jobs.lever.co/centro?location=United%20States");
        //verifying new tab is opened , choosing location=USA and clicking the first job posting
        CentroPage centroPage= new CentroPage(driver);

        centroPage.newTabVerification();
        String urlToApply= centroPage.getjobId();
        centroPage.chooseJobToApply();

        ApplyJobPage applyJobPage= new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
        applicationPage.attachResume("PDF", "NEGATIVE")
                .verifySuccessMessage("NEGATIVE");

    }

    @AfterClass
    public void tearDown(){
        quit();
    }
}
