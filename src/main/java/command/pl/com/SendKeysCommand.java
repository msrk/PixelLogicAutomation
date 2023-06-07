package command.pl.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SendKeysCommand implements Command {
    WebDriver webdriverInstance;

    public SendKeysCommand(WebDriver webdriverInstance) {
        this.webdriverInstance = webdriverInstance;
    }

    public void execute(By by) {
        // do nothing
    }

    public void execute(By by, int index) {
        // do nothing
    }

    public void execute(By by, String txt) {
        webdriverInstance.findElement(by).sendKeys(txt);
        //do nothing;
    }

    @Override
    public void execute(By by, String txt, String txt2) {

    }


    public void execute(By by, String txt, int index) {
        webdriverInstance.findElements(by).get(index).sendKeys(txt);
        //do nothing;
    }

}
