package test.pl.com;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class MainClass {
    public static void main(String[] args) {

        TestNG testngRunner = new TestNG();
        //To run tests in Parallel mode
        testngRunner.setParallel(XmlSuite.ParallelMode.METHODS);
        //Provide the list of test classes
        testngRunner.setTestClasses(new Class[] {
                test.pl.com.CreateAccountTest.class});
        //Run tests
        testngRunner.run();
    }
}
