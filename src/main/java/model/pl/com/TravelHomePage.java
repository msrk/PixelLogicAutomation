package model.pl.com;

import command.pl.com.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage extends PageBase {
    public TravelHomePage(String filename, WebDriver driver) {
        super(filename);
        this.driver= driver;
    }

    public String getWelcomeMessageSignOut(String welcome){
        ClickCommand clickCommand = new ClickCommand(driver);

        CommandControl commandControl = new CommandControl();
        commandControl.setCommand(clickCommand);
        WaitCommandControl waitCommandControl= new WaitCommandControl();
        ConcreteWaitCommand concreteWaitCommand = new ConcreteWaitCommand(driver);
        waitCommandControl.setCommand(concreteWaitCommand);
        waitCommandControl.waitUntilVisibleWitthText(eles.get("welcome"), welcome);
        String welcomeMessage=driver.findElement(eles.get("welcome")).getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitCommandControl.waitUntilVisible(eles.get("dropdown"));
        commandControl.performClick(eles.get("dropdown"));

        waitCommandControl.waitUntilVisible(eles.get("signout"));
        commandControl.performClick(eles.get("signout"));
return welcomeMessage;
    }
}
