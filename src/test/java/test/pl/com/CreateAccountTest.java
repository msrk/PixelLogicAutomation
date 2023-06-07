package test.pl.com;

import java.util.*;


import model.pl.com.TravelCreateForm;
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
    driver.get("https://testplus.oasisapp.services/dhbhp/faces/Home");
    TravelCreateForm travelCreateForm = new TravelCreateForm("TravelCreateForm.json", driver);
    travelCreateForm.CreateForm(columns.get("username"), columns.get("password"));

}catch(Exception e){
    logger.createNode(e.getStackTrace().toString());
    logger.createNode("Test has failed");
    Assert.assertTrue(false);
}

    }


}
