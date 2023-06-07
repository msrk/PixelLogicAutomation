package model.pl.com;

import org.openqa.selenium.By;

public class ByMachine {
    public ByMachine(String st, String locator) {
        if (st.equals("CssSelector"))
            by = By.cssSelector(locator);
        else if (st.equals(("XPath")))
            by = By.xpath(locator);

    else if(st.equals(("Link")))
    by=By.linkText(locator);
}

    By by;

    public By By(){
        return by;
    }
}
