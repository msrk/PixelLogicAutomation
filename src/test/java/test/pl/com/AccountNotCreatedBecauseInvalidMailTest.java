package test.pl.com;

import model.pl.com.TravelCreateForm;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;

public class AccountNotCreatedBecauseInvalidMailTest extends BaseTest {
    @BeforeClass(alwaysRun = true)
    public void loadData() {
        testData = getTestDataAsObjectArray("AccountNotCreatedBecauseInvalidMailTest.xlsx");
    }

    @DataProvider(name = "test2", parallel = false)
    public Iterator<Object[]> loadTestData() {

        return this.testData.iterator();
    }



    @Test(dataProvider = "test2")
    public void accountNotCreated(HashMap<String, String> columns) {
try {
    logger = extent.createTest("To verify Account Not Created Because Invalid Mail Test");
    driver.get("https://www.phptravels.net/register");
    TravelCreateForm travelCreateForm = new TravelCreateForm("TravelCreateForm.json", driver);
    travelCreateForm.CreateForm(columns.get("firstname"), columns.get("lastname"),
            columns.get("phone"), columns.get("email"),
            columns.get("password"), columns.get("confirmpassword"));
    String vaidation = travelCreateForm.getValidationMessageInvalidEmail();
    Assert.assertEquals(vaidation, "The Email field must contain a valid email address.");
}catch(Exception e){
    logger.createNode(e.getStackTrace().toString());
    logger.createNode("Test has failed");
    Assert.assertTrue(false);
}

    }
}
