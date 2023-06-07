package command.pl.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickCommand implements Command {

    WebDriver webdriverInstance;
    WebDriverWait w;

    public ClickCommand(WebDriver webdriverInstance) {
        this.webdriverInstance = webdriverInstance;
        w = new WebDriverWait(webdriverInstance, 30);
    }

    public void execute(By by) {
        webdriverInstance.findElement(by).click();
    }

    public void execute(By by, int index) {
        webdriverInstance.findElements(by).get(index).click();
    }

    public void execute(By by, String txt, int index) {
       /* webdriverInstance.switchTo().frame(1);
        webdriverInstance.switchTo().defaultContent();*/
        /*try {*/
        if(webdriverInstance.findElements(By.xpath("(//div[contains(@class,'AFActionDisabled')][@role='presentation'])[2]")).size()!=0)
            w.until(new WaitUntilVisisble(By.xpath("(//div[contains(@class,'AFActionDisabled')][@role='presentation'])[2]")));
        webdriverInstance.findElement(By.xpath("(//div[contains(@class,'AFActionDisabled')][@role='presentation'])[2]")).click();/*}catch (Exception e){
            webdriverInstance.navigate().refresh();
        }*/
        //new Actions(webdriverInstance).moveToElement(webdriverInstance.findElement(By.xpath("//table[contains(@id,'dynamicPP')]////span[@class='xfv'][text()='Yes']"))).click().perform();
    }

    @Override
    public void execute(By by, String txt) {
        JavascriptExecutor e = (JavascriptExecutor)webdriverInstance;
         e.executeScript("arguments[0].click();", by);
    }

    public void execute(By by, String txt, String txt2) {
        webdriverInstance.navigate().refresh();
        w.until(new WaitUntilVisisble(By.xpath("//*[@id='pt1:pgl1']")));
        w.until(new WaitUntilInVisisble(By.xpath("//*[@id='pt1:pgl1']")));
        //w.until(new WaitUntilVisisble(By.xpath("//iframe[@class='AFMaskingFrame']")));
        webdriverInstance.switchTo().frame(0);
        webdriverInstance.switchTo().defaultContent();
        webdriverInstance.findElement(By.xpath("//a[@aria-label='Select Date']")).click();


        w.until(new WaitUntilVisisble(by));
        //webdriverInstance.findElement(by).click();
        //webdriverInstance.findElement(by).click();
        //w.until(new WaitUntilVisisble(By.xpath("//iframe[@class='AFMaskingFrame']")));
        //webdriverInstance.switchTo().frame(0);webdriverInstance.switchTo().defaultContent();
        //w.until(new ConcreteWaitCommand.WaitUntilVisisble(By.xpath("//div[contains(@id,'DhtmlZOrderManagerLayerContainer')]//table[@role='group'][@class='xo1']//span[@class='xor']//select")));
        // WebElement e=webdriverInstance.findElement(By.xpath("//div[contains(@id,'DhtmlZOrderManagerLayerContainer')]//table[@role='group'][@class='xo1']//span[@class='xor']//select"));


        Select dropdown = new Select(
                webdriverInstance.findElement(By.xpath("//div[contains(@id,'DhtmlZOrderManagerLayerContainer')]//table[@role='group'][@class='xo1']//span[@class='xor']//select")));
        dropdown.selectByIndex(1);

        //JavascriptExecutor e = (JavascriptExecutor)webdriverInstance;
       // e.executeScript("arguments[0].click();", By.xpath(""))
        w.until(new WaitUntilVisisble(By.xpath("(//div[@class='x193']//table[@role='presentation']//table[@role='group']//td[text()='2'])[1]")));
        webdriverInstance.findElement(By.xpath("(//div[@class='x193']//table[@role='presentation']//table[@role='group']//td[text()='2'])[1]")).click();
        //dropdown.selectByVisibleText("February");

/*while(true) {w.until(new WaitUntilVisisble(By.xpath("//div[@class='x193']//table[@role='presentation']//table[@role='group']//td[text()='2'])[1]")));
        webdriverInstance.findElement(By.xpath("(//div[@class='x193']//table[@role='presentation']//table[@role='group']//td[text()='2'])[1]")).click();
    webdriverInstance.findElement(By.xpath("(//a[@title=\'Previous Month\'][@role=\'button\'])[3]'")).click();
    if (

            dropdown.getFirstSelectedOption().equals("February")) {
        break;
    }
}

w.until(new WaitUntilVisisble(By.xpath("//div[@class='x193']//table[@role='presentation']//table[@role='group']//td[text()='2'])[1]")));
        webdriverInstance.findElement(By.xpath("(//div[@class='x193']//table[@role='presentation']//table[@role='group']//td[text()='2'])[1]")).click();
       // webdriverInstance.switchTo().defaultContent();
*/
    }


    public class WaitUntilVisisble implements ExpectedCondition<Boolean> {
        By ele;

        public WaitUntilVisisble(By ele) {
            this.ele = ele;

        }

        public Boolean apply(WebDriver o) {
            if (o.findElement(ele).isDisplayed() && o.findElement(ele).isEnabled())
                return true;
            else
                return false;
        }
    }

    public class WaitUntilInVisisble implements ExpectedCondition<Boolean> {
        By ele;

        public WaitUntilInVisisble(By ele) {
            this.ele = ele;

        }

        public Boolean apply(WebDriver o) {
            if (!o.findElement(ele).isDisplayed())
                return true;
            else
                return false;
        }
    }
}