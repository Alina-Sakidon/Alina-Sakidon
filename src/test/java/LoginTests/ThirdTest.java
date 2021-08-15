package LoginTests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ThirdTest {
    @Parameters({"extension","browser"})
    @Test(priority = 3)
    public void loginToApp(String url, String browser){
        System.out.println("The third test has bee ran. You should choose in "+browser +" some translator like "+url);
    }

}
