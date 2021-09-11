package ua.hillel.tests.selenidTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Selenid.DynamicControlPage;

public class DynamicControlsTests extends BaseSelenideTest{
    @Test
    public void addOrRemoveCheckbox(){
        DynamicControlPage dynamicControlPage = openUrl().goToDynamicControlPage()
                .setCheckbox()
                .removeCheckbox(true);
        Assert.assertTrue(dynamicControlPage.getSuccessMessage().contains("It's gone!"));
        dynamicControlPage.removeCheckbox(true);
        Assert.assertTrue(dynamicControlPage.getSuccessMessage().contains("It's back!"));
        dynamicControlPage.setCheckbox()
                .enableButton(true);
        Assert.assertTrue(dynamicControlPage.getSuccessMessage().contains("It's enabled!"));
        dynamicControlPage.enableButton(false);
        Assert.assertTrue(dynamicControlPage.getSuccessMessage().contains("It's disabled!"));
    }
}
