package command.pl.com;

import org.openqa.selenium.By;

public class CommandControl {
    Command cmd;
    public CommandControl(){}
    public void setCommand(Command cmd){
        this.cmd=cmd;
    }

    public void performClick(By by){
        cmd.execute(by);
    }

    

    public void performClickOnSpecificIndex(By by, int index){
        cmd.execute(by, index);
    }

    public void performSendKeys(By by, String txt) {
        cmd.execute(by, txt);
    }
    public void attrib(By by, String txt, String txt2) {
        cmd.execute(by, txt, txt2);
    }
    public void attrib3(By by, String txt){
        cmd.execute(by, txt, 0);
    }



    public void performSendKeysOnSpecificIndex(By by, String txt, int index ){
        cmd.execute(by, txt, index);
    }
}
