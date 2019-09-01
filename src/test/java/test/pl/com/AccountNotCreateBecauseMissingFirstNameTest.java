package test.pl.com;

import model.pl.com.GoogleSignIn;
import model.pl.com.MailPage;
import model.pl.com.TravelCreateForm;
import model.pl.com.TravelHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;

public class AccountNotCreateBecauseMissingFirstNameTest extends BaseTest{

    @BeforeClass(alwaysRun = true)
    public void loadData() {
        testData = getTestDataAsObjectArray("AccountNotCreatetBecauseMissingFirstNameTest.xlsx");
    }

    @DataProvider(name = "test1", parallel = false)
    public Iterator<Object[]> loadTestData() {

        return this.testData.iterator();
    }



    @Test(dataProvider = "test1")
    public void accountNotCreated(HashMap<String, String> columns) {

        logger = extent.createTest("To verify Account Not Created Because Missing First Name Test");
        driver.get("https://www.phptravels.net/register");
        TravelCreateForm travelCreateForm = new TravelCreateForm("TravelCreateForm.json", driver);
        travelCreateForm.CreateForm(columns.get("firstname"),columns.get("lastname"),
                columns.get("phone"),columns.get("email"),
                columns.get("password"),columns.get("confirmpassword"));
        String vaidation=travelCreateForm.getValidationMessageCaseMissingFirstName();
        Assert.assertEquals(vaidation,"The First name field is required.");

    }

}
