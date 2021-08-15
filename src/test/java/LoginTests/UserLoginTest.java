package LoginTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserLoginTest {
    @Test(dataProvider = "loginData",groups = "doLogin",priority = 1)
    public void testUserLogin(String [] data)throws Exception{
        if (data[0].length()==0||data[1].length()==0){
            throw new Exception("The fields are empty. The second test has been ignored");
        }
        if(!data[1].contains("@")){
            throw new Exception("Incorrect login/ should contains @. " +
                    "The second test has been ignored");
        }
        System.out.println("User was logged in successfully with login " +data[0]
                + " password "+data[1]+ " and role "+ data[2]);
        }
    @DataProvider(name = "loginData")
    public Object[][] enterData(){
        Object[][] result={
                //{"Alina1991","",""}
                //{"Alina1991","myPass1991","admin"}
                {"Alina1991","myPass@1991","admin"}
        };
        return result;
    }
    @Test(dependsOnGroups = "doLogin",priority = 2)
    public void SecondTest(){
        System.out.println("First test was successful.The second has been ran ");
    }
}
