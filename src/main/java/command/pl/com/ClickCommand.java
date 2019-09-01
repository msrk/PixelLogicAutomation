package command.pl.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickCommand implements Command {

    WebDriver webdriverInstance;
    public ClickCommand(WebDriver webdriverInstance){
        this.webdriverInstance = webdriverInstance;
    }

    public void execute(By by){
        webdriverInstance.findElement(by).click();
    }

    public void execute(By by, int index){
        webdriverInstance.findElements(by).get(index).click();
    }

    public void execute(By by, String txt, int index) {

    }

    public void execute(By by, String txt) {

    }

}
