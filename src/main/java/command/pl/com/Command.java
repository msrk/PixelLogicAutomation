package command.pl.com;

import org.openqa.selenium.By;

public interface Command {
    public void execute(By by);
    public void execute(By by , int index);
    public void execute(By by, String txt, int index);
    public void execute(By by, String txt);
    public void execute(By by, String txt, String txt2);


}
