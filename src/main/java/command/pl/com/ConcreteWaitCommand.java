package command.pl.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConcreteWaitCommand implements WaitCommand {
    WebDriver webdriverInstance;
    WebDriverWait w;
    public ConcreteWaitCommand(WebDriver webdriverInstance){
        this.webdriverInstance = webdriverInstance;
        w = new WebDriverWait(webdriverInstance, 30);
    }

    public void execute(By by) {
        w.until(new WaitUntilVisisble(by));
    }

    @Override
    public void executec(By by) {
        w.until(new WaitUntilVisisble(by));
        w.until(new WaitUntilInVisisble(by));
    }

    public void executea(By by,String name) {
        //w.until(new WaitUntilVisisblst(by));
        webdriverInstance.navigate().refresh();
        //w.until(new WaitUntilVisisble(By.xpath("//*[@id='pt1:pgl1']")));
        //w.until(new WaitUntilInVisisble(By.xpath("//*[@id='pt1:pgl1']")));

    }
    /*@Override
    public void executea(String by) {
        w.until(ExpectedConditions.visibilityOf(webdriverInstance.findElementByAccessibilityId(by)));

    }


    public void execute(String by) {
        w.until(ExpectedConditions.visibilityOf(webdriverInstance.findElementByXPath(by)));
    }*/
    public static class WaitUntilVisisblst implements ExpectedCondition<Boolean> {
        By ele;

        public WaitUntilVisisblst(By ele) {
            this.ele = ele;

        }

        public Boolean apply(WebDriver o) {
            if ( o.findElement(ele).isEnabled())
                return true;
            else
                return false;
        }
    }
    public static class WaitUntilVisisble implements ExpectedCondition<Boolean> {
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
            this.ele=ele;

        }
        public Boolean apply(WebDriver o) {
            if(!o.findElement(ele).isDisplayed() )
                return true;
            else
                return false;
        }
    }

    public class WaitUntilVisisbleWithName implements ExpectedCondition<Boolean> {
        By ele;
        String name;
        public WaitUntilVisisbleWithName(By ele, String name) {
            this.ele=ele;
            this.name=name;
        }
        public Boolean apply(WebDriver o) {
            if(o.findElement(ele).isDisplayed() && o.findElement(ele).isEnabled() && o.findElement(ele).getText().equals(name))
                return true;
            else
                return false;
        }
    }
}
