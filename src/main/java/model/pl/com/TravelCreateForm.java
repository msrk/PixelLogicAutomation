package model.pl.com;

import command.pl.com.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TravelCreateForm extends PageBase {

    public TravelCreateForm(String filename, WebDriver driver){
        super(filename);
        this.driver= driver;
    }


    public void CreateForm(String username,
                           String password){



        ClickCommand clickCommand = new ClickCommand(driver);
        SendKeysCommand sendKeysCommand = new SendKeysCommand(driver);
        CommandControl commandControl = new CommandControl();
        commandControl.setCommand(sendKeysCommand);
        WaitCommandControl waitCommandControl= new WaitCommandControl();
        ConcreteWaitCommand concreteWaitCommand = new ConcreteWaitCommand(driver);
        waitCommandControl.setCommand(concreteWaitCommand);
        waitCommandControl.waitUntilVisible(eles.get("username") );//By.cssSelector("input[name='firstname']"
        commandControl.performSendKeys(eles.get("username"),username);
        commandControl.performSendKeys(eles.get("password"), password+ Keys.ENTER);

        commandControl.setCommand(clickCommand);
        commandControl.attrib3(By.xpath(""), "");
        waitCommandControl.waitUntilVisible(eles.get("link1"));
        waitCommandControl.waitUntilVisible(eles.get("link1"));

        commandControl.performClick(eles.get("link1"));
        waitCommandControl.waitUntilVisible(eles.get("search"));
        waitCommandControl.waitUntilVisible(eles.get("manage"));
        commandControl.performClick(eles.get("manage"));
        waitCommandControl.waitUntilVisible2(eles.get("waiter"));
        commandControl.setCommand(clickCommand);
        waitCommandControl.waitUntilVisible(eles.get("date"));
        commandControl.attrib(eles.get("date"),"title" ,"02-02/2023");

   }



}
