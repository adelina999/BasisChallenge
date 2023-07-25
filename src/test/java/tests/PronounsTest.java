package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApplicationPage;
import pages.ApplyJobPage;
import pages.BasePage;
import pages.CentroPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PronounsTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(PronounsTest.class);

    @BeforeClass
    public void setUp() throws Exception {
        try {
            init("chrome", "10");
            logger.info("Browser opened");
            baseStepstoAttachResume();
            logger.info("Base steps to attach resume performed");
        } catch (Exception e) {
            // Handle initialization errors here
            e.printStackTrace();
            Assert.fail("Test setup failed: " + e.getMessage());
        }
    }

    @Test
    public void testSinglePronounsTest() throws Exception {

        logger.info("Testing all the pronouns box checking and unchecking");
        ApplicationPage applicationPage = new ApplicationPage(driver);
        List<String> pronounsList = Arrays.asList("He/him", "She/her", "They/them", "Xe/xem",
                "Ze/hir", "Ey/em", "Hir/hir", "Fae/faer",
                "Hu/hu", "UseNameOnly", "Custom");

        for (int i = 0; i < pronounsList.size(); i++) {
            try {
                System.out.println("Checking " + pronounsList.get(i));
                applicationPage.testSinglePronounsCheckAndUncheck(pronounsList.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("Test complete successfully");
        //  System.out.println(pronounsList);
        //       applicationPage.testSinglePronouns("He/him");


    }

    @Test
    public void testMultiplePronounsTest() throws Exception {
        ApplicationPage applicationPage = new ApplicationPage(driver);
        List<String> pronounsList = Arrays.asList("He/him", "She/her", "They/them", "Xe/xem");
        try {
            applicationPage.testMultiplePronouns(pronounsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Test complete successfully");
    }

    @Test
    public void testPronounsUseNameOnlyTest() throws Exception {
        //This test verify if you choose "use name only" you can't check anything else, otherwise it gets overwritten
        Boolean pronounChecked;
        ApplicationPage applicationPage = new ApplicationPage(driver);
        try {
            applicationPage.testSinglePronounsCheck("UseNameOnly");
            Assert.assertTrue(applicationPage.validatePronounsFieldsselected("UseNameOnly"));
            applicationPage.testSinglePronounsCheck("He/him");
            Assert.assertFalse(applicationPage.validatePronounsFieldsselected("UseNameOnly"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPronounsCustomeFieldTest() throws Exception {
        //This test verify if you choose "custom" , custom input fields displayed and you can choose a custom pronoun, also if you choose a different pronoun it will overwrite the custom checkbox.
        Boolean pronounChecked;
        ApplicationPage applicationPage = new ApplicationPage(driver);
        try {
            applicationPage.testSinglePronounsCheck("Custom");
            Assert.assertTrue(applicationPage.validatePronounsFieldsselected("Custom"));
            applicationPage.validateCustomInputField();
            applicationPage.testSinglePronounsCheck("He/him");
            Assert.assertFalse(applicationPage.validatePronounsFieldsselected("UseNameOnly"));
            logger.info("Test complete successfully");

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
