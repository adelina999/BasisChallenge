package tests;

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
    @BeforeClass
    public void setUp() throws Exception {
        try {
            init("chrome", "10");
            baseStepstoAttachResume();
        } catch (Exception e) {
            // Handle initialization errors here
            e.printStackTrace();
            Assert.fail("Test setup failed: " + e.getMessage());
        }
    }

    @Test
    public void testSinglePronounsTest() throws Exception {


        ApplicationPage applicationPage = new ApplicationPage(driver);
        List<String> pronounsList = Arrays.asList("He/him", "She/her", "They/them", "Xe/xem",
                "Ze/hir", "Ey/em", "Hir/hir", "Fae/faer",
                "Hu/hu", "UseNameOnly", "Custom");

        for (int i = 0; i < pronounsList.size(); i++) {
           try{
               System.out.println("Checking " + pronounsList.get(i));
               applicationPage.testSinglePronouns(pronounsList.get(i));
           } catch (Exception e){
               e.printStackTrace();
           }
        }
      //  System.out.println(pronounsList);
        //       applicationPage.testSinglePronouns("He/him");


    }

    @Test
    public void testMultiplePronounsTest() throws Exception {
        ApplicationPage applicationPage = new ApplicationPage(driver);


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
