package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApplicationPage;
import pages.ApplyJobPage;
import pages.BasePage;
import pages.CentroPage;

public class PronounsTest extends BaseTest {
    @BeforeClass
    public void setUp() throws Exception {
        init("chrome", "10");
        BasePage basePage = new BasePage(driver);
        driver.get("https://jobs.lever.co/centro?location=United%20States");
        CentroPage centroPage = new CentroPage(driver);
        centroPage.newTabVerification()
                .chooseJobLocation();
        String urlToApply = centroPage.getjobId();
        centroPage.chooseJobToApply();

        ApplyJobPage applyJobPage = new ApplyJobPage(driver);
        applyJobPage.verifyJobdetails(urlToApply)
                .clickApplytoThisJob();
        ApplicationPage applicationPage = new ApplicationPage(driver);
        applicationPage.verifyApplicationPage(urlToApply);
        applicationPage.attachResume("PDF", "POSITIVE")
                .verifySuccessMessage("POSITIVE");


    }

    @Test
    public void testPronouns() throws Exception {
        ApplicationPage applicationPage = new ApplicationPage(driver);



    }
}
