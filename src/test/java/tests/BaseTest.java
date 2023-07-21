package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.selenium_core.DriverManager;
import  org.selenium_core.DriverManagerFactory;
import pages.*;

import java.time.Duration;


public class BaseTest {
    DriverManager driverManager;
    public WebDriver driver;

    public void init(String browser, String wait) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(wait)));
    }

    public void quit() {
        driverManager.quitDriver();
    }

    public void baseStepstoAttachResume() throws Exception {
       // init("chrome", "10");
        driver.get("https://jobs.lever.co/centro?location=United%20States");
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
                .verifySuccessMessage("POSITIVE")
                .verifyinputfield();
    }

    public void fullFlowToAttachResume(String format, String scenario) throws Exception {
        // init("chrome", "10");
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
        applicationPage.attachResume(format, scenario)
                .verifySuccessMessage(scenario);
    }

}
