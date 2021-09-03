package ua.hillel.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengingDom extends Base {
    @Test
    public void uiTest() {
        List<WebElement> columnSit = openSite()
                .goToChallengingDom()
                .clickButtons()
                .getColumnSit();
    }
}
