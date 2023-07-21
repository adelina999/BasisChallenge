package tests;

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
    @BeforeClass
    public void setUp() throws Exception {
        init("chrome", "10");


        baseStepstoAttachResume();
    }

    @Test
    public void testSinglePronounsTest() throws Exception {


        ApplicationPage applicationPage = new ApplicationPage(driver);
        List<String> pronounsList = Arrays.asList("He/him", "She/her", "They/them", "Xe/xem",
                "Ze/hir", "Ey/em", "Hir/hir", "Fae/faer",
                "Hu/hu", "UseNameOnly", "Custom");

        for (int i = 0; i < pronounsList.size(); i++) {
            System.out.println("Checking " + pronounsList.get(i));
            applicationPage.testSinglePronouns(pronounsList.get(i));
        }
        System.out.println(pronounsList);
        //       applicationPage.testSinglePronouns("He/him");


    }

    @Test
    public void testMultiplePronounsTest() throws Exception {
        ApplicationPage applicationPage = new ApplicationPage(driver);


    }

    @AfterClass
    public void tearDown() {
        quit();
    }
}
