package testApp;

import App.Application;
import org.testng.annotations.Test;

public class testApp {
    @Test
    public void runTest(){
        Application application=new Application();
        application.setAppInfo();
        System.out.println("After main i said cool");
    }
}
