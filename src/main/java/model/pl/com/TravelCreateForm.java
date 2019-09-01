package model.pl.com;

import command.pl.com.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelCreateForm extends PageBase {

    public TravelCreateForm(String filename, WebDriver driver){
        super(filename);
        this.driver= driver;
    }


    public void CreateForm(String firstName,
                           String lastName,
                           String phone,
                           String  email,
                           String password,
                           String confirmpassword){



        ClickCommand clickCommand = new ClickCommand(driver);
        SendKeysCommand sendKeysCommand = new SendKeysCommand(driver);
        CommandControl commandControl = new CommandControl();
        commandControl.setCommand(sendKeysCommand);
        WaitCommandControl waitCommandControl= new WaitCommandControl();
        ConcreteWaitCommand concreteWaitCommand = new ConcreteWaitCommand(driver);
        waitCommandControl.setCommand(concreteWaitCommand);
        waitCommandControl.waitUntilVisible(eles.get("firstname") );//By.cssSelector("input[name='firstname']"
        commandControl.performSendKeys(eles.get("firstname"),firstName);
        commandControl.performSendKeys(eles.get("lastname"),lastName);
        commandControl.performSendKeys(eles.get("phone"),phone);
        commandControl.performSendKeys(eles.get("email"),email);
        commandControl.performSendKeys(eles.get("password"),password);
        commandControl.performSendKeys(eles.get("confirmpassword"),confirmpassword);
        commandControl.setCommand(clickCommand);
        waitCommandControl.waitUntilVisible(eles.get("cookies"));
        commandControl.performClick(eles.get("cookies"));


        waitCommandControl.waitUntilVisible(eles.get("submit"));
        commandControl.performClick(eles.get("submit"));

    }

    public String getValidationMessageCaseMissingFirstName(){
        WaitCommandControl waitCommandControl= new WaitCommandControl();
        ConcreteWaitCommand concreteWaitCommand = new ConcreteWaitCommand(driver);
        waitCommandControl.setCommand(concreteWaitCommand);
        waitCommandControl.waitUntilVisible(eles.get("firstnamevalidation"));
        return driver.findElement(eles.get("firstnamevalidation")).getText();
    }

    public String getValidationMessageInvalidEmail(){
        WaitCommandControl waitCommandControl= new WaitCommandControl();
        ConcreteWaitCommand concreteWaitCommand = new ConcreteWaitCommand(driver);
        waitCommandControl.setCommand(concreteWaitCommand);
        waitCommandControl.waitUntilVisible(eles.get("validemailvalidation"));
        return driver.findElement(eles.get("validemailvalidation")).getText();
    }


    public String getValidationMessageEmailAleadyExists(){
        WaitCommandControl waitCommandControl= new WaitCommandControl();
        ConcreteWaitCommand concreteWaitCommand = new ConcreteWaitCommand(driver);
        waitCommandControl.setCommand(concreteWaitCommand);
        waitCommandControl.waitUntilVisible(eles.get("emailalreadyexistsvalidation"));
        return driver.findElement(eles.get("emailalreadyexistsvalidation")).getText();
    }



}
