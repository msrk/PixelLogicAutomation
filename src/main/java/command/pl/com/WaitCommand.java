package command.pl.com;

import org.openqa.selenium.By;

public interface WaitCommand {

    public void execute(By by);
    public void executec(By by);
    public void executea(By by, String name);
}
