package model.pl.com;

import command.pl.com.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSignIn extends PageBase {
    public GoogleSignIn(String filename, WebDriver driver ) {
        super(filename);
        this.driver=driver;
    }


    public void signIn(String username, String password){
        WaitCommandControl waitCommandControl= new WaitCommandControl();
        ConcreteWaitCommand concreteWaitCommand = new ConcreteWaitCommand(driver);
        waitCommandControl.setCommand(concreteWaitCommand);
        waitCommandControl.waitUntilVisible(eles.get("signin"));
        String handel = driver.getWindowHandle();
        ClickCommand clickCommand = new ClickCommand(driver);
        SendKeysCommand SendKeysCommand = new SendKeysCommand(driver);
        CommandControl commadControl = new CommandControl();
        commadControl.setCommand(clickCommand);

        String switchhandel = "";


        commadControl.performClick(eles.get("signin"));

        // open a new tab to complete SignIn
        for (String han:driver.getWindowHandles()) {
            if(!han.equals(handel)){
                switchhandel= han;
            }
        }
        driver.switchTo().window(switchhandel);
        waitCommandControl.waitUntilVisible(eles.get("email"));
        commadControl.setCommand(SendKeysCommand);
        commadControl.performSendKeys(eles.get("email"),username);
        commadControl.setCommand(clickCommand);
        commadControl.performClick(eles.get("emailnext"));
        waitCommandControl.waitUntilVisible(eles.get("password"));
        commadControl.setCommand(SendKeysCommand);
        commadControl.performSendKeys(eles.get("password"),password);
        commadControl.setCommand(clickCommand);
        commadControl.performClick(eles.get("passwordnext"));

    }
}
