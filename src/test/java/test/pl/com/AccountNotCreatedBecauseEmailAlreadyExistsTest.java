package test.pl.com;

import model.pl.com.TravelCreateForm;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;

public class AccountNotCreatedBecauseEmailAlreadyExistsTest extends BaseTest {
    @BeforeClass(alwaysRun = true)
    public void loadData() {
        testData = getTestDataAsObjectArray("AccountNotCreatedBecauseEmailAlreadyExistsTest.xlsx");
    }

    @DataProvider(name = "test3", parallel = false)
    public Iterator<Object[]> loadTestData() {

        return this.testData.iterator();
    }



    @Test(dataProvider = "test3")
    public void accountNotCreated(HashMap<String, String> columns) {
try {
    logger = extent.createTest("To verify Account Not Created Because Email Already Exists Test");
    driver.get("https://www.phptravels.net/register");
    TravelCreateForm travelCreateForm = new TravelCreateForm("TravelCreateForm.json", driver);
    travelCreateForm.CreateForm(columns.get("firstname"), columns.get("lastname"),
            columns.get("phone"), columns.get("email"),
            columns.get("password"), columns.get("confirmpassword"));
    String vaidation = travelCreateForm.getValidationMessageEmailAleadyExists();
    Assert.assertEquals(vaidation.contains("TEmail Already Exists."), true);
}
    catch(Exception e){
        logger.createNode(e.getStackTrace().toString());
        logger.createNode("Test has failed");
        Assert.assertTrue(false);
}
    }
}
