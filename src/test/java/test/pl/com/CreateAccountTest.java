package test.pl.com;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import model.pl.com.*;

import org.testng.Assert;

import org.testng.annotations.*;



public class CreateAccountTest extends BaseTest {


    @BeforeClass(alwaysRun = true)
    public void loadData() {
        testData = getTestDataAsObjectArray("CreateAccount.xlsx");
    }

    @DataProvider(name = "test", parallel = false)
    public Iterator<Object[]> loadTestData() {

        return this.testData.iterator();
    }



    @Test(dataProvider = "test")
    public void createAccount(HashMap<String, String> columns) {
try {
    logger = extent.createTest("Create Account Test");
    driver.get("https://www.phptravels.net/register");
    TravelCreateForm travelCreateForm = new TravelCreateForm("TravelCreateForm.json", driver);
    travelCreateForm.CreateForm(columns.get("firstname"), columns.get("lastname"),
            columns.get("phone"), columns.get("email"),
            columns.get("password"), columns.get("confirmpassword"));
    TravelHomePage travelHomePage = new TravelHomePage("TravelHomePage.json", driver);
    String message = travelHomePage.getWelcomeMessageSignOut("Hi, " + columns.get("firstname") + " " + columns.get("lastname"));
    logger.createNode(message);
    Assert.assertEquals(message, "Hi, " + columns.get("firstname") + " " + columns.get("lastname"));
    driver.get("http://www.gmail.com");
    GoogleSignIn googleSignIn = new GoogleSignIn("GoogleSignIn.json", driver);
    googleSignIn.signIn(columns.get("email"), columns.get("emailpassword"));
    MailPage mailPage = new MailPage("MailPage.json", driver);
    String mail = mailPage.verfiyEmailInVerificationMail();

    Assert.assertEquals(mail, columns.get("email"));
    logger.createNode(mail);
}catch(Exception e){
    logger.createNode(e.getStackTrace().toString());
    logger.createNode("Test has failed");
    Assert.assertTrue(false);
}

    }


}
