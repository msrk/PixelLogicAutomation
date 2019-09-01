package model.pl.com;

import command.pl.com.ClickCommand;
import command.pl.com.CommandControl;
import command.pl.com.ConcreteWaitCommand;
import command.pl.com.WaitCommandControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage extends PageBase {
    public MailPage(String filename, WebDriver driver) {
        super(filename);
        this.driver= driver;
    }

    public String verfiyEmailInVerificationMail(){
        WaitCommandControl waitCommandControl = new WaitCommandControl();
        waitCommandControl.setCommand(new ConcreteWaitCommand(driver));
        CommandControl commandControl = new CommandControl();
        ClickCommand clickCommand = new ClickCommand(driver);
        commandControl.setCommand(clickCommand);
        By ele=eles.get("firstrow");
        waitCommandControl.waitUntilVisible(ele);

        commandControl.performClick(ele);
        waitCommandControl.waitUntilVisible(eles.get("verificationmail"));
    return driver.findElement(eles.get("verificationmail")).getText();
    }
}
