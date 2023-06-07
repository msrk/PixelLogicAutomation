package command.pl.com;

import org.openqa.selenium.By;

public class WaitCommandControl {
    WaitCommand cmd;
    public WaitCommandControl(){}

    public void setCommand(WaitCommand cmd){
        this.cmd=cmd;
    }

    public void waitUntilVisibleWitthText(By by, String name){
        cmd.executea(by,"");
    }
    public void waitUntilVisible(By by){
        cmd.execute(by);
    }

    public void waitUntilVisible2(By by){
        cmd.executec(by);
    }

}
