package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Hovers extends Base {
    @Test
    public void getNameByHover() {
        List<WebElement> usersName=openSite()
                .goToHovers()
                .getUserName();
    }
}


